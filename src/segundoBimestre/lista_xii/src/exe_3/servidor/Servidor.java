package exe_3.servidor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * O servidor irá fazer o envio para cada um que realizar a conexão com ele
 */

public class Servidor implements Runnable {

	private final int PORTA = 65530;
	private ServerSocket server;
	private BufferedInputStream inputFile;
	private Scanner scan;

	public Servidor() {

		scan = new Scanner(System.in);
		try {
			server = new ServerSocket(PORTA);
		} catch (IOException e) {
			System.out.println("Erro ao iniciar o servidor");
		}
	}
	
	/*
	 * Faz o envio do arquivo
	 * Utiliza o buffer para fazer o armazenamento temporário do arquivo enquanto o mesmo está sendo enviado
	 */

	public void sendFile(Socket socket, String path) throws IOException {

		inputFile = new BufferedInputStream(new FileInputStream(new File(path)));
		byte[] content = new byte[(int) new File(path).length()];

		// Escreve o conteúdo do arquivo que foi lido
		inputFile.read(content, 0, content.length);
		socket.getOutputStream().write(content, 0, content.length);
	}

	@Override
	public void run() {
		System.out.println("Servidor inicializado em " + server.getLocalSocketAddress());

		System.out.println("Insira o caminho absoluto do arquivo a ser enviado para os clientes");
		String path = scan.next();

		while (true) {
			try {
				sendFile(server.accept(), path);
			} catch (IOException e) {
				System.out.println("Impossível salvar o arquivo recebido");
			}
		}
	}
	public static void main(String[] args) {
		Servidor server = new Servidor();
		new Thread(server).start();
	}
}
