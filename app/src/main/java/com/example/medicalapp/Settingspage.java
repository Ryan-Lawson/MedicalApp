package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;

public class Settingspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);



        Button altreaccount = (Button) findViewById(R.id.altreaccount);
        altreaccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editusername = (EditText) findViewById(R.id.editusername);
                editusername.setVisibility(View.VISIBLE);

                EditText editpassword = (EditText) findViewById(R.id.editpassword);
                editpassword.setVisibility(View.VISIBLE);

                EditText editage = (EditText) findViewById(R.id.editage);
                editage.setVisibility(View.VISIBLE);

                EditText editphonenumber = (EditText) findViewById(R.id.editphonenumber);
                editphonenumber.setVisibility(View.VISIBLE);

                EditText editaddress = (EditText) findViewById(R.id.editaddress);
                editaddress.setVisibility(View.VISIBLE);

                Button save = (Button) findViewById(R.id.save);
                save.setVisibility(View.VISIBLE);

                TableRow tablerowpadding = (TableRow) findViewById(R.id.tablerowpadding);
                tablerowpadding.setPadding(0,0,0, 0);
            }
        });
            String[] arraySpinner = new String[] {
                "white", "black", "blue", "green", "red"
        };
        Spinner s1 = (Spinner) findViewById(R.id.spinnerbck);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> arg0,View arg1, int arg2, long arg3) {
                int index = s1.getSelectedItemPosition();
                //Toast.makeText(getBaseContext(), "You have seleted item :" + months[index] , Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?>arg0) {}
        });


        if ( s1.equals("white")) {
            this.setTheme(R.style.Theme_AppCompat_Light);
        }
        else if( s1.equals("black")) {
            this.setTheme(R.style.Theme_AppCompat_DayNight);
        }
        else if( s1.equals("blue")) {
            this.setTheme(R.style.Blue);
        }
        else if( s1.equals("green")) {
            this.setTheme(R.style.green);
        }
        else if( s1.equals("red")) {
            this.setTheme(R.style.red);
        }

        String[] arraySpinner2 = new String[] {
                "20", "18", "16", "14", "12"
        };
        Spinner ssize = (Spinner) findViewById(R.id.spinnersize);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ssize.setAdapter(adapter2);

        String[] arraySpinner3 = new String[] {
                "black", "white", "blue", "green", "red"
        };
        Spinner scolour = (Spinner) findViewById(R.id.spinnercolour);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scolour.setAdapter(adapter2);
    }
}


