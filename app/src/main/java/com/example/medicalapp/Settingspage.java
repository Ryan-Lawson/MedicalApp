package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Settingspage extends AppCompatActivity {
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);
        db = new databasehelper(this);
        Button save = (Button) findViewById(R.id.save);
        TextView editusername = (TextView) findViewById(R.id.editusername);
        EditText editpassword = (EditText) findViewById(R.id.editpassword);
        EditText editage = (EditText) findViewById(R.id.editage);
        EditText editphonenumber = (EditText) findViewById(R.id.editphonenumber);
        EditText editaddress = (EditText) findViewById(R.id.editaddress);

        String username = getIntent().getStringExtra("USER_NAME");
        String password = getIntent().getStringExtra("PASS_WORD");

        Button altreaccount = (Button) findViewById(R.id.altreaccount);
        altreaccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView editusername = (TextView) findViewById(R.id.editusername);
                editusername.setText(username);
                editusername.setVisibility(View.VISIBLE);

                EditText editpassword = (EditText) findViewById(R.id.editpassword);
                editpassword.setText(password);
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
                tablerowpadding.setPadding(0, 0, 0, 0);
            }
        });
        final List<String> states = Arrays.asList("white", "black");

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerbck);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, states);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newitem = spinner.getSelectedItem().toString();
                if (newitem == "white") {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else if (newitem == "black") {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

                Toast.makeText(Settingspage.this, "Theme changed to " + newitem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userN = editusername.getText().toString();
                String password = editpassword.getText().toString();
                String age = editage.getText().toString();
                String phoneN = editphonenumber.getText().toString();
                String address = editaddress.getText().toString();

                Boolean checkupdate = db.updateuserdata(userN, password, age, phoneN, address);

                if (checkupdate==true)
                    Toast.makeText(Settingspage.this, "Information updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Settingspage.this, "Information failed to update", Toast.LENGTH_SHORT).show();

            }


        });
    }
}

