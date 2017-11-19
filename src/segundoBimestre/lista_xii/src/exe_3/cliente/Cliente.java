package exe_3.cliente;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	private Socket socket;
	private byte[] content;
	private FileOutputStream outputFile;
	private BufferedOutputStream outputBuffer;
	private InputStream inputStream;
	private Scanner scan;

	public Cliente(String addr, int port) {

		scan = new Scanner(System.in);
		// Tamanho do buffer para alocação do arquivo
		content = new byte[(int) Math.pow(2, 26)];

		try {
			socket = new Socket(addr, port);
			inputStream = socket.getInputStream();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receiveFile() {

		System.out.println("Insira o local absoluto e nome onde o arquivo será salvo");
		String path = scan.next();

		try {
			outputFile = new FileOutputStream(path);
			outputBuffer = new BufferedOutputStream(outputFile);

			outputBuffer.write(content, 0, inputStream.read(content, 0, content.length));
			outputBuffer.close();
			outputFile.close();

		} catch (IOException e) {
			System.out.println("Impossível ler o caminho indicado");
		}
	}
}
