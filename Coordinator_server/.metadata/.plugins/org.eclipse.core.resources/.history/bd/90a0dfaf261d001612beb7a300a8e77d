package threads;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DriverServer extends Thread{

	private ServerSocket serverSocket;
	private List<Driver_Thread> drivers;
	private boolean runServer;
	
	public DriverServer() {
		this.drivers = new ArrayList<Driver_Thread>();
		this.runServer = true;
	}
	

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(4445); // Server socket

		} catch (IOException e) {
			System.out.println("Could not listen on port: 4445");
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("Server started. Listening to the port 4445");

		while (runServer) {
			try {
				Socket clientSocket = serverSocket.accept(); // accept the client connection
				Driver_Thread ct = new Driver_Thread(clientSocket);
				ct.start();
				this.drivers.add(ct);
				

			} catch (IOException ex) {

				System.out.println("No longer Listening to the port 4445");
			}
		}

	}
	
	
	public void messageAll(String message)
	{
		Driver_Thread ct;
		for(int count1 = 0; count1 < drivers.size(); count1++)
		{
			ct = drivers.get(count1);
			ct.sendMessage(message);
		}
	}
	
	public void stopServer()
	{
		this.runServer = false;
		
		Driver_Thread ct;
		for(int count1 = 0; count1 < drivers.size(); count1++)
		{
			ct = drivers.get(count1);
			ct.endConnection();
		}
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}