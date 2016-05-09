package com.example.felipe.safe_drive_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import entities.*;
import entities.Driver;

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

       name = (EditText) findViewById(R.id.driver_first_name);
       phone = (EditText) findViewById(R.id.driver_last_name);
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


}
