package com.m.inter_activity_communication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button Button_LAUNCHER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_LAUNCHER = findViewById(R.id.Button_LAUNCHER);
    }


    public void launchSecondActivity(View view) {

    }
}
