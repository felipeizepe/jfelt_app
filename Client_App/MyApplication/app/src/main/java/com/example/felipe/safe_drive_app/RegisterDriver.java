package com.example.felipe.safe_drive_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//<<<<<<<HEAD
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
//=======
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import entities.*;
import entities.Driver;
//>>>>>>>origin/master

public class RegisterDriver extends AppCompatActivity {

    public static entities.Driver driver;
    private Connect_Thread ct;
    private EditText name;
    private EditText phone;
    private EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_driver);

       name = (EditText) findViewById(R.id.driver_name);
       phone = (EditText) findViewById(R.id.driver_phone_number);
       id = (EditText) findViewById(R.id.driver_id_number);



        ct = null;

        Connect_Thread.setConnected(false);

        Button fab = (Button) findViewById(R.id.register_submit_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                driver = new Driver(name.getText().toString(), id.getText().toString(),phone.getText().toString(), null, null);
                ct = new Connect_Thread();
                try {

                    ct.execute("1").get();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                }

                ct.startCommunication();
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(ct != null)
            ct.closeConnection();

        Connect_Thread.setConnected(false);
        super.onBackPressed();
    }

    public void openDriverScreen( View view ) {

        EditText name = (EditText) findViewById(R.id.driver_name);
        String nameString = name.getText().toString();
        if (TextUtils.isEmpty(nameString)) {
            name.setError("Name is required.");
        }
        EditText idNumber = (EditText) findViewById(R.id.driver_id_number);
        String idNumberString = idNumber.getText().toString();
        if (TextUtils.isEmpty(idNumberString)) {
            idNumber.setError("Sac State ID is required.");
        }
        EditText phoneNumber = (EditText) findViewById(R.id.driver_phone_number);
        String phoneNumberString = phoneNumber.getText().toString();
        if (TextUtils.isEmpty(phoneNumberString)) {
            phoneNumber.setError("Phone number is required.");
        }


        if (!TextUtils.isEmpty(nameString)
                && !TextUtils.isEmpty(idNumberString)
                && !TextUtils.isEmpty(phoneNumberString)) {

            Intent submitIntent = new Intent(this, DriverScreen.class);

            startActivity(submitIntent);
        }
    }
}