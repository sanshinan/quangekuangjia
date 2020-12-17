package com.example.day02_zy;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day02_zy.ui.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private TextView textsize;
    private int i=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        textsize = (TextView) findViewById(R.id.textsize);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        i--;
                        if (i>0){
                            textsize.setText(""+i);
                        }else {
                           startActivity(new Intent(MainActivity.this, LogActivity.class));
                            timer.cancel();
                            finish();
                        }
                    }
                });
            }
        },1000,1000);
    }
}