package com.example.id2013_03.startProject.Main;

// Importing the required functions for the class/s
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.id2013_03.startProject.Tabbed_Pages.Tab_Main;
import com.example.id2013_03.mclaren.R;

public class Vehicle_Specification extends Activity {

    ImageView moreInfo;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.vehicle_specification);

        moreInfo = (ImageView) findViewById(R.id.findOutMore);
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