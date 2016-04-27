package com.example.id2013_03.startProject.Tabbed_Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.id2013_03.mclaren.R;
import com.example.id2013_03.startProject.Vehicle_Overview_Pages.Design;
import com.example.id2013_03.startProject.Vehicle_Overview_Pages.Media_Main;

/**
 * Created by ID2013-03 on 18/04/2016.
 */
public class Tab_Vehicle_Overview extends Fragment {
    Button mediaBtn;
    Button designBtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Placing the layout into the rootView varaible
        // This is also what places and fills the container on the page
        View rootView = inflater.inflate(R.layout.tabbed_vehicle_overview, container, false);

        designBtn = (Button) rootView.findViewById(R.id.designBtn);
        mediaBtn = (Button) rootView.findViewById(R.id.mediaBtn);

        designBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Design.class);
                startActivity(i);

            }
        });

        mediaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Media_Main.class);
                startActivity(i);

            }
        });

        return rootView;

    }
}
