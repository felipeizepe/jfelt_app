package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client_Thread implements Runnable {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	private String message;

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

		while (true) {
			try {
				clientSocket = serverSocket.accept(); // accept the client connection

				inputStreamReader = new InputStreamReader(
				clientSocket.getInputStream());

				bufferedReader = new BufferedReader(inputStreamReader); // get the client message

				message = bufferedReader.readLine();

				System.out.println(message);

				inputStreamReader.close();

				clientSocket.close();

			} catch (IOException ex) {

				System.out.println("Problem in message reading");
			}
		}

	}

}
