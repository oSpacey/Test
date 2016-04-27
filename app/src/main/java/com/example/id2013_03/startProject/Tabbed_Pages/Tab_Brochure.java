package com.example.id2013_03.startProject.Tabbed_Pages;

// Importing the functions that are used for this class
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.id2013_03.startProject.Brochure.Brochure_ThankYouPage;
import com.example.id2013_03.mclaren.R;

// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
public class Tab_Brochure extends Fragment {
    // Button Variable
    // This is placed here makes it easier to use this button again later on
    // Also helps to keep track of all variables that are created if they are all placed here at the top.
    Button submitBtn;

    // Nullable is added
    @Nullable
    @Override
    // The view is created once the page has been opened
    // This uses a layout inflater which gets placed into a viewgroup container
    // The viewgroup container is a sections underneath the tab bar... You can see this is the main_activity.xml
    // This allows that section to be filled with different content. For this example main_brochure.xml file
    // is placed into the viewgroup which means that is is displayed and nothing else is
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Placing the layout into the rootView variable
        // This is also what places and fills the container on the page
        View rootView = inflater.inflate(R.layout.main_brochure, container, false);

        // Collecting information for the button that is within this page
        // IT gets the view which was placed into the variable above...
        // Find the button that is placed within the page and gets teh id of that button...
        // Giving the button name to make it easier to call... I have called this button submitBtn
        submitBtn = (Button) rootView.findViewById(R.id.submitBtn);
        // Taking the name of the button set and setting up an on click listener
        // This is so that simply if the button gets clicked "something" can happen
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            // Function for once the button has been clicked
            public void onClick(View v) {
                // Calling a new intent which gets the activity of the ThankYouPage
                // This is also placed into a variable i
                Intent i = new Intent(getActivity(), Brochure_ThankYouPage.class);
                // The activity is started and the variable i is placed into this
                startActivity(i);
            }
        });

        // The rootView is returned
        // This makes sure that the page is returned and displayed properly on the tab
        // Also stops the program from crashing
        return rootView;
    }

}

