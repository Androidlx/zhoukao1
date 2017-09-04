package com.example.lixin.lixin20170904;
/**
 *
 * 主界面
 *
 *
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lixin.lixin20170904.view.MyCustomView;

public class MainActivity extends AppCompatActivity {
    private int color = 1;
    private MyCustomView circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_color = (Button) findViewById(R.id.btn_color);
        circle = (MyCustomView) findViewById(R.id.circle);
        //点击事件
        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circle.setColor(color);
            }
        });
    }
}
