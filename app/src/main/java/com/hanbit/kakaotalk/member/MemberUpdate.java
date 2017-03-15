package com.hanbit.kakaotalk.member;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hanbit.kakaotalk.action.IDetail;
import com.hanbit.kakaotalk.action.IUpdate;
import com.hanbit.kakaotalk.factory.LayoutParamsFactory;
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
        LinearLayout ui=new LinearLayout(context);
        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));

        LinearLayout uiId=new LinearLayout(context);
        uiId.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvId=new TextView(context);
        tvId.setText("ID: ");
        tvId.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvId.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvIdContent=new TextView(context);
        tvIdContent.setText("ID content");
        tvIdContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiId.addView(tvId);
        uiId.addView(tvIdContent);
        ui.addView(uiId);

        LinearLayout uiName=new LinearLayout(context);
        uiName.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvName=new TextView(context);
        tvName.setText("NAME: ");
        tvName.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvNameContent=new TextView(context);
        tvNameContent.setText("NAME content");
        tvNameContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvNameContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiName.addView(tvName);
        uiName.addView(tvNameContent);
        ui.addView(uiName);

        LinearLayout uiPhone=new LinearLayout(context);
        uiPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvPhone=new TextView(context);
        tvPhone.setText("PHONE: ");
        tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        final EditText etPhoneContent=new EditText(context);
        etPhoneContent.setHint("PHONE content");
        etPhoneContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etPhoneContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiPhone.addView(tvPhone);
        uiPhone.addView(etPhoneContent);
        ui.addView(uiPhone);

        LinearLayout uiAge=new LinearLayout(context);
        uiAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAge=new TextView(context);
        tvAge.setText("AGE: ");
        tvAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvAgeContent=new TextView(context);
        tvAgeContent.setText("AGE content");
        tvAgeContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAgeContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAge.addView(tvAge);
        uiAge.addView(tvAgeContent);
        ui.addView(uiAge);

        LinearLayout uiAddress=new LinearLayout(context);
        uiAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAddress=new TextView(context);
        tvAddress.setText("ADDRESS: ");
        tvAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        final EditText etAddressContent=new EditText(context);
        etAddressContent.setHint("ADDRESS content");
        etAddressContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etAddressContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAddress.addView(tvAddress);
        uiAddress.addView(etAddressContent);
        ui.addView(uiAddress);

        LinearLayout uiSalary=new LinearLayout(context);
        uiSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvSalary=new TextView(context);
        tvSalary.setText("SALARY: ");
        tvSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvSalary.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        final EditText etSalaryContent=new EditText(context);
        etSalaryContent.setHint("SALARY content");
        etSalaryContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etSalaryContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiSalary.addView(tvSalary);
        uiSalary.addView(etSalaryContent);
        ui.addView(uiSalary);

        LinearLayout uiButton=new LinearLayout(context);
        uiButton.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        Button btCancel=new Button(context);
        btCancel.setLayoutParams(weight);
        btCancel.setText("CANCEL");
        btCancel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btConfirm=new Button(context);
        btConfirm.setLayoutParams(weight);
        btConfirm.setText("CONFIRM");
        btConfirm.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton.addView(btCancel);
        uiButton.addView(btConfirm);
        ui.addView(uiButton);

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
        tvIdContent.setText(member.get(0).get("id"));
        tvNameContent.setText(member.get(0).get("name"));
        etPhoneContent.setHint(member.get(0).get("phone"));
        tvAgeContent.setText(member.get(0).get("age"));
        etAddressContent.setHint(member.get(0).get("address"));
        etSalaryContent.setHint(member.get(0).get("salary"));
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
}