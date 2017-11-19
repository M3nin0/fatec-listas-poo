package exe_2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
	private String nomeDeUsuario;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;

	public Client(String nomeDeUsuario, String ipServer, int porta) throws UnknownHostException, IOException {
		this.nomeDeUsuario = nomeDeUsuario;
		socket = new Socket(ipServer, porta);

		writer = new PrintWriter(socket.getOutputStream(), true);
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	}

	public void send(String msg) {
		writer.println(nomeDeUsuario + " diz: " + msg);
	}

	public void run() {

		while (true) {
			try {
				System.out.println(reader.readLine());
			} catch (Exception e) {
				System.out.println("Erro na leitura da mensagem");
			}
		}
	}
}
