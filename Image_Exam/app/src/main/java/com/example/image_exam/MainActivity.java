package com.example.image_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // 화면 터치시 실행되는 메소드
    public void onClick(View v) {

        // 화면 전환을 위한 Intent 객체 생성
        Intent img_intent = new Intent(MainActivity.this, ImageActivity.class);

        startActivity(img_intent);

    }
}