package com.example.id2013_03.startProject.Car_MoreInfo;

// Importing functions that are used for this class
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.id2013_03.startProject.Tabbed_Pages.Tab_Main;
import com.example.id2013_03.mclaren.R;

// Class for the main activity that happens on this page...
public class FindOutMore extends AppCompatActivity {
    // Button Variable
    // This is placed here makes it easier to use this button again later on
    // Also helps to keep track of all variables that are created if they are all placed here at the top.
    Button specBack;

    @Override
    // The view that is created once the page has been opened
    // This uses a layout inflater which gets placed into a viewgroup container.
    // The viewgroup container is a section underneath the tab bar... You can see this in the main_activity.xml
    // This allows that section to be filled with different content. For this example main_findoutmore.xml file
    // is placed into the viewgroup which means that this is displayed and nothing else
    public void onCreate(Bundle savedInstanceState)
    {
        // Overrides everything and is only called once the app has been created
        // Or started up
        super.onCreate(savedInstanceState);
        // This is setting the view
        // The view is simply this one we are in now...
        // It is set to here because of how everything is pulled into this file.
        // Making it easier to understand
        setContentView(R.layout.main_findoutmore);

        // Collecting the information from the button that is placed onto the page
        // It checks which view it is looking into and places this into the variable specBack
        // Placing this into a variable makes it easier to call that button again rather then retyping the whole thing over and over.
        // IT also stores the id for that button
        specBack = (Button)findViewById(R.id.specBackBtn);
        // Taking the name of the button and setting an on click listener
        // This is so that if the button does get pressed "something" will happen
        specBack.setOnClickListener(new View.OnClickListener() {
            @Override
            // Function for once the button gets clicked
            public void onClick(View v) {
                // Calling a new intent...
                // This intent swaps the pages...
                // For this example i takes the FindOutMore.this which means it is pointing at this current page
                // to Tab_Main.class... This means that when we are on the find out more page if the button is clicked
                // it will take the users to the Tab_Main page
                // This is all also stored into the variable i
                Intent i = new Intent(FindOutMore.this, Tab_Main.class);
                // The activity is started and the variable i is placed into this
                startActivity(i);
                // This is an animation overrider...
                // This means that once the button has been pressed it will perform an animation to take
                // the users back to the new page that they have selected...
                overridePendingTransition(R.animator.ui_animation_in, R.animator.ui_animation_out);
            }
        });
    }
}
