package com.example.appnsc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Runnable;

public class MainActivity extends AppCompatActivity {
    boolean doubleTap = false;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.login_email);
        password = (EditText)findViewById(R.id.login_pass);

        Button btn_regis = findViewById(R.id.register);
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,register.class);
                startActivity(it);
            }
        });


//        Button btn_login = findViewById(R.id.btn_login);
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String use_email = email.getText().toString();
////                String use_pass = password.getText().toString();
////                String type = "login";
////                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
////                backgroundWorker.execute(type, use_email, use_pass);
//
//                Intent it = new Intent(MainActivity.this,StartGame.class);
//                startActivity(it);
//            }
//        });


    }

    public void onLogin(View view){
        String use_email = email.getText().toString();
        String use_pass = password.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, use_email, use_pass);
    }


    @Override
    public void onBackPressed(){
        if (doubleTap) {
            super.onBackPressed();
        }
        else {
            Toast.makeText(this,"Press Again to Exit",Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            },500);
        }
    }


}
