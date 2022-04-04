package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String tag ="EVENT";
    databasehelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** retrives the id values for objects inside the activity */
        EditText CreateaccountUN = (EditText) findViewById(R.id.CreateaccountUN);
        EditText CApassword = (EditText) findViewById(R.id.CApassword);
        EditText ageCA = (EditText) findViewById(R.id.ageCA);
        EditText Phonenumber = (EditText) findViewById(R.id.Phonenumber);
        EditText Address = (EditText) findViewById(R.id.Address);
        Switch smsemail = (Switch) findViewById(R.id.smsemail);

        /**  on click listener for creating an account if the user clicks the done button
         * then they and fields are valid an account is made and saved to the data base
         * otherwise print a toast message saying innvalid inputs
         * */
        Button Done = (Button) findViewById(R.id.Done);
        Done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Usermodel usermodel;
            try {
                usermodel = new Usermodel(CreateaccountUN.getText().toString(), CApassword.getText().toString(), Integer.parseInt(ageCA.getText().toString()), Integer.parseInt(Phonenumber.getText().toString()), Address.getText().toString(), smsemail.isChecked());

            }
            catch (Exception e){
                Toast.makeText(MainActivity.this, "invalid input", Toast.LENGTH_SHORT).show();
                usermodel = new Usermodel("NA","NA",0, 0, "NA", false );
            }

            databasehelper dbhelper = new databasehelper(MainActivity.this);

                boolean success = dbhelper.addOne(usermodel);

                Toast.makeText(MainActivity.this, "Account created", Toast.LENGTH_SHORT).show();
            }
        });


    }




    public void onStart() {
        /**  calls the context for the database*/
        DB = new databasehelper(this);
        /**  on the user clicking the login button the username and password fields are checked
         * if valid then the user is sent to the home page else the user is told invalid credentials if wrong
         * and please enter fields if they are left blank*/
        Button Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                EditText UsernameLogin = (EditText) findViewById(R.id.UsernameLogin);
                EditText CreateaccountPassword = (EditText) findViewById(R.id.CreateaccountPassword);
                String usernlogin = UsernameLogin.getText().toString();
                String passwordlogin = CreateaccountPassword.getText().toString();
                Intent intent = new Intent(MainActivity.this,Homepage.class);

                if (usernlogin.equals("")|| passwordlogin.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter fields", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkUP = DB.checkusernamepassword(usernlogin, passwordlogin);
                    if (checkUP == true) {
                        Toast.makeText(MainActivity.this, "welcome " + usernlogin, Toast.LENGTH_SHORT).show();

                        //Create the bundle
//Add your data from getFactualResults method to bundle
                        intent.putExtra("USERNAME", UsernameLogin.getText().toString());
                        intent.putExtra("PASSWORD", CreateaccountPassword.getText().toString());
//Add the bundle to the intent
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        /**  on create account button click set text fields as visible*/
            Button Createaccount = (Button) findViewById(R.id.Createaccount);
            Createaccount.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    EditText CreateaccountUN = (EditText) findViewById(R.id.CreateaccountUN);
                    CreateaccountUN.setVisibility(View.VISIBLE);

                    EditText CApassword = (EditText) findViewById(R.id.CApassword);
                    CApassword.setVisibility(View.VISIBLE);

                    EditText ageCA = (EditText) findViewById(R.id.ageCA);
                    ageCA.setVisibility(View.VISIBLE);

                    EditText Phonenumber = (EditText) findViewById(R.id.Phonenumber);
                    Phonenumber.setVisibility(View.VISIBLE);

                    EditText Address = (EditText) findViewById(R.id.Address);
                    Address.setVisibility(View.VISIBLE);

                    Switch smsemail = (Switch) findViewById(R.id.smsemail);
                    smsemail.setVisibility(View.VISIBLE);

                    Button Done = (Button) findViewById(R.id.Done);
                    Done.setVisibility(View.VISIBLE);
                }
            });

/** log data for testing */
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