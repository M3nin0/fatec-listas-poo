package exe_3;

import exe_3.cliente.Cliente;

public class Principal {
	public static void main(String[] args) {

		Cliente cliente = new Cliente("::1", 65530);
		cliente.receiveFile();
	}
}
