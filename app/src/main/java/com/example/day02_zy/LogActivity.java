package com.example.day02_zy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day02_zy.ui.LoginActivity;

public class LogActivity extends AppCompatActivity {

    private EditText editQuery;
    private EditText editMm;
    private Button btna;
    private String zh;
    private String mm;
    private String login="H2003xs";
    private String password="H2003";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        initView();
    }

    private void initView() {
        editQuery = (EditText) findViewById(R.id.edit_query);
        editMm = (EditText) findViewById(R.id.edit_mm);
        btna = (Button) findViewById(R.id.btna);

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zh = editQuery.getText().toString();
                mm = editMm.getText().toString();
                if (zh.equals(login)&& mm.equals(password)){
                    startActivity(new Intent(LogActivity.this, LoginActivity.class));
                }else {
                    Toast.makeText(LogActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}