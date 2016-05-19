package com.example.felipe.safe_drive_app;

/**
 * Created by felipe on 2/29/2016.
 */
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.Socket;
import java.io.ObjectOutputStream;
import messages.StudentMessage;
import messages.DriverMessage;
import entities.Client;
import entities.Driver;

public class Connect_Thread extends AsyncTask<String, Void, Integer> {


    private static boolean connected;
    private static Socket server;
    private static ObjectOutputStream streamWriter;
    private static Communication_Thread cm;

    protected Integer doInBackground(String... message) {

        if(!connected) {
            try {
                if(message[0].equals("0")) {
                    server = new Socket("10.0.2.2", 4444);  //connect to server
                    cm = new Communication_Thread(server,true);
                }
                if(message[0].equals("1")) {
                    server = new Socket("10.0.2.2", 4445);  //connect to server
                    cm = new Communication_Thread(server, false);
                }
                streamWriter = new ObjectOutputStream(server.getOutputStream());
                connected = true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if(message[0].equals("0")) {
                Client ct = RequestConfirmation.client;


                Log.i("info name: ", ct.getName());

                StudentMessage sm = new StudentMessage(ct, "REQUEST RIDE");
                sm.setType(2);
                streamWriter.writeObject(sm);

            }else if(message[0].equals("1"))
            {
                Driver ct = RegisterDriver.driver;


                Log.i("info name: ", ct.getName());

                DriverMessage sm = new DriverMessage(ct, "Register Driver");
                sm.setType(2);
                streamWriter.writeObject(sm);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return 0;
    }

    public static void setConnected(boolean bool)
    {

        connected = bool;
    }

    public void closeConnection()
    {
        try {
            cm.stopCommunication();
            streamWriter.close();
            server.close();   //closing the connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startCommunication()
    {
        if(connected)
            if(!cm.isExecuting())
            cm.start();
    }
}
