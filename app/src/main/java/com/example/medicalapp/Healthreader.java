package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Healthreader extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private Button sendSMS;
    Switch switch1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthreader);

        /** on  imagebutton click set the values of strings to intergers*/
        Button imageButton = (Button) findViewById(R.id.imageButton);
        try {


            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    EditText TempText = (EditText) findViewById(R.id.TempText);
                    Switch switch1 = (Switch) findViewById(R.id.switch1);
                    EditText bpText = (EditText) findViewById(R.id.bpText);
                    EditText HighBP = (EditText) findViewById(R.id.HighBP);
                    EditText Heartbeat = (EditText) findViewById(R.id.Heartbeat);

                    if ((TempText == null) && (bpText == null) && (HighBP == null) && (Heartbeat == null))
                        Toast.makeText(Healthreader.this, "please enter valid results", Toast.LENGTH_SHORT).show();
                    else {


                        String strTemp = TempText.getText().toString();
                        double Temp = Double.parseDouble(strTemp);


                        String strbp = bpText.getText().toString();
                        double bloodp = Double.parseDouble(strbp);


                        String strHbp = HighBP.getText().toString();
                        double bloodHp = Double.parseDouble(strHbp);


                        String strHB = Heartbeat.getText().toString();
                        double HeartB = Double.parseDouble(strHB);
                        String result;
                        /**  make the email and message tab set to gone so thier not displayed for when the user does another test*/
                        EditText emailadd = (EditText) findViewById(R.id.emailadd);
                        emailadd.setVisibility(View.GONE);
                        EditText subject = (EditText) findViewById(R.id.subject);
                        subject.setVisibility(View.GONE);
                        EditText Message = (EditText) findViewById(R.id.Message);
                        Message.setVisibility(View.GONE);
                        Button sendEmail = (Button) findViewById(R.id.sendEmail);
                        sendEmail.setVisibility(View.GONE);

                        EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
                        phoneNumber.setVisibility(View.GONE);
                        EditText smsText = (EditText) findViewById(R.id.smsText);
                        smsText.setVisibility(View.GONE);
                        Button sendSMS = (Button) findViewById(R.id.sendSMS);
                        sendSMS.setVisibility(View.GONE);

                        /**  if statement determining the results for the healthreader using the intergers that where taken form the textfields*/

                        if ((Temp <= 37) && (bloodp < 80) && (bloodHp < 120) && (HeartB < 72)) {
                            result = "you are not at risk =)";

                        } else if ((Temp > 37 && Temp <= 38) || (bloodp >= 80 && bloodp <= 110) || (bloodHp >= 120 && bloodHp <= 180) || (HeartB >= 72 && HeartB <= 160)) {
                            result = "you are at low risk =O";
                        } else {
                            if (switch1.isChecked()) {

                                emailadd.setVisibility(View.VISIBLE);

                                subject.setVisibility(View.VISIBLE);

                                Message.setVisibility(View.VISIBLE);

                                sendEmail.setVisibility(View.VISIBLE);
                            }
                            /**  if the user had the switch unselected for a text msg then display the txt msg fields*/
                            else {

                                phoneNumber.setVisibility(View.VISIBLE);

                                smsText.setVisibility(View.VISIBLE);

                                sendSMS.setVisibility(View.VISIBLE);

                            }

                            result = "you are at High risk =(";
                        }
                        /** prints the result of the health reader out */
                        TextView BMIresult = (TextView) findViewById(R.id.BMIresult);
                        BMIresult.setText(result);
                        /** if the user had the switch ticked for email then if a high risk is the result display email fields */

                    }
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
        EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        EditText smsText = (EditText) findViewById(R.id.smsText);
        Button sendSMS = (Button) findViewById(R.id.sendSMS);
        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            /**  on click get the data form the text fields and automatically send the information as a text message in the users contacts*/
            public void onClick(View v) {
                try {
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(phoneNumber.getText().toString(), null, smsText.getText().toString(), null, null);
                    Toast.makeText(Healthreader.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Healthreader.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button sendEmail = (Button) findViewById(R.id.sendEmail);
        /** on click stats the send email function*/
        sendEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    /** bundles the infomration for the email so it can be sent to the email application e.g GMAIL*/
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        EditText emailadd = (EditText) findViewById(R.id.emailadd);
        EditText Message = (EditText) findViewById(R.id.Message);
        String SUB = emailadd.getText().toString();
        String MES = Message.getText().toString();

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, SUB);
        emailIntent.putExtra(Intent.EXTRA_TEXT, MES);
        /** try to send email*/
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
            /** if email fails to send display toast message*/
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Healthreader.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}







