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
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.felipe.safe_drive_app.entities.AppLocationService;
import com.example.felipe.safe_drive_app.entities.LocationAddress;

import java.util.concurrent.ExecutionException;

public class RequestRide extends AppCompatActivity {
    public final static String EXTRA_FIRSTNAME = "jfelt.saferides.FIRSTNAME";
    public final static String EXTRA_LASTNAME = "jfelt.saferides.LASTNAME";
    public final static String EXTRA_IDNUMBER = "jfelt.saferides.IDNUMBER";
    public final static String EXTRA_PICKADD = "jfelt.saferides.PICKADD";
    public final static String EXTRA_DROPADD = "jfelt.saferides.DROPADD";
    public final static String EXTRA_COMMENT = "jfelt.saferides.COMMENTS";
    public final static String EXTRA_HASID = "jfelt.saferides.HASID";
    public final static String EXTRA_PICKWITHIN = "jfelt.saferides.PICKWITHIN";
    public final static String EXTRA_DROPWITHIN = "jfelt.saferides.DROPWITHIN";
    public final static String EXTRA_GROUPSIZE = "jfelt.saferides.GROUPSIZE";
    AppLocationService appLocationService;
    Button gps_button;
    EditText pickup_address;
    //RequestRideConfirm.Client client = new RequestRideConfirm.Client();

    Client answers = new Client();

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

    public void selectYesNo(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {

            case R.id.request_quest_answer_yes_1:
                if (checked) {
                    answers.hasID = true;
                    CheckBox ansNo1 = (CheckBox) findViewById(R.id.request_quest_answer_no_1);
                    ansNo1.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_1:
                if (checked) {
                    answers.hasID = false;
                    CheckBox ansYes1 = (CheckBox) findViewById(R.id.request_quest_answer_yes_1);
                    ansYes1.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_2:
                if (checked) {
                    answers.pickWithin10 = true;
                    CheckBox ansNo2 = (CheckBox) findViewById(R.id.request_quest_answer_no_2);
                    ansNo2.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_2:
                if (checked) {
                    answers.pickWithin10 = false;
                    CheckBox ansYes2 = (CheckBox) findViewById(R.id.request_quest_answer_yes_2);
                    ansYes2.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_3:
                if (checked) {
                    answers.dropWithin10 = true;
                    CheckBox ansNo3 = (CheckBox) findViewById(R.id.request_quest_answer_no_3);
                    ansNo3.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_3:
                if (checked) {
                    answers.dropWithin10 = false;
                    CheckBox ansYes3 = (CheckBox) findViewById(R.id.request_quest_answer_yes_3);
                    ansYes3.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_4:
                if (checked) {
                    answers.groupSize = true;
                    CheckBox ansNo4 = (CheckBox) findViewById(R.id.request_quest_answer_no_4);
                    ansNo4.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_4:
                if (checked) {
                    answers.groupSize = false;
                    CheckBox ansYes4 = (CheckBox) findViewById(R.id.request_quest_answer_yes_4);
                    ansYes4.setChecked(false);
                }
                break;

        }
    }

    public void sendToConfirmation(View view) {
        Intent submitIntent = new Intent(this, RequestConfirmation.class);

        EditText firstName = (EditText) findViewById(R.id.client_first_name);
        String firstNameString = firstName.getText().toString();
        submitIntent.putExtra(EXTRA_FIRSTNAME, firstNameString);

        EditText lastName = (EditText) findViewById(R.id.client_last_name);
        String lastNameString = lastName.getText().toString();
        submitIntent.putExtra(EXTRA_LASTNAME, lastNameString);

        EditText idNumber = (EditText) findViewById(R.id.client_id_number);
        String idNumberString = idNumber.getText().toString();
        submitIntent.putExtra(EXTRA_IDNUMBER, idNumberString);

        EditText pickupAddress = (EditText) findViewById(R.id.pickup_address);
        String pickupAddressString = pickupAddress.getText().toString();
        submitIntent.putExtra(EXTRA_PICKADD, pickupAddressString);

        EditText dropoffAddress = (EditText) findViewById(R.id.dropoff_address);
        String dropoffAddressString = dropoffAddress.getText().toString();
        submitIntent.putExtra(EXTRA_DROPADD, dropoffAddressString);

        EditText otherComments = (EditText) findViewById(R.id.other_comments);
        String otherCommentsString = otherComments.getText().toString();
        submitIntent.putExtra(EXTRA_COMMENT, otherCommentsString);

        submitIntent.putExtra(EXTRA_HASID, answers.hasID);
        submitIntent.putExtra(EXTRA_PICKWITHIN, answers.pickWithin10);
        submitIntent.putExtra(EXTRA_DROPWITHIN, answers.dropWithin10);
        submitIntent.putExtra(EXTRA_GROUPSIZE, answers.groupSize);

        startActivity(submitIntent);
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(RequestRide.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("GPS is disabled! Please enable it in your settings to use this feature.");
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
