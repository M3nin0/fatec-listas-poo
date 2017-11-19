package exe_1.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Server implements Runnable {

	private final int PORTA = 5678;
	private Set<Socket> sockets;
	private PrintWriter printer;

	public Server() {
		sockets = new HashSet<>();
	}

	public void broadCast(String cast) {
		new Thread() {
			public void run() {
				for (Socket socket : sockets) {
					try {
						printer = new PrintWriter(socket.getOutputStream(), true);
						printer.println(cast);
					} catch (IOException e) {
						System.out.println("Erro ao enviar informações para os clientes");
					}
				}
			}
		}.start();
	}

	public void run() {
		ServerSocket server = null;

		try {
			server = new ServerSocket(PORTA);

			while (true) {
				// Escutando novas conexões
				sockets.add(server.accept());

				System.out.println("Um cliente conectou-se");
			}

		} catch (IOException e) {
			System.out.println("Não foi possível iniciar o servidor");
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		Scanner scan = new Scanner(System.in);

		new Thread(server).start();

		String msg = "";

		while (!(msg.equals("sair"))) {
			System.out.println("Insira uma mensagem para os clientes");
			msg = scan.next();

			server.broadCast(msg);
		}

		scan.close();

	}

}
