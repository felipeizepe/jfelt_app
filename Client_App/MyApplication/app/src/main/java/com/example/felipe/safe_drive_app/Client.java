package com.example.felipe.safe_drive_app;

import java.lang.String;
import java.lang.StringBuilder;

/**
 * Created by Eljin on 5/1/2016.
 */
public class Client {
    String firstName;
    String lastName;
    String idNumber;
    String pickupAddress;
    String dropoffAddress;
    String otherComments;
    boolean hasID;
    boolean pickWithin10;
    boolean dropWithin10;
    boolean groupSize;
    boolean requestMade = false;

    public void inputInfo(){

    }

    private void hasRequested(){
        requestMade = true;
    }

    private String getFullName( String firstName, String lastName ){
        String fullName = new String( firstName + " " + lastName);
        return fullName;
    }
}