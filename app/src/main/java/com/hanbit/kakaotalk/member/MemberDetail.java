package com.hanbit.kakaotalk.member;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hb2008 on 2017-03-15.
 */

public class MemberDetail extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=MemberDetail.this;
        LinearLayout ui=new LinearLayout(context);
        LinearLayout.LayoutParams matchAndMatch=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams matchAndWrap=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams wrapAndMatch=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams wrapAndWrap=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        ui.setOrientation(LinearLayout.VERTICAL);
        ui.setLayoutParams(matchAndMatch);
        LinearLayout uiId=new LinearLayout(context);
        uiId.setLayoutParams(matchAndWrap);
        TextView tvId=new TextView(context);
        tvId.setText("ID: ");
        tvId.setLayoutParams(wrapAndWrap);
        tvId.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvIdContent=new TextView(context);
        tvIdContent.setText("ID content");
        tvIdContent.setLayoutParams(wrapAndWrap);
        tvIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiId.addView(tvId);
        uiId.addView(tvIdContent);
        ui.addView(uiId);
        LinearLayout uiName=new LinearLayout(context);
        uiName.setLayoutParams(matchAndWrap);
        TextView tvName=new TextView(context);
        tvName.setText("NAME: ");
        tvName.setLayoutParams(wrapAndWrap);
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvNameContent=new TextView(context);
        tvNameContent.setText("NAME content");
        tvNameContent.setLayoutParams(wrapAndWrap);
        tvNameContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiName.addView(tvName);
        uiName.addView(tvNameContent);
        ui.addView(uiName);
        LinearLayout uiPhone=new LinearLayout(context);
        uiPhone.setLayoutParams(matchAndWrap);
        TextView tvPhone=new TextView(context);
        tvPhone.setText("PHONE: ");
        tvPhone.setLayoutParams(wrapAndWrap);
        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvPhoneContent=new TextView(context);
        tvPhoneContent.setText("PHONE content");
        tvPhoneContent.setLayoutParams(wrapAndWrap);
        tvPhoneContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiPhone.addView(tvPhone);
        uiPhone.addView(tvPhoneContent);
        ui.addView(uiPhone);
        LinearLayout uiAge=new LinearLayout(context);
        uiAge.setLayoutParams(matchAndWrap);
        TextView tvAge=new TextView(context);
        tvAge.setText("AGE: ");
        tvAge.setLayoutParams(wrapAndWrap);
        tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvAgeContent=new TextView(context);
        tvAgeContent.setText("AGE content");
        tvAgeContent.setLayoutParams(wrapAndWrap);
        tvAgeContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAge.addView(tvAge);
        uiAge.addView(tvAgeContent);
        ui.addView(uiAge);
        LinearLayout uiAddress=new LinearLayout(context);
        uiAddress.setLayoutParams(matchAndWrap);
        TextView tvAddress=new TextView(context);
        tvAddress.setText("ADDRESS: ");
        tvAddress.setLayoutParams(wrapAndWrap);
        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvAddressContent=new TextView(context);
        tvAddressContent.setText("ADDRESS content");
        tvAddressContent.setLayoutParams(wrapAndWrap);
        tvAddressContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAddress.addView(tvAddress);
        uiAddress.addView(tvAddressContent);
        ui.addView(uiAddress);
        LinearLayout uiSalary=new LinearLayout(context);
        uiSalary.setLayoutParams(matchAndWrap);
        TextView tvSalary=new TextView(context);
        tvSalary.setText("SALARY: ");
        tvSalary.setLayoutParams(wrapAndWrap);
        tvSalary.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        TextView tvSalaryContent=new TextView(context);
        tvSalaryContent.setText("SALARY content");
        tvSalaryContent.setLayoutParams(wrapAndWrap);
        tvSalaryContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiSalary.addView(tvSalary);
        uiSalary.addView(tvSalaryContent);
        ui.addView(uiSalary);
        LinearLayout uiButton1=new LinearLayout(context);
        uiButton1.setLayoutParams(matchAndWrap);
        Button btLocation=new Button(context);
        btLocation.setLayoutParams(weight);
        btLocation.setText("LOCATION");
        btLocation.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btGoogleMap=new Button(context);
        btGoogleMap.setLayoutParams(weight);
        btGoogleMap.setText("GOOGLE MAP");
        btGoogleMap.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton1.addView(btLocation);
        uiButton1.addView(btGoogleMap);
        ui.addView(uiButton1);
        LinearLayout uiButton2=new LinearLayout(context);
        uiButton2.setLayoutParams(matchAndWrap);
        Button btGallery=new Button(context);
        btGallery.setLayoutParams(weight);
        btGallery.setText("GALLERY");
        btGallery.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btMusic=new Button(context);
        btMusic.setLayoutParams(weight);
        btMusic.setText("MUSIC");
        btMusic.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton2.addView(btGallery);
        uiButton2.addView(btMusic);
        ui.addView(uiButton2);
        LinearLayout uiButton3=new LinearLayout(context);
        uiButton3.setLayoutParams(matchAndWrap);
        Button btSMS=new Button(context);
        btSMS.setLayoutParams(weight);
        btSMS.setText("SMS");
        btSMS.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btMail=new Button(context);
        btMail.setLayoutParams(weight);
        btMail.setText("MAIL");
        btMail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton3.addView(btSMS);
        uiButton3.addView(btMail);
        ui.addView(uiButton3);
        LinearLayout uiButton4=new LinearLayout(context);
        uiButton4.setLayoutParams(matchAndWrap);
        Button btDial=new Button(context);
        btDial.setLayoutParams(weight);
        btDial.setText("DIAL");
        btDial.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btCall=new Button(context);
        btCall.setLayoutParams(weight);
        btCall.setText("CALL");
        btCall.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton4.addView(btDial);
        uiButton4.addView(btCall);
        ui.addView(uiButton4);
        LinearLayout uiButton5=new LinearLayout(context);
        uiButton5.setLayoutParams(matchAndWrap);
        Button btList=new Button(context);
        btList.setLayoutParams(weight);
        btList.setText("LIST");
        btList.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        Button btUpdate=new Button(context);
        btUpdate.setLayoutParams(weight);
        btUpdate.setText("UPDATE");
        btUpdate.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiButton5.addView(btList);
        uiButton5.addView(btUpdate);
        ui.addView(uiButton5);
        setContentView(ui);
        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "));
                //intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + map.get("phoneNum")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));

            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MemberUpdate.class);
                intent.putExtra("id","");
                //intent.putExtra("id",map.get("id"));
                startActivity(intent);
            }
        });
    }
}
