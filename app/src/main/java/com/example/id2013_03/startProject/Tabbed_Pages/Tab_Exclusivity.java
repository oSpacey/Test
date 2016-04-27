package com.example.id2013_03.startProject.Tabbed_Pages;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.id2013_03.startProject.Exclusivity_Pages.Bespoke_Aesthetics;
import com.example.id2013_03.startProject.Exclusivity_Pages.Factory_Handover;
import com.example.id2013_03.startProject.Main.Vehicle_Specification;
import com.example.id2013_03.mclaren.R;


// Class for the main activity that happens on this page...
// This extends fragment which means it works differently to a page that extends AppCompatActivity
public class Tab_Exclusivity extends Fragment {
    // Declaring variables which get used within this class
    TextView myCounter;
    Button btnStart;
    Button BespokeBtn;
    Button FactoryBtn;
    CountDownTimer countDownTimer;
    @Override
    // The view that is created once that the page has been opened
    // This uses a layout inflater which gets placed into a viewgroup container..
    // The viewgroup container is a section underneath the tab bar... You can see this in the main_activity.xml
    // This allows that section to be filled with different content. For this example tabbed_heritagege.xml file
    // is placed into the viewgroup which means that this is displayed and nothing else
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Creating the view layout for this class... It calls the xml file tabbed_heritage
        // This is then stored into the variable view to make it easier to call upon again later
        View view = inflater.inflate(R.layout.tabbed_exclusivity, container, false);

        // Taking the variables declared and pointing them to the correct ID's
        myCounter = (TextView) view.findViewById(R.id.mycounter);
        btnStart = (Button)view.findViewById(R.id.start);
        BespokeBtn = (Button)view.findViewById(R.id.BespokeBtn);
        FactoryBtn = (Button)view.findViewById(R.id.FactoryBtn);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cancel the old countDownTimer
                if(countDownTimer!=null){
                    countDownTimer.cancel();
                }

                countDownTimer = new CountDownTimer(10000, 1000) {

                    @Override
                    public void onFinish() {
                        myCounter.setText("Finished!");
                        Intent i = new Intent(getActivity(), Vehicle_Specification.class);
                        startActivity(i);




                    }

                    @Override
                    public void onTick(long millisUntilFinished) {
                        myCounter.setText("Millisecond Until Finished: "
                                + String.valueOf(millisUntilFinished));
                    }

                };

                countDownTimer.start();
            }
        });

        BespokeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Bespoke_Aesthetics.class);
                startActivity(i);
            }
        });

        FactoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Factory_Handover.class);
                startActivity(i);

            }
        });
        return view;
    }
}
