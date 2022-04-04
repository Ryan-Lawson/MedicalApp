package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        /**  gets the bundled data from the Main activity*/
        String username = getIntent().getStringExtra("USERNAME");
        String password = getIntent().getStringExtra("PASSWORD");

        /** on healthreader button clicked user is sent to the health reader page */
        Button HealthReader = (Button) findViewById(R.id.HealthReader);
        HealthReader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Homepage.this, Healthreader.class));


            }
        });
        /**  on settings button button clicked user is sent to the settings page and
         * the bundled data from the main activity is sent to the settings page aswell*/
        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Homepage.this,Settingspage.class);


//Add your data from getFactualResults method to bundle
                intent.putExtra("USER_NAME", username);
                intent.putExtra("PASS_WORD", password);
//Add the bundle to the intent
                startActivity(intent);
            }

        });
    }
}
