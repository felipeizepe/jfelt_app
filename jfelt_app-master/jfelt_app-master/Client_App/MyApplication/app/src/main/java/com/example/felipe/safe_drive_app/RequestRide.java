package com.example.felipe.safe_drive_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.felipe.safe_drive_app.entities.AppLocationService;
import com.example.felipe.safe_drive_app.entities.LocationAddress;

import java.util.concurrent.ExecutionException;
import entities.Client;

public class RequestRide extends AppCompatActivity {

    AppLocationService appLocationService;
    Button gps_button;
    EditText pickup_address;

    public static Client answers = new Client();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride);
        pickup_address = (EditText) findViewById(R.id.pickup_address);
        appLocationService = new AppLocationService(RequestRide.this);

        gps_button = (Button) findViewById(R.id.gps_button);
        gps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Location location = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());
                } else {
                    showSettingsAlert();
                }

            }
        });
    }

    public void getGPSLocation(View view) {


    }
    //method for the yes/no checkboxes
    public void selectYesNo(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {

            case R.id.request_quest_answer_yes_1:
                if (checked) {
                    answers.setHasID(true);
                    CheckBox ansNo1 = (CheckBox) findViewById(R.id.request_quest_answer_no_1);
                    ansNo1.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_1:
                if (checked) {
                    answers.setHasID(false);
                    CheckBox ansYes1 = (CheckBox) findViewById(R.id.request_quest_answer_yes_1);
                    ansYes1.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_2:
                if (checked) {
                    answers.setIsPickWithin10(true);
                    CheckBox ansNo2 = (CheckBox) findViewById(R.id.request_quest_answer_no_2);
                    ansNo2.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_2:
                if (checked) {
                    answers.setIsPickWithin10(false);
                    CheckBox ansYes2 = (CheckBox) findViewById(R.id.request_quest_answer_yes_2);
                    ansYes2.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_3:
                if (checked) {
                    answers.setIsDropWithin10(true);
                    CheckBox ansNo3 = (CheckBox) findViewById(R.id.request_quest_answer_no_3);
                    ansNo3.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_3:
                if (checked) {
                    answers.setIsDropWithin10(false);
                    CheckBox ansYes3 = (CheckBox) findViewById(R.id.request_quest_answer_yes_3);
                    ansYes3.setChecked(false);
                }
                break;
            }
    }

    public void sendToConfirmation(View view) {
        EditText name = (EditText) findViewById(R.id.client_name);
        String nameString = name.getText().toString();
        if (TextUtils.isEmpty(nameString)) {
            name.setError("Name is required.");
        }
        EditText idNumber = (EditText) findViewById(R.id.client_id_number);
        String idNumberString = idNumber.getText().toString();
        if (TextUtils.isEmpty(idNumberString)) {
            idNumber.setError("Sac State ID is required.");
        }
        EditText phoneNumber = (EditText) findViewById(R.id.client_phone_number);
        String phoneNumberString = phoneNumber.getText().toString();
        if (TextUtils.isEmpty(phoneNumberString)) {
            phoneNumber.setError("Phone number is required.");
        }
        EditText pickupAddress = (EditText) findViewById(R.id.pickup_address);
        String pickupAddressString = pickupAddress.getText().toString();
        if (TextUtils.isEmpty(pickupAddressString)) {
            pickupAddress.setError("Pick-up address is required.");
        }
        EditText dropoffAddress = (EditText) findViewById(R.id.dropoff_address);
        String dropoffAddressString = dropoffAddress.getText().toString();
        if (TextUtils.isEmpty(dropoffAddressString)) {
            dropoffAddress.setError("Drop-off address is required.");
        }
        EditText otherComments = (EditText) findViewById(R.id.other_comments);
        String otherCommentsString = otherComments.getText().toString();
        if (TextUtils.isEmpty(otherCommentsString) && TextUtils.isEmpty(pickupAddressString)) {
            otherComments.setError("If no pick-up address, a description of your location " +
                    "is required.");
        }
        EditText groupSize = (EditText) findViewById(R.id.request_quest_answer_4);
        String groupSizeString = groupSize.getText().toString();
        if (TextUtils.isEmpty(groupSizeString)) {
            groupSize.setError("Size of group is required.");
        }

        if(     !TextUtils.isEmpty(nameString)
                && ( !TextUtils.isEmpty(idNumberString)
                || !answers.hasID() )
                && !TextUtils.isEmpty(phoneNumberString)
                && !TextUtils.isEmpty(pickupAddressString)
                && !TextUtils.isEmpty(dropoffAddressString)
                && !TextUtils.isEmpty(groupSizeString) ) {

            Intent submitIntent = new Intent(this, RequestConfirmation.class);

            Bundle newBundle = new Bundle();

            newBundle.putString("extra_name", nameString);
            newBundle.putString("extra_id_number", idNumberString);
            newBundle.putString("extra_phone_number", phoneNumberString);
            newBundle.putString("extra_pickup_address", pickupAddressString);
            newBundle.putString("extra_dropoff_address", dropoffAddressString);
            newBundle.putString("extra_other_comments", otherCommentsString);
            newBundle.putBoolean("extra_has_id", answers.hasID());
            newBundle.putBoolean("extra_pick_within", answers.isPickWithin10());
            newBundle.putBoolean("extra_drop_within", answers.isDropWithin10());
            int groupSizeInt = Integer.parseInt(groupSizeString);
            newBundle.putInt("extra_number_of_clients", groupSizeInt);
            newBundle.putBoolean("extra_has_driver", answers.hasDriver());
            newBundle.putBoolean("extra_request_made", answers.isRequestMade());

            submitIntent.putExtras(newBundle);

            startActivity(submitIntent);
        }
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(RequestRide.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("GPS is disabled! Please enable it in your settings " +
                "to use this feature.");
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        RequestRide.this.startActivity(intent);
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            pickup_address.setText(locationAddress);
        }
    }
}
