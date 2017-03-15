package com.hanbit.kakaotalk.member;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hanbit.kakaotalk.factory.LayoutParamsFactory;

/**
 * Created by hb2008 on 2017-03-15.
 */

public class MemberAdd extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context= MemberAdd.this;
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
        EditText etIdContent=new EditText(context);
        etIdContent.setHint("ID content");
        etIdContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiId.addView(tvId);
        uiId.addView(etIdContent);
        ui.addView(uiId);

        LinearLayout uiName=new LinearLayout(context);
        uiName.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvName=new TextView(context);
        tvName.setText("NAME: ");
        tvName.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        EditText etNameContent=new EditText(context);
        etNameContent.setHint("NAME content");
        etNameContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etNameContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiName.addView(tvName);
        uiName.addView(etNameContent);
        ui.addView(uiName);

        LinearLayout uiPhone=new LinearLayout(context);
        uiPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvPhone=new TextView(context);
        tvPhone.setText("PHONE: ");
        tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        EditText etPhoneContent=new EditText(context);
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
        EditText etAgeContent=new EditText(context);
        etAgeContent.setHint("AGE content");
        etAgeContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        etAgeContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        uiAge.addView(tvAge);
        uiAge.addView(etAgeContent);
        ui.addView(uiAge);

        LinearLayout uiAddress=new LinearLayout(context);
        uiAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
        TextView tvAddress=new TextView(context);
        tvAddress.setText("ADDRESS: ");
        tvAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        EditText etAddressContent=new EditText(context);
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
        EditText etSalaryContent=new EditText(context);
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

        setContentView(ui);
    }
}
