package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Healthreader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthreader);

        Button imageButton = (Button) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText TempText = (EditText) findViewById(R.id.TempText);

                String strTemp = TempText.getText().toString();
                double Temp =Double.parseDouble(strTemp);

                EditText bpText = (EditText) findViewById(R.id.bpText);

                String strbp = TempText.getText().toString();
                double bloodp =Double.parseDouble(strbp);

                EditText Heartbeat = (EditText) findViewById(R.id.Heartbeat);

                String strHB = TempText.getText().toString();
                double HeartB =Double.parseDouble(strHB);
                String result;
                if (Temp <= 37 || bloodp < 80 || HeartB <72) {
                    result = "you are at low risk =)";
                } else if (Temp <= 38 || bloodp < 110 || HeartB <160) {
                        result = "you are at medium risk =O";
                } else {
                    result = "you are at High risk =(";
                }
                TextView BMIresult = (TextView) findViewById(R.id.BMIresult);
                BMIresult.setText(result);
            }
        });

    }

}