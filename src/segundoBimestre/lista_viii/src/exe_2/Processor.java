package exe_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Processor {

	private FileReader fr;
	private StringBuilder sb;
	private BufferedReader br;

	public Processor(String path) throws FileNotFoundException {
		fr = new FileReader(path);
		br = new BufferedReader(fr);
		sb = new StringBuilder();
	}

	public String lerArquivo() {
		String linha = "";

		try {
			while ((linha = br.readLine()) != null) {
				String linhas[] = linha.split(";");
				sb.append(linhas[3]);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return sb.toString();
	}

}
