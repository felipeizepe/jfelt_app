package com.example.felipe.safe_drive_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class Home_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__menu);

        TextView serverStatusMessage = (TextView) findViewById(R.id.server_status);
        String startDate = "2016-09-01 10:00:00";
        Calendar timeNow = Calendar.getInstance();
        if( timeNow.after( startDate )  ) {
            String upStatus = "Safe Rides is currently available.";
            serverStatusMessage.setText(upStatus);
        }
        else{
            String downStatus = "Safe Rides is currently unavailable.";
            serverStatusMessage.setText(downStatus);
        }
    }

    public void openRequestRide( View view ){
        Intent requestIntent = new Intent( this, RequestRide.class );
        startActivity( requestIntent );
    }

    public void openRegisterDriver( View view ){
        Intent registerIntent = new Intent( this, RegisterDriver.class );
        startActivity(registerIntent);
    }

    public void openAboutPage( View view ){
        Intent aboutIntent = new Intent( this, AboutUs.class );
        startActivity( aboutIntent );
    }

    public void gotoFormfill( View view ){
        Intent testIntent = new Intent( this, Form_Fill.class );
        startActivity( testIntent );
    }
}
