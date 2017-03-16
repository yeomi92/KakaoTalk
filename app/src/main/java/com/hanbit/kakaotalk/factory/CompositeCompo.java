package com.hanbit.kakaotalk.factory;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by hb2008 on 2017-03-16.
 */

public class CompositeCompo {
    interface IComposite{public void execute();}
    final HashMap<String,Object>map=new HashMap<>();
    LinearLayout frame;
    String order;
    Context context;

    public CompositeCompo(Context context, String order) {
        this.context = context;
        this.order=order;
    }

    public LinearLayout getFrame() {
        return frame;
    }

    public HashMap<String,Object> getComponents(){
        return map;
    }

    public void execute() {
        new LinearLayoutCompo().service.execute();
        new ButtonCompo().service.execute();
        new TextViewCompo().service.execute();
        new ListViewCompo().service.execute();
        switch(order){
            case "Index":
                frame= (LinearLayout) map.get(order);
                frame.addView((android.widget.TextView) map.get("KakaoTalkTextView"));
                frame.addView((android.widget.Button) map.get("GoListButton"));
                break;
            case "MemberList":
                frame= (LinearLayout) map.get(order);
                frame.addView((View) map.get("MemberListView"));
                break;
            case "MemberDetail":
                frame= (LinearLayout) map.get(order);
                frame.addView((LinearLayout) map.get("IdLayout"));
                frame.addView((LinearLayout) map.get("NameLayout"));
                frame.addView((LinearLayout) map.get("PhoneLayout"));
                frame.addView((LinearLayout) map.get("AgeLayout"));
                frame.addView((LinearLayout) map.get("AddressLayout"));
                frame.addView((LinearLayout) map.get("SalaryLayout"));
                frame.addView((LinearLayout) map.get("ButtonLayout1"));
                frame.addView((LinearLayout) map.get("ButtonLayout2"));
                frame.addView((LinearLayout) map.get("ButtonLayout3"));
                frame.addView((LinearLayout) map.get("ButtonLayout4"));
                frame.addView((LinearLayout) map.get("ButtonLayout5"));
                break;
        }
    }

    class ButtonCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {
                Button button = null;
                switch (order){
                    case "Index":
                        button = new Button(context);
                        button.setText("go list");
                        button.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        button.setBackgroundColor(Color.parseColor("#ffff33"));
                        button.setTextSize(20);
                        ViewGroup.MarginLayoutParams btnMargin=new ViewGroup.MarginLayoutParams(button.getLayoutParams());
                        btnMargin.setMargins(0,300,0,0);
                        button.setLayoutParams(new LinearLayout.LayoutParams(btnMargin));
                        map.put("GoListButton",button);
                        break;
                    case "MemberDetail":
                        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
                        /*Button1 row */
                        LinearLayout uiButton1=new LinearLayout(context);
                        uiButton1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
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
                        /*Button2 row */
                        LinearLayout uiButton2=new LinearLayout(context);
                        uiButton2.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
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
                        /*Button3 row */
                        LinearLayout uiButton3=new LinearLayout(context);
                        uiButton3.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
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
                        /*Button4 row */
                        LinearLayout uiButton4=new LinearLayout(context);
                        uiButton4.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
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
                        /*Button5 row */
                        LinearLayout uiButton5=new LinearLayout(context);
                        uiButton5.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
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
                        map.put("Dial",btDial);
                        map.put("GoList",btList);
                        map.put("GoUpdate",btUpdate);
                        map.put("ButtonLayout1",uiButton1);
                        map.put("ButtonLayout2",uiButton2);
                        map.put("ButtonLayout3",uiButton3);
                        map.put("ButtonLayout4",uiButton4);
                        map.put("ButtonLayout5",uiButton5);
                        break;
                }
            }
        };
    }
    class TextViewCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {
                TextView textView=null;
                switch (order){
                    case "Index":
                        textView=new TextView(context);
                        textView.setText("KAKAO TALK");
                        textView.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        textView.setGravity(Gravity.CENTER);
                        textView.setTextSize(30);
                        textView.setBackgroundColor(Color.parseColor("#ffffff"));
                        ViewGroup.MarginLayoutParams margin=new ViewGroup.MarginLayoutParams(textView.getLayoutParams());
                        margin.setMargins(0,300,0,0);
                        textView.setLayoutParams(new LinearLayout.LayoutParams(margin));
                        map.put("KakaoTalkTextView",textView);
                        break;
                    case "MemberDetail":
                        /* ID row */
                        LinearLayout uiId=new LinearLayout(context);
                        uiId.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvId=new TextView(context);
                        tvId.setText("NAME: ");
                        tvId.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvId.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvIdContent=new TextView(context);
                        tvIdContent.setText("NAME content");
                        tvIdContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        uiId.addView(tvId);
                        uiId.addView(tvIdContent);
                        /* Name row */
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
                        /* Phone row */
                        LinearLayout uiPhone=new LinearLayout(context);
                        uiPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvPhone=new TextView(context);
                        tvPhone.setText("PHONE: ");
                        tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvPhoneContent=new TextView(context);
                        tvPhoneContent.setText("PHONE content");
                        tvPhoneContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvPhoneContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        uiPhone.addView(tvPhone);
                        uiPhone.addView(tvPhoneContent);
                        /* Age row */
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
                        /* Address row */
                        LinearLayout uiAddress=new LinearLayout(context);
                        uiAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvAddress=new TextView(context);
                        tvAddress.setText("ADDRESS: ");
                        tvAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvAddressContent=new TextView(context);
                        tvAddressContent.setText("ADDRESS content");
                        tvAddressContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvAddressContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        uiAddress.addView(tvAddress);
                        uiAddress.addView(tvAddressContent);
                        /* Salary row */
                        LinearLayout uiSalary=new LinearLayout(context);
                        uiSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvSalary=new TextView(context);
                        tvSalary.setText("SALARY: ");
                        tvSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvSalary.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvSalaryContent=new TextView(context);
                        tvSalaryContent.setText("SALARY content");
                        tvSalaryContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvSalaryContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        uiSalary.addView(tvSalary);
                        uiSalary.addView(tvSalaryContent);
                        map.put("Id",tvIdContent);
                        map.put("Name",tvNameContent);
                        map.put("Phone",tvPhoneContent);
                        map.put("Age",tvAgeContent);
                        map.put("Address",tvAddressContent);
                        map.put("Salary",tvSalaryContent);
                        map.put("IdLayout",uiId);
                        map.put("NameLayout",uiName);
                        map.put("PhoneLayout",uiPhone);
                        map.put("AgeLayout",uiAge);
                        map.put("AddressLayout",uiAddress);
                        map.put("SalaryLayout",uiSalary);
                        break;
                }
            }
        };
    }
    class EditTextCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {

            }
        };
    }
    class ListViewCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {
                ListView listView=null;
                switch(order){
                    case "MemberList":
                        listView=new ListView(context);
                        listView.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                        map.put("MemberListView",listView);
                        break;
                }
            }
        };
    }
    class LinearLayoutCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {
                LinearLayout frame=null;
                switch (order){
                    case "Index":case "MemberList":case "MemberDetail":
                        frame=new LinearLayout(context);
                        frame.setOrientation(LinearLayout.VERTICAL);
                        frame.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                        map.put(order,frame);
                        break;
                }
            }
        };
    }
}
