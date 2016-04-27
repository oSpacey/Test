package com.example.id2013_03.startProject.Tabbed_Pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.id2013_03.mclaren.R;

// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
public class Tab_Heritage extends Fragment {
    @Override
    // The view that is created once that the page has been opened
    // This uses a layout inflater which gets placed into a viewgroup container..
    // The viewgroup container is a section underneath the tab bar... You can see this in the main_activity.xml
    // This allows that section to be filled with different content. For this example tabbed_heritage.xmlml file
    // is placed into the viewgroup which means that this is displayed and nothing else
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Creating the view layout for this class... It calls the cml file tabbed_heritage
        // This is then stored into the variable view to make it easier to call upon again later
        View view = inflater.inflate(R.layout.tabbed_heritage, container, false);
        // The grid view is set... This calls the layout that is on the xml file
        // This also calls the adapter that is in the heritage Image adapter class
        return view;

    }
}
