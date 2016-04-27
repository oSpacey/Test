package com.example.id2013_03.startProject.Tabbed_Pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.id2013_03.mclaren.R;

public class Spec_Full_Image extends Activity{
    Button specFullBk;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Setting the view
        setContentView(R.layout.tab_spec_image_full);

        // Finding the buttons ID to implement the onClick functionality
        specFullBk = (Button)findViewById(R.id.spec_fullBk_Btn);
        // Setting the onClick functionality
        specFullBk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finishing the event and going back to the previous activity
                finish();
                // Overriding the animation transition to a new transition
                overridePendingTransition(R.animator.ui_animation_in, R.animator.ui_animation_out);
            }
        });

        // Setting the intent to get the intent from within the activity
        Intent i = getIntent();
        // Setting the position variable and setting the id for each image / object
        int position = i.getExtras().getInt("id");
        // Setting the Adapter class for the full image
        Spec_Adapter specFullImage = new Spec_Adapter(this);
        // Creating and getting the image view's ID
        ImageView imageView = (ImageView)findViewById(R.id.spec_Image_Full);
        // Setting the image resource files and populating the image view with the selected items ID
        imageView.setImageResource(specFullImage.specThumbIds[position]);
        // Getting the window and setting the format for the images in the full view
        getWindow().setFormat(PixelFormat.UNKNOWN);


    }

}