package com.hanbit.kakaotalk.factory;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
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
                frame = (LinearLayout) map.get(order);
                frame.addView((TextView) map.get("KakaoTalkTextView"));
                frame.addView((Button) map.get("GoListButton"));
                break;
            case "MemberList":
                frame = (LinearLayout) map.get(order);
                frame.addView((ListView) map.get("MemberListView"));
                break;
            case "MemberDetail":
                frame = (LinearLayout) map.get(order);
                frame.addView((TextView) map.get("tvDetail"));
                LinearLayout uiId = (LinearLayout) map.get("uiId");
                uiId.addView((TextView) map.get("id"));
                uiId.addView((TextView) map.get("Id"));
                frame.addView(uiId);
                LinearLayout uiName = (LinearLayout) map.get("uiName");
                uiName.addView((TextView) map.get("name"));
                uiName.addView((TextView) map.get("Name"));
                frame.addView(uiName);
                LinearLayout uiPhone = (LinearLayout) map.get("uiPhone");
                uiPhone.addView((TextView) map.get("phone"));
                uiPhone.addView((TextView) map.get("Phone"));
                frame.addView(uiPhone);
                LinearLayout uiAge = (LinearLayout) map.get("uiAge");
                uiAge.addView((TextView) map.get("age"));
                uiAge.addView((TextView) map.get("Age"));
                frame.addView(uiAge);
                LinearLayout uiAddress = (LinearLayout) map.get("uiAddress");
                uiAddress.addView((TextView) map.get("address"));
                uiAddress.addView((TextView) map.get("Address"));
                frame.addView(uiAddress);
                LinearLayout uiSalary = (LinearLayout) map.get("uiSalary");
                uiSalary.addView((TextView) map.get("salary"));
                uiSalary.addView((TextView) map.get("Salary"));
                frame.addView(uiSalary);
                LinearLayout temp1 = (LinearLayout) map.get("llDetailBtns1");
                temp1.addView((Button) map.get("Location"));
                temp1.addView((Button) map.get("GoogleMap"));
                frame.addView(temp1);
                LinearLayout temp2 = (LinearLayout) map.get("llDetailBtns2");
                temp2.addView((Button) map.get("Gallery"));
                temp2.addView((Button) map.get("Music"));
                frame.addView(temp2);
                LinearLayout temp3 = (LinearLayout) map.get("llDetailBtns3");
                temp3.addView((Button) map.get("SMS"));
                temp3.addView((Button) map.get("Mail"));
                frame.addView(temp3);
                LinearLayout temp4 = (LinearLayout) map.get("llDetailBtns4");
                temp4.addView((Button) map.get("Dial"));
                temp4.addView((Button) map.get("Call"));
                frame.addView(temp4);
                LinearLayout temp5 = (LinearLayout) map.get("llDetailBtns5");
                temp5.addView((Button) map.get("GoList"));
                temp5.addView((Button) map.get("GoUpdate"));
                frame.addView(temp5);
                break;
            case "MemberUpdate":
                frame = (LinearLayout) map.get(order);
                frame.addView((TextView) map.get("tvUpdate"));
                LinearLayout uUiId = (LinearLayout) map.get("uUiId");
                uUiId.addView((TextView) map.get("uid"));
                uUiId.addView((TextView) map.get("uId"));
                frame.addView(uUiId);
                LinearLayout uUiName = (LinearLayout) map.get("uUiName");
                uUiName.addView((TextView) map.get("uname"));
                uUiName.addView((TextView) map.get("uName"));
                frame.addView(uUiName);
                LinearLayout uUiPhone = (LinearLayout) map.get("uUiPhone");
                uUiPhone.addView((TextView) map.get("uphone"));
                uUiPhone.addView((TextView) map.get("uPhone"));
                frame.addView(uUiPhone);
                LinearLayout uUiAge = (LinearLayout) map.get("uUiAge");
                uUiAge.addView((TextView) map.get("uage"));
                uUiAge.addView((TextView) map.get("uAge"));
                frame.addView(uUiAge);
                LinearLayout uUiAddress = (LinearLayout) map.get("uUiAddress");
                uUiAddress.addView((TextView) map.get("uaddress"));
                uUiAddress.addView((TextView) map.get("uAddress"));
                frame.addView(uUiAddress);
                LinearLayout uUiSalary = (LinearLayout) map.get("uUiSalary");
                uUiSalary.addView((TextView) map.get("usalary"));
                uUiSalary.addView((TextView) map.get("uSalary"));
                frame.addView(uUiSalary);
                LinearLayout uUiButtons = (LinearLayout) map.get("uUiButtons");
                uUiButtons.addView((Button) map.get("Cancel"));
                uUiButtons.addView((Button) map.get("Confirm"));
                frame.addView(uUiButtons);
                break;
        }
    }

    class ButtonCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {
                LinearLayout.LayoutParams mww = Complex.LayoutParamsFactory.create("mw", 1);
                LinearLayout.LayoutParams mw = Complex.LayoutParamsFactory.create("mw");
                switch(order) {
                    case "Index" :
                        int[] btnMarginArr = {0, 300, 0, 0};
                        Button btn = Complex.ButtonFactory.create(context, Complex.LayoutParamsFactory.create("mw"), "Go List", "#ffd700" ,"#000000", btnMarginArr);
                        ViewGroup.MarginLayoutParams marginTmp = new ViewGroup.MarginLayoutParams(mw);
                        marginTmp.setMargins(0, 100, 0, 0);
                        btn.setLayoutParams(new LinearLayout.LayoutParams(marginTmp));
                        btn.setTextSize(20);
                        map.put("GoListButton",btn);
                        break;
                    case "MemberDetail":
                        map.put("Location", Complex.ButtonFactory.create(context, mww, "MY LOCATION"));
                        map.put("GoogleMap", Complex.ButtonFactory.create(context, mww, "GOOGLE MAP"));
                        map.put("Gallery", Complex.ButtonFactory.create(context, mww, "ALBUM"));
                        map.put("Music", Complex.ButtonFactory.create(context, mww, "GALLERY"));
                        map.put("SMS", Complex.ButtonFactory.create(context, mww, "SMS"));
                        map.put("Mail", Complex.ButtonFactory.create(context, mww, "MAIL"));
                        map.put("Dial", Complex.ButtonFactory.create(context, mww, "DIAL"));
                        map.put("Call", Complex.ButtonFactory.create(context, mww, "CALL"));
                        map.put("GoUpdate", Complex.ButtonFactory.create(context, mww, "UPDATE"));
                        map.put("GoList", Complex.ButtonFactory.create(context, mww, "LIST"));
                        break;
                    case "MemberUpdate":
                        map.put("Cancel", Complex.ButtonFactory.create(context, mww, "CANCEL"));
                        map.put("Confirm", Complex.ButtonFactory.create(context, mww, "CONFIRM"));
                        break;
                }
            }
        };
    }
    class TextViewCompo{
        IComposite service=new IComposite() {
            @Override
            public void execute() {
                LinearLayout.LayoutParams mw = Complex.LayoutParamsFactory.create("mw");
                LinearLayout.LayoutParams ww = Complex.LayoutParamsFactory.create("ww");
                TextView tv = new TextView(context);
                switch (order) {
                    case "Index":
                        tv = Complex.TextViewFactory.create(context, mw, "KAKAO TALK", 30);
                        tv.setTextColor(Color.parseColor("#000000"));
                        ViewGroup.MarginLayoutParams marginIndex = new ViewGroup.MarginLayoutParams(Complex.LayoutParamsFactory.create("mw"));
                        marginIndex.setMargins(0, 200, 0, 0);
                        tv.setLayoutParams(new LinearLayout.LayoutParams(marginIndex));
                        tv.setGravity(1);
                        map.put("KakaoTalkTextView",tv);
                        break;
                    case "MemberDetail":
                        map.put("tvDetail", Complex.TextViewFactory.create(context, mw, "상세", 30, "center"));
                        map.put("id", Complex.TextViewFactory.create(context, ww, "Id:", 25));
                        map.put("Id", Complex.TextViewFactory.create(context, ww, "Id", 25));
                        map.put("name", Complex.TextViewFactory.create(context, ww, "Name:", 25));
                        map.put("Name", Complex.TextViewFactory.create(context, ww, "Name", 25));
                        map.put("phone", Complex.TextViewFactory.create(context, ww, "Phone:", 25));
                        map.put("Phone", Complex.TextViewFactory.create(context, ww, "Phone", 25));
                        map.put("age", Complex.TextViewFactory.create(context, ww, "Age:", 25));
                        map.put("Age", Complex.TextViewFactory.create(context, ww, "Age", 25));
                        map.put("address", Complex.TextViewFactory.create(context, ww, "Address:", 25));
                        map.put("Address", Complex.TextViewFactory.create(context, ww, "Address", 25));
                        map.put("salary", Complex.TextViewFactory.create(context, ww, "Salary:", 25));
                        map.put("Salary", Complex.TextViewFactory.create(context, ww, "Salary", 25));
                        break;
                    case "MemberUpdate":
                        map.put("tvUpdate", Complex.TextViewFactory.create(context, mw, "수정", 30, "center"));
                        map.put("uid", Complex.TextViewFactory.create(context, ww, "Id:", 25));
                        map.put("uId", Complex.TextViewFactory.create(context, ww, "Id", 25));
                        map.put("uname", Complex.TextViewFactory.create(context, ww, "Name:", 25));
                        map.put("uName", Complex.TextViewFactory.create(context, ww, "Name", 25));
                        map.put("uphone", Complex.TextViewFactory.create(context, ww, "Phone:", 25));
                        map.put("uPhone", Complex.EditTextFactory.create(context, ww, "Phone", 25));
                        map.put("uage", Complex.TextViewFactory.create(context, ww, "Age:", 25));
                        map.put("uAge", Complex.TextViewFactory.create(context, ww, "Age", 25));
                        map.put("uaddress", Complex.TextViewFactory.create(context, ww, "Address:", 25));
                        map.put("uAddress", Complex.EditTextFactory.create(context, ww, "Address", 25));
                        map.put("usalary", Complex.TextViewFactory.create(context, ww, "Salary:", 25));
                        map.put("uSalary", Complex.EditTextFactory.create(context, ww, "Salary", 25));
                        break;
                    case "Temp":
                        tv.setText("");
                        tv.setGravity(Gravity.CENTER);
                        tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        tv.setTextSize(30);
                        ViewGroup.MarginLayoutParams marginTmp = new ViewGroup.MarginLayoutParams(mw);
                        marginTmp.setMargins(0, 200, 0, 0);
                        tv.setLayoutParams(new LinearLayout.LayoutParams(marginTmp));
                        map.put("tvTemp",tv);
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
                LinearLayout.LayoutParams mm = Complex.LayoutParamsFactory.create("mm");
                LinearLayout.LayoutParams mw = Complex.LayoutParamsFactory.create("mw");
                LinearLayout frame=null;
                switch (order){
                    case "Index":case "MemberList":
                        frame=new LinearLayout(context);
                        frame.setOrientation(LinearLayout.VERTICAL);
                        frame.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                        frame.setBackgroundColor(Color.parseColor("#ffd700"));
                        map.put(order,frame);
                        break;
                    case "MemberDetail":
                        map.put(order, Complex.LinearLayoutFactory.create(context, mm, "v"));
                        map.put("uiId", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uiName", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uiPhone", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uiAge", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uiAddress", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uiSalary", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("llDetailBtns1", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("llDetailBtns2", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("llDetailBtns3", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("llDetailBtns4", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("llDetailBtns5", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        break;
                    case "MemberUpdate":
                        map.put(order, Complex.LinearLayoutFactory.create(context, mm, "v"));
                        map.put("uUiId", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uUiName", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uUiPhone", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uUiAge", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uUiAddress", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uUiSalary", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        map.put("uUiButtons", Complex.LinearLayoutFactory.create(context, mw, "h"));
                        break;
                }
            }
        };
    }
}
