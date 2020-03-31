package com.m.inter_activity_communication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    Button Button_LAUNCHER;
    SharedSpace sharedSpace = new SharedSpace();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_LAUNCHER = findViewById(R.id.Button_LAUNCHER);
    }


    public void launchSecondActivity(View view) {

        ///////////////////////////////////////////////////////////////
        // Create Linked List
        LinkedList<Integer> toSend = new LinkedList<Integer>();
        toSend.add(1);
        toSend.add(2);
        toSend.add(3);
        toSend.add(4);
        toSend.add(5);

        //////////////////////////////////////////////////////////////
        // Set the Linked List in Shared Space
        sharedSpace.setData(toSend);



        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }
}
