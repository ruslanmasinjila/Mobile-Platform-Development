package com.m.inter_activity_communication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class SecondActivity extends AppCompatActivity {

    SharedSpace sharedSpace = new SharedSpace();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LinkedList<Integer> toReceive = sharedSpace.getData();

        System.out.println("****************************");
        for(int i = 0; i < toReceive.size();i++)
        {

            System.out.println(toReceive.get(i));
        }

    }

    public void closeSecondActivity(View view) {
        finish();
    }
}
