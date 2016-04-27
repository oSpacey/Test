package com.example.id2013_03.startProject.Brochure;

// Importing the functions used for the class
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.example.id2013_03.mclaren.R;

// Public class for the activity...
public class Brochure_ThankYouPage extends AppCompatActivity{
    @Override
    // Protected class for once the page is created
    protected void onCreate(Bundle savedInstanceState)
    {
        // Saves the pages instance
        super.onCreate(savedInstanceState);
        // Setting the layout of the page
        // i.e what will be displayed on the page
        setContentView(R.layout.brochure_thankyou);

        // Getting the display of the screen
        DisplayMetrics dm = new DisplayMetrics();
        // Getting the screen display and the windows functions
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        // Variables for the width and the height
        // This takes in the screen size that we got just above
        // and sets it into a variable "dm"
        // This variable is then used to get the pixels for the width and the height of the screen
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // Finally this sets the window width and height...
        // At the moment this is set to a small box that pops up
        getWindow().setLayout((int)(width * .3), (int)(height * .3));


    }
}
