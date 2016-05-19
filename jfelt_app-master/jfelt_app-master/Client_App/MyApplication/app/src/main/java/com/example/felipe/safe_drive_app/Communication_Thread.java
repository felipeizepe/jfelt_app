package com.example.felipe.safe_drive_app;


import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;

import messages.DriverMessage;
import messages.StudentMessage;

/**
 * Created by felipe on 4/18/2016.
 */
public class Communication_Thread extends Thread{

    private Socket server;
    private ObjectInputStream streamReader;
    private boolean execute;
    private boolean isClient;



    public Communication_Thread(Socket server, boolean isClient) throws IOException
    {
        this.server = server;
        this.streamReader = new ObjectInputStream(server.getInputStream());
        this.execute = false;
        this.isClient = isClient;
    }

    public void  run() {

        execute = true;
       while (execute) {
            try {
                if(isClient) {
                    StudentMessage messageReceived;
                    messageReceived = (StudentMessage) streamReader.readObject();
                    Log.i("info", messageReceived.getMessage());
                }
                else {
                    DriverMessage messageReceived;
                    messageReceived = (DriverMessage) streamReader.readObject();
                    Log.i("info", messageReceived.getMessage());
                }


            } catch (IOException e) {
                execute = false;
                e.printStackTrace();
            }catch(ClassNotFoundException e1)
            {
                execute = false;
                e1.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            Log.i("info", "Ended Info Receiver");
            streamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopCommunication()
    {
        this.execute = false;
    }

    public boolean isExecuting()
    {
        return execute;
    }
}
