package com.example.id2013_03.startProject.Tabbed_Pages;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


import com.example.id2013_03.mclaren.R;
public class Spec_Adapter extends BaseAdapter {
    private Context specContext;

    // This is the public class that is for the images
    // This is where all of the images can be changed or added and will then be displayed within
    // the gallery. Nothing needs to be changed for the layout on this as it adapts to the amount
    // of images that get added to this function
    public Integer[] specThumbIds = {
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
            R.drawable.android, R.drawable.android,
    };

    // Constructor for the image adapter
    public Spec_Adapter(Context c)
    {
        // Taking the variable set from before and making it equal a new variable
        specContext = c;
    }

    @Override
    // A class for getting the number of items for the image gallery
    public int getCount()
    {
        // Checks the amount of items that are in the class mThumbsIds
        // Returns the length so the gallery knows how many spaces to fill
        // and what they need to be filled with
        return specThumbIds.length;
    }

    @Override
    // Function for getting the position of the image
    // This is done to allow an on click ability
    public Object getItem(int position){
        return specThumbIds[position];
    }

    @Override
    // Returning the item id as null
    public long getItemId(int position)
    {
        return 0;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    // Function for setting the Image view within each section of the grid view
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // This creates the image view with the variable called mContext
        ImageView imageView = new ImageView(specContext);
        // Setting the image to be displayed, Taken from the function called mThumbsIds
        imageView.setImageResource(specThumbIds[position]);
        // Scaling the image to fit the view correctly
        // Center crop is used so that the image is evenly cropped
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        // Setting the parameters for the image view
        imageView.setLayoutParams(new GridView.LayoutParams(480,440));
        // Setting the padding for each image around the grid view
        imageView.setPadding(50,50,50,50);
        // Returning so that something is displayed
        return imageView;
    }
}


