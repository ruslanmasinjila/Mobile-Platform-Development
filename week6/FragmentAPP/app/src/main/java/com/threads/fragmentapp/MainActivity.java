package com.threads.fragmentapp;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button frButton1;
    private Button frButton2;
    private Fragment fr1;
    private Fragment fr2;
    private Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frButton1 = findViewById(R.id.frbutton1);
        frButton2 = findViewById(R.id.frbutton2);
        frButton1.setOnClickListener(this);
        frButton2.setOnClickListener(this);

        fr1 = new FragmentOne();
        fr2 = new FragmentTwo();

    }

    public void onClick(View aview)
    {
        if (aview == frButton1)
        {
            fr = fr1;
            Log.e("MyTag","Fragment 1 selected");
        }
        else
        if (aview == frButton2)
        {
            fr = fr2;
            Log.e("MyTag","Fragment 2 selected");
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,fr);
        transaction.commit();
    }
}
