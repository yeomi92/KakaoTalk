package com.hanbit.kakaotalk.member;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit.kakaotalk.action.IDetail;
import com.hanbit.kakaotalk.factory.CompositeCompo;
import com.hanbit.kakaotalk.factory.ReadQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hb2008 on 2017-03-15.
 */

public class MemberDetail extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=this.getIntent();
        final String id=intent.getExtras().getString("id").toString();
        final Context context=MemberDetail.this;
        HashMap<?,?>initMap=init(context);
        final MemDetail memberDetail=new MemDetail(context);
        IDetail service=new IDetail() {
            @Override
            public List<?> list(String params) {
                return memberDetail.list("select _id AS id,name,phone,age,address,salary from member where _id='"+params+"';");
            }
        };
        final ArrayList<Map<String,String>> member= (ArrayList<Map<String, String>>) service.list(id);
        TextView tvIdContent=(TextView)initMap.get("Id");
        tvIdContent.setText(member.get(0).get("id"));
        TextView tvNameContent=(TextView)initMap.get("Name");
        tvNameContent.setText(member.get(0).get("name"));
        TextView tvPhoneContent=(TextView)initMap.get("Phone");
        tvPhoneContent.setText(member.get(0).get("phone"));
        TextView tvAgeContent=(TextView)initMap.get("Age");
        tvAgeContent.setText(member.get(0).get("age"));
        TextView tvAddressContent=(TextView)initMap.get("Address");
        tvAddressContent.setText(member.get(0).get("address"));
        TextView tvSalaryContent=(TextView)initMap.get("Salary");
        tvSalaryContent.setText(member.get(0).get("salary"));
        LinearLayout ui=(LinearLayout)initMap.get("MemberDetail");
        setContentView(ui);
        Button btDial=(Button)initMap.get("Dial");
        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+member.get(0).get("phone")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Button btList=(Button)initMap.get("GoList");
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));

            }
        });
        Button btUpdate=(Button)initMap.get("GoUpdate");
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MemberUpdate.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
    class MemDetail extends ReadQuery {

        public MemDetail(Context context) {
            super(context);
        }

        @Override
        public List<?> list(String sql) {
            Map<String,String> map;
            ArrayList<Map<String,String>> members=new ArrayList<>();
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);
            if(cursor!=null) {
                if (cursor.moveToNext()){
                    map=new HashMap<>();
                    map.put("id",cursor.getString(cursor.getColumnIndex("id")));
                    map.put("name",cursor.getString(cursor.getColumnIndex("name")));
                    map.put("age",cursor.getString(cursor.getColumnIndex("age")));
                    map.put("phone",cursor.getString(cursor.getColumnIndex("phone")));
                    map.put("address",cursor.getString(cursor.getColumnIndex("address")));
                    map.put("salary",cursor.getString(cursor.getColumnIndex("salary")));
                    members.add(map);
                }
            }
            return members;
        }
    }
    public HashMap<?,?> init(Context context){
        CompositeCompo compo=new CompositeCompo(context,"MemberDetail");
        compo.execute();
        setContentView(compo.getFrame());
        return compo.getComponents();
    }
}
