package com.example.lenovo.test5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class CameraActivity extends AppCompatActivity {

    public RelativeLayout relativeLayout1;
    public RelativeLayout relativeLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        relativeLayout1 =findViewById(R.id.xuexiao);
        relativeLayout2 =findViewById(R.id.xiaozhang);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CameraActivity.this,XueyuanActivity.class);
                startActivity(intent1);
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CameraActivity.this,LingdaoActivity.class);
                startActivity(intent1);
            }
        });

    }
}
