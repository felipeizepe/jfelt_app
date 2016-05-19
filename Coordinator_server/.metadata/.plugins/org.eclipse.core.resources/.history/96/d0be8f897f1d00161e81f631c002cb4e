package threads;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import entities.Driver;
import managers.Driver_Manager;
import messages.DriverMessage;


public class Driver_Thread extends Thread {

	private Socket driverSocket;
	private ObjectInputStream streamReader;
	private ObjectOutputStream streamWriter;
	private boolean execute;
	private Driver owner;

	/**
	 * Constructor for the Driver_Thread class that receives the socket and
	 * attempts to create the Input and Output streams for receiving and sending
	 * messages
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 * @param Socket
	 *            - Web socket of the client that enables the communication
	 * @throws
	 */
	public Driver_Thread(Socket driverSocket) throws IOException {
		super("Server");
		this.execute = true;
		this.driverSocket = driverSocket;
		this.streamWriter = new ObjectOutputStream(
				driverSocket.getOutputStream());
		this.streamReader = new ObjectInputStream(driverSocket.getInputStream());
		this.owner = null;

	}

	/**
	 * The thread listens for driver communication attempts
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 */
	@Override
	public void run() {
		DriverMessage message;
		System.out.println("Checking for messages");
		while (execute) {

			try {
				message = (DriverMessage) streamReader.readObject();
				System.out.println(message.getMessage());
				this.receiveMessage(message);
			}catch(EOFException end)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				execute = false;
				e.printStackTrace();
			}catch(ClassNotFoundException e1)
			{
				execute = false;
				e1.printStackTrace();
			}
			
			

		}

		try {
			
			streamWriter.close();
			driverSocket.close();
			streamReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * attempts to sends a message to the driver
	 *
	 * @author Felipe Izepe
	 * @version 2.0
	 * @since 2016-04-30
	 * @param message
	 *            - message to be sent
	 * @return True if the message was send successfully and false otherwise
	 */
	public boolean sendMessage(DriverMessage message) {

		try {
			streamWriter.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Ends the communication with the client and finishes the thread
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 */
	public void endConnection() {
		this.execute = false;
		try {
			streamReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void receiveMessage(DriverMessage message)
	{
		this.owner = message.getOwner();
		
		if(message.isRegister())
		{
			//MAKE CHECK UP FOR DRIVER HERE BEFORE ADDING---------------------------------------------------------------
			System.out.println(owner.getName());
			Driver_Manager.getInstance().addDriverThread(this);
		}
		
	}
	
	public Driver getOwner() {
		return owner;
	}
	
}
