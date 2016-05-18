package com.example.felipe.safe_drive_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class RegisterDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_driver);
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