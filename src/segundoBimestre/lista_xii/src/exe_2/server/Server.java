package exe_2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server implements Runnable {

	private final int PORTA = 4044;
	private ServerSocket serverSocket;
	private Set<Socket> clientes;
	private PrintWriter broadCast;

	public Server() {
		clientes = new HashSet<>();
		try {
			serverSocket = new ServerSocket(PORTA);
			System.out.println("Servidor inicializado em " + serverSocket.getLocalSocketAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sentBroadCast(String msg) throws IOException {
		for (Socket cliente : clientes) {
			broadCast = new PrintWriter(cliente.getOutputStream(), true);
			broadCast.println(msg);
		}
	}

	public void escutador(Socket socket) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Novo cliente conectado");
			while (true) {
				sentBroadCast(reader.readLine());
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				clientes.add(socket);
				new Thread() {
					public void run() {
						try {
							escutador(socket);
						} catch (Exception e) {
							System.out.println("Erro ao criar o socket com o cliente");
						}
					}
				}.start();
			} catch (IOException e) {
				System.out.println("Erro ao tentar realizar a comunicação com o cliente");
			}
		}
	}

	public static void main(String[] args) {
		Server server = new Server();

		new Thread(server).start();
	}

}
