package exe_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class Save<T> {
	// Serializa
	private FileOutputStream fileOutput;
	private ObjectOutputStream outputStream;

	// Deserializa
	private FileInputStream fileInput;
	private ObjectInputStream inputStream;

	private Date date;
	private Scanner scan;
	private String path;

	public Save() {
		scan = new Scanner(System.in);
		date = new Date();
		path = "";
	}

	public void dumpItens(Set<T> objetos) {
		System.out.println("Insira o caminho onde o backup será salvo");
		path = scan.next();
		try {
			fileOutput = new FileOutputStream(path + "/backup_agenda_" + date.getTime());
			outputStream = new ObjectOutputStream(fileOutput);
			outputStream.writeObject(objetos);
			outputStream.close();
			fileOutput.close();

			System.out.println("Os dados foram salvos com sucesso!");

		} catch (Exception e) {
			e.getStackTrace();	
		}
	}

	@SuppressWarnings("unchecked")
	public Set<T> reload() {
		Set<T> objetos = null;

		System.out.println("Insira o caminho absoluto do arquivo a ser recuperado");
		path = scan.next();

		try {
			fileInput = new FileInputStream(path);
			inputStream = new ObjectInputStream(fileInput);
			objetos = (Set<T>) inputStream.readObject();
			inputStream.close();
			fileInput.close();

			return objetos;

		} catch (Exception e) {
			System.out.println("Não foi possível recuperar os dados");
		}
		return objetos;
	}
}
