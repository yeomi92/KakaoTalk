package com.hanbit.kakaotalk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit.kakaotalk.factory.CompositeCompo;
import com.hanbit.kakaotalk.member.MemberList;

import java.util.HashMap;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = Index.this;
        HashMap<?,?>map=init(context);
        Button button= (Button) map.get("GoListButton");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MemberList.class));
            }
        });
    }
    public HashMap<?,?> init(Context context){
        CompositeCompo compo=new CompositeCompo(context,"Index");
        compo.execute();
        setContentView(compo.getFrame());
        return compo.getComponents();
    }
}