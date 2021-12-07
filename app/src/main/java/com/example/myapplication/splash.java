package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    finish();
                    Intent ii = new Intent(splash.this, MainActivity.class);
                    startActivity(ii);

                }
                catch (InterruptedException e){
                    e.getStackTrace();
                }
            }
        };
        t.start();
    }
}