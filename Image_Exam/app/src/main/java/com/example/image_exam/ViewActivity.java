package com.example.image_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ViewActivity extends AppCompatActivity {

    //멤버 변수 선언
    private ImageView full_IMG;
    private int imgID[] = {R.drawable.applesample,
            R.drawable.bananasample,
            R.drawable.grapesample,
            R.drawable.kiwiesample,
            R.drawable.lemonsample,
            R.drawable.melonsample,
            R.drawable.orangesample,
            R.drawable.pineapplesample,
            R.drawable.tomatosample,
            R.drawable.watermelonsample };
    private int IDX = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewactivtty_layout);

        Intent full_view = getIntent();
        IDX = full_view.getIntExtra("IMG_ID",0);
        full_IMG = findViewById(R.id.fullView);
        full_IMG.setImageResource(imgID[IDX]);
    }

    public void onClick(View v) {
        finish();
    }
}