package com.example.id2013_03.startProject.Main;

// Importing the required functions for the class/s
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.id2013_03.startProject.Tabbed_Pages.Tab_Main;
import com.example.id2013_03.mclaren.R;

public class Vehicle_Specification extends AppCompatActivity {

    Button moreInfo;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_specification);

        moreInfo = (Button) findViewById(R.id.moreInfo);
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Vehicle_Specification.this, Tab_Main.class);
                startActivity(i);
                overridePendingTransition(R.animator.main_up, R.animator.main_down);
            }
        });
    }
}