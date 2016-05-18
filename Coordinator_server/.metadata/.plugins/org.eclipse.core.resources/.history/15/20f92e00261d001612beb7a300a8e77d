package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientServer extends Thread{

	private ServerSocket serverSocket;
	private List<Client_Thread> clients;
	private boolean runServer;
	
	public ClientServer() {
		this.clients = new ArrayList<Client_Thread>();
		this.runServer = true;
	}
	

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(4444); // Server socket

		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("Server started. Listening to the port 4444");

		while (runServer) {
			try {
				Socket clientSocket = serverSocket.accept(); // accept the client connection
				Client_Thread ct = new Client_Thread(clientSocket);
				ct.start();
				this.clients.add(ct);
				

			} catch (IOException ex) {
		
				System.out.println("No longer Listening to the port 4444");
			}
		}

	}
	
	/**
	 * Sends a Message to all of the Clients
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-25
	 * @param Message - Message to be sent
	 */
	public void messageAll(String message)
	{
		Client_Thread ct;
		for(int count1 = 0; count1 < clients.size(); count1++)
		{
			ct = clients.get(count1);
			ct.sendMessage(message);
		}
	}
	
	public void stopServer()
	{
		Client_Thread ct;
		for(int count1 = 0; count1 < clients.size(); count1++)
		{
			ct = clients.get(count1);
			ct.endConnection();
		}
		
		
		this.runServer = false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}