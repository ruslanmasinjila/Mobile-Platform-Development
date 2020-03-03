package com.menus.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // DECLARATION OF VARIABLES
    private TextView TextView_HELLO_WORLD;
    private Toolbar Toolbar_TOOLBAR;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar_TOOLBAR= findViewById(R.id.Toolbar_TOOLBAR);

        TextView_HELLO_WORLD = findViewById(R.id.TextView_HELLO_WORLD);

        // FOR CONTEXT MENU
        registerForContextMenu(TextView_HELLO_WORLD);

        // FOR TOOLBAR
        setSupportActionBar(Toolbar_TOOLBAR);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // FOR CONTEXT MENU
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
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

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // FOR OPTIONS MENU
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

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

    ///////////////////////////////////////////////////////////////////////////////////////////////
}
