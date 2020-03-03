package com.menus.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView TextView_HELLO_WORLD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_HELLO_WORLD = findViewById(R.id.TextView_HELLO_WORLD);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_item1:
                TextView_HELLO_WORLD.setTypeface(null, Typeface.BOLD);
                return true;

            case R.id.item_item2:
                TextView_HELLO_WORLD.setTypeface(null, Typeface.ITALIC);
                return true;

            case R.id.item_item3:
                TextView_HELLO_WORLD.setTypeface(null, Typeface.BOLD_ITALIC);
                return true;

                default: return super.onOptionsItemSelected(item);


        }

    }
}
