package com.example.id2013_03.startProject.Car_Page;

// Importing the functions used for this class
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.id2013_03.mclaren.R;

// The public class for this page app..
// this holds all of the functionality
// For example a click on one of the buttons by the users
public class Car_Special_Operations extends AppCompatActivity {
    // Setting global variables..
    // These can be called anywhere within this page of code
    // Storing all of them in one place making it easier to follow
    Button specOpsBtn;
    @Override
    // Overrides everything and is only called once the app has been created
    // Or started up
    public void onCreate(Bundle savedInstanceState) {
        // This is setting the view
        // The view is simply this one we are in now...
        // It is set to here because of how everything is pulled into this file.
        // Making it easier to understand
        super.onCreate(savedInstanceState);

        // This is setting the view
        // The view is simply this one we are in now...
        // It is set to here because of how everything is pulled into this file.
        // Making it easier to understand
        setContentView(R.layout.car_special_operations);

        // Collecting the information from the button that is placed on this page
        // It checks which view that the app is currently on and places all of this into the variable specOpsBtn
        // It also stores all the ID information that was set in the xml file
        specOpsBtn = (Button) findViewById(R.id.specOpsBkBtn);
        // Taking the name of the button that has been set and setting an on click listener
        // This is so that once the button gets clicked "something" will happen
        specOpsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            // Function for once the button has been clicked
            public void onClick(View v) {
                // Finish is a simple call that is already built in...
                // Finish just simply finishes what the login_car is looking at and takes them back to
                // where they were before. This has the same function as the back button
                finish();
                // This is an animation overrider...
                // This means that once the button has been pressed it will perform an animation to take
                // the users back to the page that they were originally one...
                overridePendingTransition(R.animator.ui_animation_in, R.animator.ui_animation_out);

            }
        });

    }
}