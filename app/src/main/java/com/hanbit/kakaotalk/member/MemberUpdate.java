package com.hanbit.kakaotalk.member;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit.kakaotalk.action.IDetail;
import com.hanbit.kakaotalk.action.IUpdate;
import com.hanbit.kakaotalk.factory.CompositeCompo;
import com.hanbit.kakaotalk.factory.ReadQuery;
import com.hanbit.kakaotalk.factory.WriteQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hb2008 on 2017-03-15.
 */

public class MemberUpdate extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=this.getIntent();
        final String id=intent.getExtras().getString("id").toString();
        final Context context= MemberUpdate.this;
        HashMap<?,?>initMap=init(context);


        final MemDetail memberDetail=new MemDetail(context);
        final MemUpdate memberUpdate=new MemUpdate(context);

        IDetail service=new IDetail() {
            @Override
            public List<?> list(String params) {
                return memberDetail.list("select _id AS id,name,phone,age,address,salary from member where _id='"+params+"';");
            }
        };
        final ArrayList<Map<String,String>> member= (ArrayList<Map<String, String>>) service.list(id);
        final String[] orinalVal={member.get(0).get("phone"),member.get(0).get("address"),member.get(0).get("salary")};
        TextView tvIdContent= (TextView) initMap.get("uId");
        tvIdContent.setText(member.get(0).get("id"));
        TextView tvNameContent= (TextView) initMap.get("uName");
        tvNameContent.setText(member.get(0).get("name"));
        final EditText etPhoneContent= (EditText) initMap.get("uPhone");
        etPhoneContent.setHint(member.get(0).get("phone"));
        TextView tvAgeContent= (TextView) initMap.get("uAge");
        tvAgeContent.setText(member.get(0).get("age"));
        final EditText etAddressContent= (EditText) initMap.get("uAddress");
        etAddressContent.setHint(member.get(0).get("address"));
        final EditText etSalaryContent= (EditText) initMap.get("uSalary");
        etSalaryContent.setHint(member.get(0).get("salary"));
        LinearLayout ui= (LinearLayout) initMap.get("MemberUpdate");
        setContentView(ui);

        final IUpdate updateService=new IUpdate() {
            @Override
            public void update(Map<?, ?> map) {
                String phone= map.get("phone").equals("")?orinalVal[0]:(String) map.get("phone");
                String address= map.get("address").equals("")?orinalVal[1]:(String) map.get("address");
                String salary= map.get("salary").equals("")?orinalVal[2]:(String) map.get("salary");
                String sql=String.format("update member set phone='%s',address='%s',salary='%s' where _id='%s'",phone,address,salary,id);
                memberUpdate.update(sql);
            }
        };

        final Map<String,String>map=new HashMap<>();
        Button btConfirm= (Button) initMap.get("Confirm");
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put("phone",etPhoneContent.getText().toString());
                map.put("address",etAddressContent.getText().toString());
                map.put("salary",etSalaryContent.getText().toString());
                updateService.update(map);
                Intent intent=new Intent(context,MemberDetail.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        Button btCancel= (Button) initMap.get("Cancel");
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,MemberList.class));
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
    class MemUpdate extends WriteQuery {
        public MemUpdate(Context context) {
            super(context);
        }
        @Override
        public void update(String sql) {
            super.getDatabase().execSQL(sql);
        }
    }
    public HashMap<?,?> init(Context context){
        CompositeCompo compo=new CompositeCompo(context,"MemberUpdate");
        compo.execute();
        setContentView(compo.getFrame());
        return compo.getComponents();
    }
}