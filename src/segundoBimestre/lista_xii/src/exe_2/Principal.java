package exe_2;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import exe_2.client.Client;

public class Principal {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Insira seu nome de usuário");
		String nomeDeUsuario = scan.next();

		try {
			Client client = new Client(nomeDeUsuario, "::1", 4044);
			new Thread(client).start();

			while (true) {
				System.out.println("Digite a mensagem que será enviada");
				client.send(scan.next());
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
