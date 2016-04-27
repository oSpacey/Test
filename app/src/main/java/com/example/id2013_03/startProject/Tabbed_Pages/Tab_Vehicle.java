package com.example.id2013_03.startProject.Tabbed_Pages;

// Importing the functions that are used for this page
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.id2013_03.startProject.Car_Page.Car_Car_Features;
import com.example.id2013_03.startProject.Car_Page.Car_F1_tech;
import com.example.id2013_03.startProject.Car_Page.Car_Options;
import com.example.id2013_03.startProject.Car_Page.Car_Special_Operations;
import com.example.id2013_03.mclaren.R;

// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
public class Tab_Vehicle extends Fragment {
    // Button Variables
    // This is placed here makes it easier to use this button again later on
    // Also helps to keep track of all variables that are created if they are all placed here at the top.
    Button f1Btn;
    Button carFeatBtn;
    Button specOpBtn;
    Button opBtn;

    // Nullable is added
    @Nullable
    @Override
    // The view that is created once that the page has been opened.
    // This uses a layout inflater which gets placed into a viewgroup container.
    // The viewgroup container is a section underneath the tab bar... You can see this in the main_activity.xml
    // This allows that section to be filled with different content. For this example main_car.xml file
    // is placed into the viewgroup which means that this is displayed and nothing else
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Placing the layout into the rootView varaible
        // This is also what places and fills the container on the page
        View rootView = inflater.inflate(R.layout.main_car, container, false);

        // Declaring and setting names for all of the buttons that are on this page
        // The buttons ids are then searched for and found so that once the button is clicked
        // it knows which exact button has been clicked
        f1Btn = (Button) rootView.findViewById(R.id.f1TechBtn);
        carFeatBtn = (Button) rootView.findViewById(R.id.carFeatBtn);
        specOpBtn = (Button) rootView.findViewById(R.id.SpecOpBtn);
        opBtn = (Button) rootView.findViewById(R.id.OpBtn);


        // Setting the on click listener for the F1 Technology Page
        f1Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // Calling a new intent which gets the activity of F1 Technology
                // This is also placed into a variable i
                Intent i = new Intent(getActivity(), Car_F1_tech.class);
                // The activity is started and the variable i is placed into this
                startActivity(i);
            }
        });

        // Setting the on click listener for the Car Features button
        carFeatBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Calling a new intent which gets the activity of Car Features
                // This is also placed into a variable i
                Intent i = new Intent(getActivity(), Car_Car_Features.class);
                // The activity is started and the variable i is placed into this
                startActivity(i);
            }
        });

        // Setting the on click listener for the Special Operations
        specOpBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Calling a new intent which gets the activity of Special Operations
                // This is also placed into a variable i
                Intent i = new Intent(getActivity(), Car_Special_Operations.class);
                // The activity is started and the variable i is placed into this
                startActivity(i);

            }
        });

        // Setting the on click listener for the Options page
        opBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Calling a new intent which gets the activity of Options
                // This is also placed into a variable i
                Intent i = new Intent(getActivity(), Car_Options.class);
                // The activity is started and the variable i is placed into this
                startActivity(i);
            }
        });

        // The rootView is returned...
        // This makes sure that the page is returned and displayed properly on the tab
        return rootView;
    }
}
