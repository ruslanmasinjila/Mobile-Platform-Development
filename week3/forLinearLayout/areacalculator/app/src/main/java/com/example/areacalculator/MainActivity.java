package com.example.areacalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////// START /////////////////////////////////////////
    // Create the graphical components here. Import the necessary libraries when required
    // First two components already created for you
    TextView TextView_WIDTH_LABEL;
    EditText EditText_WIDTH_VALUE;

    TextView TextView_HEIGHT_LABEL;
    EditText EditText_HEIGHT_VALUE;

    TextView TextView_AREA_LABEL;
    TextView TextView_AREA_VALUE;

    Button Button_CALCULATE_AREA;

    ///////////////////////////////////////// END /////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ///////////////////////////////////////// START /////////////////////////////////////////
        // Reference the components here. First two referencing already done for you
        TextView_WIDTH_LABEL = findViewById(R.id.TextView_WIDTH_LABEL);
        EditText_WIDTH_VALUE = findViewById(R.id.EditText_WIDTH_VALUE);

        TextView_HEIGHT_LABEL = findViewById(R.id.TextView_HEIGHT_LABEL);
        EditText_HEIGHT_VALUE = findViewById(R.id.EditText_HEIGHT_VALUE);

        TextView_AREA_LABEL = findViewById(R.id.TextView_AREA_LABEL);
        TextView_AREA_VALUE = findViewById(R.id.TextView_AREA_VALUE);

        Button_CALCULATE_AREA = findViewById(R.id.Button_CALCULATE_AREA);



        // Implement <onClick> method so that the result from the method <onCalculate>
        // is displayed in "TextView_AREA_VALUE"

        Button_CALCULATE_AREA.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        // Initialize variables to hold the input from the user
                        double width = 0.0;
                        double height = 0.0;

                        // Get the values from the EditText components
                        // Make sure you convert the Editable object to double
                        width = Double.parseDouble(EditText_WIDTH_VALUE.getText().toString());
                        height = Double.parseDouble(EditText_HEIGHT_VALUE.getText().toString());


                        // Calculate the area using calculateArea method
                        double area = calculateArea(width,height);
                        TextView_AREA_VALUE.setText(String.valueOf(area));

                        EditText_WIDTH_VALUE.onEditorAction(EditorInfo.IME_ACTION_DONE);
                        EditText_HEIGHT_VALUE.onEditorAction(EditorInfo.IME_ACTION_DONE);


                    }

                }


        );
        ///////////////////////////////////////// END /////////////////////////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ///////////////////////////////////////// START /////////////////////////////////////////
    // This method just returns the product of width and height
    public double calculateArea(double width, double height)
    {
        return width*height;
    }

    ///////////////////////////////////////// END /////////////////////////////////////////



}