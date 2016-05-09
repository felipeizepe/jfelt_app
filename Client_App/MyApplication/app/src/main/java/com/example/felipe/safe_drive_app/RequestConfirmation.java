package com.example.felipe.safe_drive_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;
import entities.Client;


public class RequestConfirmation extends AppCompatActivity {

    public static Client client;
    private Connect_Thread ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_confirmation);

        Intent intent = getIntent();


        client = new Client( intent.getStringExtra(RequestRide.EXTRA_NAME),
                intent.getStringExtra(RequestRide.EXTRA_IDNUMBER),
                intent.getStringExtra(RequestRide.EXTRA_PHONENUMBER),
                intent.getStringExtra(RequestRide.EXTRA_PICKADD),
                intent.getStringExtra(RequestRide.EXTRA_DROPADD),
                intent.getIntExtra(RequestRide.EXTRA_GROUPSIZE, 0),
                intent.getStringExtra(RequestRide.EXTRA_COMMENT),
                intent.getBooleanExtra(RequestRide.EXTRA_HASID, false),
                intent.getBooleanExtra(RequestRide.EXTRA_PICKWITHIN, false),
                intent.getBooleanExtra(RequestRide.EXTRA_DROPWITHIN, false));


        TextView firstName = (TextView) findViewById(R.id.confirm_name_output);
        if(client.getName() != null)
            firstName.setText(client.getName());

        TextView idNumber = (TextView) findViewById(R.id.confirm_id_number_output);
        if(client.getId() != null)
            idNumber.setText(client.getId());

        TextView phoneNumber = (TextView) findViewById(R.id.confirm_phone_number_output);
        if(client.getPhoneNumber() != null)
            phoneNumber.setText(client.getPhoneNumber());

        TextView pickAdd = (TextView) findViewById(R.id.confirm_pickup_address_output);
        if(client.getPickUpAddress() != null)
            pickAdd.setText(client.getPickUpAddress());

        TextView dropAdd = (TextView) findViewById(R.id.confirm_dropoff_address_output);
        if(client.getDropOffAddress() != null)
            dropAdd.setText(client.getDropOffAddress());

        TextView textComments = (TextView) findViewById(R.id.confirm_other_comments_output);
        if(client.getOtherComments() != null)
            textComments.setText(client.getOtherComments());

        final String yesMessage = "Yes";
        final String noMessage = "No";

        TextView questAns1 = (TextView) findViewById(R.id.confirm_answer_1);
        if( client.hasID())
            questAns1.setText(yesMessage);
        else
            questAns1.setText(noMessage);

        TextView questAns2 = (TextView) findViewById(R.id.confirm_answer_2);
        if( client.isPickWithin10() )
            questAns2.setText(yesMessage);
        else
            questAns2.setText(noMessage);

        TextView questAns3 = (TextView) findViewById(R.id.confirm_answer_3);
        if( client.isDropWithin10() )
            questAns3.setText(yesMessage);
        else
            questAns3.setText(noMessage);


        TextView questAns4 = (TextView) findViewById(R.id.confirm_answer_4);

        String test = String.valueOf(client.getNumberOfClients());
        questAns4.setText( test );

        ct = null;

        Connect_Thread.setConnected(false);

        Button fab = (Button) findViewById(R.id.confirm_submit_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ct = new Connect_Thread();
                try {

                    ct.execute("").get();
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
