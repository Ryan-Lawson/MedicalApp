package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String tag ="EVENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart() {
        Button Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Homepage.class));
            }
        });

            Button Createaccount = (Button) findViewById(R.id.Createaccount);
            Createaccount.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    EditText CreateaccountUN = (EditText) findViewById(R.id.CreateaccountUN);
                    CreateaccountUN.setVisibility(View.VISIBLE);

                    EditText editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
                    editTextTextPassword.setVisibility(View.VISIBLE);

                    Button Done = (Button) findViewById(R.id.Done);
                    Done.setVisibility(View.VISIBLE);
                }
            });
        super.onStart();
        Log.d(tag, "In the onSart() event");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }
    public void onResume(){
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }
    public void onPause(){
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }
    public void onStop(){
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }


}