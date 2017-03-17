package com.hanbit.kakaotalk.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hanbit.kakaotalk.factory.Complex;

/**
 * Created by hb2008 on 2017-03-15.
 */

public class MessageWriter extends AppCompatActivity {
    String message="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=MessageWriter.this;
        Intent intent=getIntent();
        String spec=intent.getExtras().getString("spec").toString();
        String id=spec.split(",")[0];
        String phone=spec.split(",")[1];
        String name=spec.split(",")[2];
        LinearLayout ui=new LinearLayout(context);
        ui.setLayoutParams(Complex.LayoutParamsFactory.create("mm"));
        ui.setOrientation(LinearLayout.VERTICAL);
        WebView wv=new WebView(context);
        WebSettings settings=wv.getSettings();
        settings.setUseWideViewPort(true);//http사용하겠다.
        settings.setJavaScriptEnabled(true);
        wv.setLayoutParams(Complex.LayoutParamsFactory.create("mm"));
        wv.setWebViewClient(new WebViewClient());

        wv.addJavascriptInterface(new JavascriptInterface() {
            @Override @android.webkit.JavascriptInterface
            public void showToast(String msg) {
                Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

            }
            @Override @android.webkit.JavascriptInterface
            public void sendMessage(String mgs) {
                message=mgs;
            }
        }, "Hybrid");
        wv.loadUrl("file:///android_asset/www/html/messageWrite.html");
        ui.addView(wv);
        setContentView(ui);
    }
    public interface JavascriptInterface{

        public void showToast(String mgs);
        public void sendMessage(String mgs);
    }
}
