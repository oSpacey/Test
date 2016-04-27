package com.example.id2013_03.startProject.Vehicle_Overview_Pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.id2013_03.mclaren.R;

// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.GridView;


// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
public class Media_Gallery_Images extends Fragment {
    @Override
    // The view that is created once that the page has been opened
    // This uses a layout inflater which gets placed into a viewgroup container..
    // The viewgroup container is a section underneath the tab bar... You can see this in the main_activity.xml
    // This allows that section to be filled with different content. For this example tabbed_heritage.xmlml file
    // is placed into the viewgroup which means that this is displayed and nothing else
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Creating the view layout for this class... It calls the cml file tabbed_heritage
        // This is then stored into the variable view to make it easier to call upon again later
        View view = inflater.inflate(R.layout.vehicle_overview_media_images, container, false);
        // The grid view is set... This calls the layout that is on the xml file
        // This also calls the adapter that is in the heritage Image adapter class
        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new Media_ImageAdapter(view.getContext()));
        // Setting the on click listener... This is if an image get clicks
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // This Is a function makes it so that once and image is clicked within the
            // gallery. It will then open up to a new activity and display the image in full
            // This function isn't like the normal onClick listeners where it takes the users to a new Activity
            // This function, gets the position of the image which is linked to the image on the gallery.
            // This makes it so that whatever image is click, it knows what image to display fully in the new Activity
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Sending image id to the FullScreenActivity
                Intent i = new Intent(getActivity(), FullImageActivity.class);
                // Passing the array index
                i.putExtra("id", position);
                // Displays the new Activity
                startActivity(i);

            }
        });
        // Returns the view, so something gets displayed
        return view;
    }
}