package com.hanbit.kakaotalk.factory;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

import java.util.Map;

/**
 * Created by hb2008 on 2017-03-16.
 */

public class ButtonFatory {
    public static Button createButton(Context context, Map<String, String> buttonMap){
        Button button = new Button(context);
        switch (buttonMap.get("type")){
            case "basic":
                button.setText(buttonMap.get("text"));
                button.setLayoutParams(LayoutParamsFactory.createLayoutParams(buttonMap.get("layoutParams")));
                button.setBackgroundColor(Color.parseColor(buttonMap.get("color")));
                break;
        }
        return button;
    }
}
