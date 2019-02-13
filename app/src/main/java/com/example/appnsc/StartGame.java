package com.example.appnsc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_game);
        TextView t1 = findViewById(R.id.Start_game);
        t1.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 1){
                            //Single Click
                            Intent it = new Intent(StartGame.this,normalPeoplePage_1.class);
                            //Toast.makeText(MainActivity.this,"Single Click i = "+i,Toast.LENGTH_SHORT).show();
                            startActivity(it);
                        }
                        else {
                            //Double Clicklog
                            Intent it = new Intent(StartGame.this,disablePeoplePage_1.class);
                            //Toast.makeText(MainActivity.this,"Double Click i = "+i,Toast.LENGTH_SHORT).show();
                            startActivity(it);
                        }
                        i = 0;
                    }
                },250);


            }
        });
    }
}
