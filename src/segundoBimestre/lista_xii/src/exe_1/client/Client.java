package exe_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	private BufferedReader reader;
	private Socket socket;
	private String msg;

	public Client(String ipServer, int portServer) {
		try {
			socket = new Socket(ipServer, portServer);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (Exception e) {
			System.out.println("Impossível se conectar ao servidor");
		}
	}

	public void listener() throws IOException {
		while (true) {
			msg = reader.readLine();

			System.out.println("Servidor diz: " + msg);
		}
	}

}
