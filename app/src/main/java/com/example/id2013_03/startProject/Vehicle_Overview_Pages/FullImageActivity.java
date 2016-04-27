package com.example.id2013_03.startProject.Vehicle_Overview_Pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.id2013_03.mclaren.R;

// Public class for the full image
// This class only gets called once an image has been clicked within the gallery layout
public class FullImageActivity extends  Activity {
    // Variables that get used throughout this class
    // Placed at the top to make it easier to find and follow
    Button fullGalleryBk;
    @Override
    // Displaying the right xml layout for the class
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_overview_media_image_full);

        // Finding the correct buttons ID
        fullGalleryBk = (Button) findViewById(R.id.fullGalleryBk);
        // Creating the onClick listener for the button
        fullGalleryBk.setOnClickListener(new View.OnClickListener() {
            @Override
            // Creating the onClick functionality
            public void onClick(View v) {
                // Finish is essentially the back button...
                // This takes the users back to the exact page that they were on
                finish();
                // Changing the animation for the button click...
                // Making it flow smoother, rather then just swapping out to the new activity
                overridePendingTransition(R.animator.ui_animation_in, R.animator.ui_animation_out);
            }
        });

        // Getting the intent data
        Intent i = getIntent();

        // Selected images' ID
        int position = i.getExtras().getInt("id");
        // Getting the class which populates the gallery layout from the class Media_ImageAdapter
        Media_ImageAdapter mediaImageAdapter = new Media_ImageAdapter(this);

        // Declaring the image view that is placed onto the page
        ImageView imageView = (ImageView)findViewById(R.id.full_image_view);
        // Setting the image view with the images declared within mThumbsIds function
        imageView.setImageResource(mediaImageAdapter.mThumbIds[position]);
        getWindow().setFormat(PixelFormat.UNKNOWN);

    }
}