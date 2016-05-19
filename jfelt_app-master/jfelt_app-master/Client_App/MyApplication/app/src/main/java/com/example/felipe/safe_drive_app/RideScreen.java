package com.example.felipe.safe_drive_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import entities.Client;

public class RideScreen extends AppCompatActivity {

    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_screen);

        Intent intent = getIntent();

        Bundle oldBundle = intent.getExtras();

        client = new Client(oldBundle.getString("extra_name"),
                oldBundle.getString("extra_id_number"),
                oldBundle.getString("extra_phone_number"),
                oldBundle.getString("extra_pickup_address"),
                oldBundle.getString("extra_dropoff_address"),
                oldBundle.getInt("extra_number_of_clients", 0),
                oldBundle.getString("extra_other_comments"),
                oldBundle.getBoolean("extra_has_id", false),
                oldBundle.getBoolean("extra_pick_within", false),
                oldBundle.getBoolean("extra_drop_within", false));

        client.setHasDriver(oldBundle.getBoolean("extra_has_driver"));
        client.setRequestMade(oldBundle.getBoolean("extra_request_made"));

        /*String pendingMessage = "Request pending.";
        String acceptedMessage = "Request accepted.";
        String noRequestMessage = "No Ride Requested.";

        TextView rideStatusMessage = (TextView) findViewById(R.id.server_status);
        if( !client.isRequestMade())
            rideStatusMessage.setText(noRequestMessage);
        else if( client.isRequestMade() && client.hasDriver())
            rideStatusMessage.setText(acceptedMessage);
        else if( client.isRequestMade() && !client.hasDriver())
            rideStatusMessage.setText(pendingMessage);*/

    }

    public void openCancelRide( View view ){
        Intent cancelIntent = new Intent( this, CancelRide.class );
        startActivity( cancelIntent );
    }
}
