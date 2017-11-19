package exe_1;

import java.io.IOException;

import exe_1.client.Client;

public class Principal {

	public static void main(String[] args) {
		Client client = new Client("::1", 5678);
		try {
			client.listener();
		} catch (IOException e) {
			System.out.println("Erro na comunicação com o servidor");
		}
	}
}
