package com.example.id2013_03.startProject.Car_Page;

// importing all of the functions that are used within the class
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.id2013_03.mclaren.R;

// The public class for this page app..
// this holds all of the functionality
// For example a click on one of the buttons by the users
public class Car_F1_tech extends AppCompatActivity {
    // Setting global variables
    // These can be called anywhere within this page of the code
    // Storing all of them in once place making it easier to follow
    Button f1Tech;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This sets the view from the xml file
        setContentView(R.layout.car_f1_tech);

        // Collecting the information from the button that is placed within the page
        // It checks which view the app is currently on and places this into a variable called f1Tech
        // It also stores the ID that was set for this button within the xml
        //f1Tech = (Button) findViewById(R.id.f1TechBkBtn);
        // Taking the name of the button that was set and setting an on click listener
        // This is so that if the button does get pressed "something" will happen
        f1Tech.setOnClickListener(new View.OnClickListener() {
            @Override
            // Function for once the button gets clicked
            public void onClick(View v) {
                // Finish is a simple call that is already built in...
                // Finish just simply finishes what the login_car is looking at and takes them back to
                // where they were before. This has the same function as the actual back button
                finish();
                // This is an animation override...
                // This means that once the button has been pressed it will perform an animation to take
                // the users to the new page that they have selected...
                overridePendingTransition(R.animator.ui_animation_in, R.animator.ui_animation_out);



            }
        });
    }
}