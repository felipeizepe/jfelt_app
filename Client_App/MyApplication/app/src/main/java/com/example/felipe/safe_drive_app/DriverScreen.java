package com.example.felipe.safe_drive_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import entities.*;
import managers.Manager;
import messages.DriverMessage;

public class DriverScreen extends AppCompatActivity {

    public static TextView status;
    public static TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_screen);


        this.status = (TextView) findViewById(R.id.ride_status_display);
        this.message = (TextView) findViewById(R.id.request_incoming_message_display);

        while(!Manager.getInstance().Driver_HasNewMessage());

            DriverMessage dm = Manager.getInstance().Driver_ReceiveNewMessge();

            if (dm.isAssign()) {
                entities.Client client = dm.getOwner().getCurrentClient();
                DriverScreen.status.setText("Request Received.");
                DriverScreen.message.append("Client Info: \n");
                DriverScreen.message.append("Name: " + client.getName() + "\n");
                DriverScreen.message.append("Phone-Number: " + client.getPhoneNumber() + "\n");
                DriverScreen.message.append("Pick-up address: " + client.getPickUpAddress() + "\n");
                DriverScreen.message.append("Drop-off address: " + client.getDropOffAddress() + "\n");
                DriverScreen.message.append("Other: " + client.getOtherComments() + "\n");
                DriverScreen.message.append("Number of people: " + client.getNumberOfClients() + "\n");
            }else
            {
                RideScreen.status.setText("Request Denied.");
            }

    }
}
