package com.example.image_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class ImageActivity extends AppCompatActivity {

    private int[] fruit = {R.id.appleView,R.id.bananaView,
            R.id.grapeView,R.id.kiwieView,
            R.id.lemonView,R.id.melonView,
            R.id.orangeView,R.id.pineappleView,
            R.id.tomatoView,R.id.watermelonView};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageactivity_layout);
    }

    public void onClick(View v) {

        int length = fruit.length;

        for(int i = 0; i < length; i++)
        {
            if (v.getId() == fruit[i]){

                Intent view_intent = new Intent(ImageActivity.this,ViewActivity.class);

                view_intent.putExtra("IMG_ID",i);
                startActivity(view_intent);
            }
        }
    }
}