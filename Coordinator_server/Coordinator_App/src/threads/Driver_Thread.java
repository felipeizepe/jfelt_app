package threads;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import messages.StudentMessage;

public class Driver_Thread extends Thread {

	private Socket driverSocket;
	private ObjectInputStream streamReader;
	private ObjectOutputStream streamWriter;
	private boolean execute;

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
		StudentMessage message;
		System.out.println("Checking for messages");
		while (execute) {

			try {
				if (streamReader.available() > 0) {
					message = (StudentMessage) streamReader.readObject();
					System.out.println(message.getMessage());
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			streamReader.close();
			streamWriter.close();
			driverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * attempts to sends a message to the driver
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 * @param message
	 *            - message to be sent
	 * @return True if the message was send successfully and false otherwise
	 */
	public boolean sendMessage(String message) {

		try {
			ObjectOutputStream bufferWriter = new ObjectOutputStream(streamWriter);
			StudentMessage sm = new StudentMessage(null, message);
			bufferWriter.writeObject(sm);
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
	}

}
