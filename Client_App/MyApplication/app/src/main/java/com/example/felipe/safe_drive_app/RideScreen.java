package com.example.felipe.safe_drive_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import entities.Client;
import entities.Driver;
import managers.Manager;
import messages.StudentMessage;
import java.lang.InterruptedException;

public class RideScreen extends AppCompatActivity {

    private Client client;
    public static TextView status;
    public static TextView message;

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

        this.status = (TextView) findViewById(R.id.ride_status_display);
        this.message = (TextView) findViewById(R.id.request_incoming_message_display);


        while(!Manager.getInstance().Client_HasNewMessage());

        StudentMessage sm = Manager.getInstance().Client_ReceiveNewMessge();

            if (sm.isAssignment()) {
                Driver driver = sm.getOwner().getAssignedDriver();
                RideScreen.status.setText("Request accepted.");
                RideScreen.message.append("Driver Info: \n");
                RideScreen.message.append("Name: " + driver.getName() + "\n");
                RideScreen.message.append("Phone-Number: " + driver.getPhoneNumber() + "\n");
                RideScreen.message.append("License: " + driver.getLicense() + "\n");
                RideScreen.message.append("Car description: " + driver.getCarDescription() + "\n");

            }else
            {
                RideScreen.status.setText("Request Denied.");
            }



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
