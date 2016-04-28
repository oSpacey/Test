package com.example.id2013_03.startProject.Tabbed_Pages;

// Importing the required functions for the class/s
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.view.ViewGroup.LayoutParams;

import com.example.id2013_03.mclaren.R;


import java.util.Timer;
import java.util.TimerTask;

// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
public class Tab_Vehicle_Spec extends Fragment {

    GridView gridView;
    int currIndex;
    @Override
    // The view that is created once that the page has been opened.
    // This uses a layout inflater which gets placed into a viewgroup container.
    // The viewgroup container is a section underneath the tab bar... You can see this in the main_activity.xml
    // This allows that section to be filled with different content. For this example tabbed_vehicle_specs.xmltions.xml file
    // is placed into the viewgroup which means that this is displayed and nothing else
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Placing the layout into the rootView variable
        // This is also what places and fills the container on the page
        View rootView = inflater.inflate(R.layout.tabbed_vehicle_specs, container, false);
        ImageView image = (ImageView)rootView.findViewById(R.id.imageView);
        image.setImageResource(R.drawable.bg_small);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Getting / Creating the grid view from the layout and finding the ID of this grid view
        gridView = (GridView) rootView.findViewById(R.id.spec_gridView);
        // Setting the adapter that displays all of the different images that are stored under ** Tabbed_Pages > Spec_Adapter **
        // The images that are declared within the * specThumbsIds * variable and placed into the grid view here
        gridView.setAdapter(new Spec_Adapter(rootView.getContext()));
        // Setting up an onClick listener for the images within the gallery
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // This Is a function makes it so that once and image is clicked within the
            // gallery. It will then open up to a new activity and display the image in full
            // This function isn't like the normal onClick listeners where it takes the users to a new Activity
            // This function, gets the position of the image which is linked to the image on the gallery.
            // This makes it so that whatever image is click, it knows what image to display fully in the new Activity
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Sending image id to the FullScreenActivity
                Intent i = new Intent(getActivity(), Spec_Full_Image.class);
                // Passing the array index
                i.putExtra("id", position);
                // Displays the new Activity
                startActivity(i);
            }
        });
        return rootView;
    }

}