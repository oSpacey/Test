package com.example.id2013_03.startProject.Login_Page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.id2013_03.mclaren.R;

// The public class for the salesmen to login to
// This class is only accessed once the logo has been held for a few seconds

public class User_Login extends AppCompatActivity {
    // Variables that are used within this class
    private static EditText username;
    private static EditText password;
    private static TextView attemps;
    private static Button login_button;
    // Counter
    // This is for the amount of times the salesmen has to login before the button blocks
    // This number can be changed to higher or lower
    int attempt_counter = 5;


    @Override
    // Declaring the layout for the Login page
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        // Calling a class called LoginButton
        LoginButton();
    }
    // Custom class for the login
    public void LoginButton()
    {
        // These are local variables
        // These can only be used within this class and not outside of it
        username = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.userPassword);
        attemps = (TextView)findViewById(R.id.loginAttempts);
        login_button = (Button)findViewById(R.id.LoginBtn);
        // Variable to keep track of the amount of times the users tries to log in
        attemps.setText(Integer.toString(attempt_counter));

        // Creating the on click listener for the menus
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This is for when the button has been pressed...
                // This section checks that what has been entered is equal to what has been placed here
                // For now the Username is set to "Test" and the password "password"
                // Both of these can be changed to something more suitable later on
                if (username.getText().toString().equals("Test") &&
                        password.getText().toString().equals("password")) {
                    // Gives a visual display for the users to let them know that they have logged in successfully
                    Toast.makeText(User_Login.this, "User and Password is correct", Toast.LENGTH_LONG).show();
                    // if the login and password are correct this then loads up the page for the salesmen to pick the correct car
                    Intent i = new Intent(User_Login.this, User_PickCar.class);
                    startActivity(i);

                } else {
                    // This is to stop the app from crashing
                    // This is for if the password is incorrect
                    // It also takes away from the counter
                    // Once the counter equals 0, it will then block the button to go onto the next page
                    // To overcome this the users can go back to the main page and try logging in again
                    // The page resets every time it is opened / closed
                    Toast.makeText(User_Login.this, "User and Password is incorrect", Toast.LENGTH_LONG).show();
                    attempt_counter--;
                    attemps.setText(Integer.toString(attempt_counter));
                    if (attempt_counter == 0) {
                        login_button.setEnabled(false);
                    }
                }
            }
        });

    }



}
