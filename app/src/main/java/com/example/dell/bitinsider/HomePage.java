package com.example.dell.bitinsider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    Button firstButtonHome,secondButtonHome,thirdButtonHome,fourthButtonHome;
    ImageView home,chat,profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        firstButtonHome=(Button)findViewById(R.id.firstButtonHome);
        secondButtonHome=(Button)findViewById(R.id.secondButtonHome);
        thirdButtonHome=(Button)findViewById(R.id.thirdButtonHome);
        fourthButtonHome=(Button)findViewById(R.id.fourthButtonHome);
        home=(ImageView)findViewById(R.id.home);
        chat=(ImageView)findViewById(R.id.chat);
        profile=(ImageView)findViewById(R.id.profile);



    }
}
