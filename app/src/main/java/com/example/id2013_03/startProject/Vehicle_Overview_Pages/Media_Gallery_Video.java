package com.example.id2013_03.startProject.Vehicle_Overview_Pages;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.id2013_03.mclaren.R;


public class Media_Gallery_Video extends Fragment {
    MediaController mediaController;
    DisplayMetrics dm;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Creating the view layout for this class... It calls the cml file tabbed_heritage
        // This is then stored into the variable view to make it easier to call upon again later
        View view = inflater.inflate(R.layout.vehicle_overview_media_video, container, false);



        VideoView testVid = (VideoView)view.findViewById(R.id.video_player_view);
        String filePath = "android.resource://com.example.id2013_03.mclaren/"+R.raw.newMov;

        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(filePath, MediaStore.Images.Thumbnails.MICRO_KIND);



        mediaController = new MediaController(getActivity());
        dm = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


        testVid.setMinimumWidth(width);
        testVid.setMinimumHeight(height);
        testVid.setMediaController(mediaController);
        testVid.setVideoPath(filePath);
        testVid.start();



        return view;
    }

}
