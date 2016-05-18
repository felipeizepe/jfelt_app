package managers;

import com.example.felipe.safe_drive_app.Communication_Thread;
import com.example.felipe.safe_drive_app.Connect_Thread;

import java.util.concurrent.ExecutionException;

import entities.Client;
import entities.Driver;
import messages.DriverMessage;
import messages.StudentMessage;

/**
 * Created by felipe on 5/18/2016.
 */
public class Manager {
    private static Manager self;
    private Client client;
    private Driver driver;
    private Connect_Thread ct;
    private static Communication_Thread cm;

    private Manager()
    {
        driver = null;
        client = null;
        ct = null;

        Connect_Thread.setConnected(false);

    }

    public static Manager getInstance()
    {
        if(self == null)
            self = new Manager();

        return self;
    }

    public void Client_ConnectToServer(Client client) {
        if (ct != null) return;
        this.client = client;

        ct = new Connect_Thread();
        try {

            ct.execute("0").get();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    public void Driver_ConnectToServer(Driver driver)
    {
        if(ct != null) return;
        this.driver = driver;

        ct = new Connect_Thread();
        try {

            ct.execute("1").get();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }

        ct.startCommunication();
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void closeConnection()
    {
        if (ct != null)
            ct.closeConnection();

        Connect_Thread.setConnected(false);
        ct = null;
    }


    public boolean Client_HasNewMessge()
    {
        return ct.getCommunication().hasNewStudentMessage();
    }

    public boolean Driver_HasNewMessge()
    {
        return ct.getCommunication().hasNewStudentMessage();
    }

    public StudentMessage Client_ReceiveNewMessge()
    {
        return ct.getCommunication().getStudentMessage();
    }

    public DriverMessage Driver_ReceiveNewMessge()
    {
        return ct.getCommunication().getDriverMessage();
    }
}

