package exe_2;

import java.io.FileNotFoundException;

public class Principal {
	public static void main(String[] args) {
		try {
			Processor processor = new Processor("/home/felipe/Documentos/teste.txt");
			System.out.println(processor.lerArquivo());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}
}
