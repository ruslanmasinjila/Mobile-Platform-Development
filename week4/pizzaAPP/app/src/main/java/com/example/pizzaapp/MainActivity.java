package com.example.pizzaapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // DECLARATION OF VARIABLES
    RadioGroup RadioGroup_Crust_Type;
    RadioGroup RadioGroup_Extra_Cheese;
    CheckBox CheckBox_Mushrooms;
    CheckBox CheckBox_Sweetcorn;
    CheckBox CheckBox_Onions;
    CheckBox CheckBox_Peppers;
    Button Button_ORDER;

    // CREATE AN ARRAY LIST FOR HOLDING CHECKBOXES
    ArrayList<CheckBox> toppings = new ArrayList<CheckBox>();



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

        // REFERENCING GRAPHICAL COMPONENTS (VIEWS) FROM THE INTERFACE
        RadioGroup_Crust_Type = findViewById(R.id.RadioGroup_Crust_Type);
        RadioGroup_Extra_Cheese=findViewById(R.id.RadioGroup_Extra_Cheese);

        // MAKE SURE TO CAST THE CHECK BOXES WHEN ADDING TO ARRAY LIST
        toppings.add((CheckBox) findViewById(R.id.CheckBox_Mushrooms));
        toppings.add((CheckBox) findViewById(R.id.CheckBox_Sweetcorn));
        toppings.add((CheckBox) findViewById(R.id.CheckBox_Onions));
        toppings.add((CheckBox) findViewById(R.id.CheckBox_Peppers));


        Button_ORDER = findViewById(R.id.Button_ORDER);





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

    public void placeOrder(View view)
    {
        // GET THE NAME OF THE SELECTED CRUST TYPE
        int crustTypeId = RadioGroup_Crust_Type.getCheckedRadioButtonId();
        RadioButton selectedCrustTypeRadioButton = (RadioButton) findViewById(crustTypeId);
        String selectedCrustTypeText = selectedCrustTypeRadioButton.getText().toString();


        // FOR STORING THE NAMES OF SELECTED TOPPINGS
        String selectedToppings = "";

        // LOOP THROUGH THE ARRAY LIST AND CHECK THE STATUS OF THE CHECKBOXES
        for(int i = 0; i < toppings.size();i++)
        {
            if(toppings.get(i).isChecked())
            {
                selectedToppings+=toppings.get(i).getText().toString()+"\n";
            }
        }

        // GET YES/NO ANSWER
        int extraCheeseId = RadioGroup_Extra_Cheese.getCheckedRadioButtonId();
        RadioButton selectedExtraCheeseRadioButton = (RadioButton) findViewById(extraCheeseId);
        String selectedExtraCheeseText = selectedExtraCheeseRadioButton.getText().toString();

        System.out.println(selectedCrustTypeText);
        System.out.println(selectedToppings);
        System.out.println(selectedExtraCheeseText);


        // PREPARE CONTENT FOR THE TOAST MESSAGE
        String summary = "ORDER SUMMARY\n";
        summary+="********************* \n";
        summary+="CRUST TYPE \n";
        summary+=selectedCrustTypeText+"\n";
        summary+="********************* \n";
        summary+="TOPPINGS \n";
        if(selectedToppings.equals(""))
        {
            summary+="<None> \n";
        }
        else
            {
            summary += selectedToppings;
        }
        summary+="********************* \n";
        summary+="EXTRA CHEESE? "+ selectedExtraCheeseText;

        Toast toast = Toast.makeText(this, summary, Toast.LENGTH_LONG);
        toast.show();





    }


}
