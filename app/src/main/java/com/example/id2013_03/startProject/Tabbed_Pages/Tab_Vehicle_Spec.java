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
    // Private variables that can only be called within this class
    // Placed here to make it easier to keep track of
    private Handler mHandler;
    private Runnable mUpdateResults;
    private Timer timerAnimate;
    private TimerTask timerTask;

    // Variables that are used through this class
    ImageSwitcher imageSwitcher;
    ImageView imageView;
    Animation slide_in_left, slide_out_right;
    GridView gridView;

    // Integer string variable
    // Stores all of the images that are needed within a variable
    int imageResources[] = {
            R.drawable.android,
            R.drawable.android,
            R.drawable.android,
    };

    // Integer variable for the index of each image / object
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

        // Finding the image switcher that is placed within the current xml file
        imageSwitcher = (ImageSwitcher) rootView.findViewById(R.id.imageSwitcher);
        // Storing the animation for the imageSwitcher into variables
        // Set to a simple slide in and out
        slide_in_left = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        // Setting the animation for the imageSwitcher using the variables created before
        imageSwitcher.setInAnimation(slide_in_left);
        imageSwitcher.setOutAnimation(slide_out_right);
        // Placing the images within the imageSwitcher
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                // Setting up a new image view for every image that gets added / created
                // This allows for more images to be added without adding any extra code or issues
                imageView = new ImageView(getActivity());
                // Setting the scale type for the image
                // Fitting the image into the imageSwitcher view that has been created
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // Setting the parameters for the ImageSwitcher, This is just so that it can't be overridden.
                // Keeps all of the images the same and correct size for the layout of the page
                LayoutParams params = new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                // Setting the parameters to the image view...
                imageView.setLayoutParams(params);

                // Returning the image view, so that everything can be created / displayed
                // If this is deleted and error will occur
                return imageView;
            }
        });

        // Setting up a handler and storing it within a variable
        mHandler = new Handler();
        // Setting up a runnable activity, this keeps an "eye" on what is going on within the page
        // ** USED TO AUTOMATICALLY CHANGE THE IMAGES ** \\
        mUpdateResults = new Runnable() {
            public void run() {
                // Calling a separate void
                // Making calculations easier
                AnimateSlideShow();
            }
        };

        // Setting a integer variable called delay and setting this to 0
        int delay = 0;
        // Setting a integer variable called period and setting this to 5000
        int period = 5000;
        // Taking the variable timerAnimate and declaring a new timer to be initiated
        timerAnimate = new Timer();
        // Taking the timerTask variable and declaring a new TimerTask to be initiated
        timerTask = new TimerTask() {
            public void run() {
                // Taking the "post" handler results and updating them each time this class is run / called
                mHandler.post(mUpdateResults);
            }
        };
        // Taking the timerAnimate variable and setting the fixed rate to the speed that the imageSwitcher
        // will switch through the images that have been declared
        timerAnimate.scheduleAtFixedRate(timerTask, delay, period);
        // Returning the view so everything can be created and no errors are shown
        return rootView;
    }
    // Separate void for the imageSwitcher to change automatically
    // Created to make the calculations easier + easier to follow
    public void AnimateSlideShow()
    {
        // Setting the current image resource and collecting the current position of this with currIndex
        imageSwitcher.setImageResource(imageResources[currIndex]);

        // Checking what the current position is set to
        // If the image is not equal to the image resource length -1
        // Then the position or * "currIndex" * is set to 0
        // and the imageSwitcher looks for the first image that is stored
        if (currIndex == imageResources.length - 1) {
            currIndex = 0;
            imageSwitcher.setImageResource(imageResources[currIndex]);
        } else {
            // If the current index is not equal to 0
            // The image resource adds by 1... this keeps going up until it hits that last image
            // Once the last image has been reached, it then goes back to the beginning of this if statement
            // and starts to loop the images through once again
            imageSwitcher.setImageResource(imageResources[++currIndex]);
        }
    }

}