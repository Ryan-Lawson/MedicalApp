package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

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
                EditText editTextTextPersonName4 = (EditText) findViewById(R.id.editTextTextPersonName4);
                editTextTextPersonName4.setVisibility(View.VISIBLE);

                EditText editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
                editTextTextPassword.setVisibility(View.VISIBLE);

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
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(getColor(255-255-255));
        }
        else if( s1.equals("black")) {
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(getColor(0-0-0));
        }
        else if( s1.equals("blue")) {
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(getColor(0-0-255));
        }
        else if( s1.equals("green")) {
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(getColor(0-204-0));
        }
        else if( s1.equals("red")) {
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(getColor(255-0-0));
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


