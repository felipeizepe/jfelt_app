package threads;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import messages.StudentMessage;

public class Client_Thread extends Thread {

	private Socket clientSocket;
	private ObjectInputStream streamReader;
	private ObjectOutputStream streamWriter;
	private boolean execute;

	/**
	 * Constructor for the Client_Thread class that receives the socket and
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
	public Client_Thread(Socket clientSocket) throws IOException {
		super("Server");
		this.execute = true;
		this.clientSocket = clientSocket;
		this.streamWriter = new ObjectOutputStream(
				clientSocket.getOutputStream());
		this.streamReader = new ObjectInputStream(clientSocket.getInputStream());

	}

	/**
	 * The thread listens for client communication attempts
	 *
	 * @author Felipe Izepe
	 * @version 2.0
	 * @since 2016-04-16
	 */
	@Override
	public void run() {
		StudentMessage message;
		System.out.println("Checking for messages");
		while (execute) {

			try {
					message = (StudentMessage) streamReader.readObject();
					sendMessage(message.getMessage());
					System.out.println(message.getMessage());

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
			streamReader.close();
			streamWriter.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * attempts to sends a message to the client
	 *
	 * @author Felipe Izepe
	 * @version 2.0
	 * @since 2016-04-16
	 * @param message
	 *            - message to be sent
	 * @return True if the message was send successfully and false otherwise
	 */
	public boolean sendMessage(String message) {

		try {
			StudentMessage sm = new StudentMessage(null, message);
			streamWriter.writeObject(sm);
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

}
