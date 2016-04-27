package com.example.id2013_03.startProject.Tabbed_Pages;

// These are the functions that are imported to get the app working
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.id2013_03.startProject.Main.Vehicle_Specification;
import com.example.id2013_03.mclaren.R;
import com.example.id2013_03.startProject.Login_Page.User_Login;

// The public class for the app...
// this holds all of the functionality
// Calling all of the pages and processing what happens on each page
// For example a click on one of the buttons by the users
public class Tab_Main extends AppCompatActivity {
    // Global variables..
    // These can be used in any of the functions that have been created below
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView Logo;

    // ---------------------------------------------------------------------------------------------------------------------------
    // The first function that has been created
    // This function is protected
    // This means that what happens here, nothing can be changed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Overrides everything and is only called once the app has been created
        // Or started up
        super.onCreate(savedInstanceState);
        // This is setting the view
        // The view is simply this one we are in now...
        // It is set to here because of how everything is pulled into this file.
        // Making it easier to understand
        setContentView(R.layout.main_activity);


        // These are the viewPager variables
        // These are for all of the layouts that are for each page
        // It looks for which page it is one and then simply gets all of the information
        // that is stored within the ViewPager function on that page.
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));

        // The ID for the McLaren logo
        // This has been set so that it is an easy "home" button
        Logo = (ImageView)findViewById(R.id.Logo);
        // Setting the onClick listener
        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Once clicked,
                // Moves the tabbed position to its first state...
                // the "home screen"
                Intent i = new Intent(Tab_Main.this, Vehicle_Specification.class);
                startActivity(i);
            }
        });

        // Setting a long clck listener
        // This is a "secret" menu that only the car dealers will know about
        // This takes them into the login page where they are able to change the car
        Logo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            // Setting the onLong click listener
            public boolean onLongClick(View v) {
                // Placing the new activity into the variable i
                Intent i = new Intent(Tab_Main.this, User_Login.class);
                // Starting the new activity and implementing the variable i into this
                startActivity(i);
                // Returning true
                return true;
            }
        });


        // These are the tabLayout functions
        // These just like the ViewPager functions get the information that is stored under each tab...
        // In this case it is simply just the text for now
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        // Start for function to detect which tab is open
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            // Function to get the selected tabs position
            // These gets the place of the tabs to work out where the under bar needs to be placed
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            // This checks the Unselected tabs
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            // this is a function for if the users go back to the same tab
            // This is here to just stop the app from crashing if the users happen to go back
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            // *** NOTE : ALL OF THE THREE FUNCTIONS ABOVE, IN THIS CASE ARE TO JUST GET THE POSITIONS,
            //            OF THE TABS THE IS SELECTED OR UNSELECTED. MORE CAN BE ADDED TO THESE FUNCTIONS.
            //            FOR EXAMPLE IF FOR SOME REASON YOU WANT THE TEXT OF THE TAB YOU ARE ON TO CHANGE COLOUR,
            //            OR IF YOU WANT THE OTHER TABS THAT AREN'T SELECTED TO CHANGE COLOUR... ***
        });
    }



    // This is a private class that is used for the tabs...
    // This is a private class because it is nested within another class but
    // is not the main class function
    private class CustomAdapter extends FragmentPagerAdapter {
        // Creating a private string that is only for this class
        // This string stores the names of each of the tabs that I have named.
        // These tab names are then stored within the variable fragments
        private String fragments[] = {"Specification", "Overview", "Heritage", "Exclusivity", "Brochure"};

        // This is simply the public call that is under the CustomAdapter function
        // This is just like the other functions that have been created
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        // This is a public class that gets the fragments and there position
        // This takes the names that were placed into the fragment string and uses that within here to display to the users
        @Override
        public Fragment getItem(int position) {
            // This is for when the users interact with the app and the position switches
            switch (position) {
                // If the position is at the beginning i.e 0...
                // It will then return the whole layout and functionality of the Tab_Vehicle_Spec page
                case 0:
                    return new Tab_Vehicle_Spec();
                // If the position is at the second tab i.e 1...
                // It will then return the whole layout and functionality of the Tab_Vehicle page
                case 1:
                    return new Tab_Vehicle_Overview();
                // If the position is at the third tab i.e 2...
                // It will then return the whole layout and functionality of the Tab_Heritage page
                case 2:
                    return new Tab_Heritage();
                // If the position is at the final tab i.e 3...
                // It will then return the whole layout and functionality of the Tab_Brochure page
                case 3:
                    return new Tab_Exclusivity();
                // Finally a default value needs to be set... This is to stop the app from misbehaving
                // We return nothing as if the users aren't interacting with the app then we don't want
                // anything to be returned...
                case 4:
                    return new Tab_Brochure();
                default:
                    return null;
            }
        }
        // A Simple function that gets the length of the tabs
        // this is created and called upon within the script..
        // This gets all of the names that have been written and spaces them evenly
        @Override
        public int getCount() {
            // Returning the length of the fragments list so that it doesn't over extend and break
            return fragments.length;
        }

        // A simple function that gets the tabs position.
        // It takes the position of what the login_car is on and makes sure that it displays
        // the correct information for the page it is that they are looking at
        @Override
        public CharSequence getPageTitle(int position) {
            // Returning the position, allowing the slider to know which page to be under
            return fragments[position];
        }
    }

}
