package exe_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

public class Storage {

	// Serializa
	private FileOutputStream foo;
	private ObjectOutputStream oos;

	// Deserializa
	private FileInputStream fis;
	private ObjectInputStream ois;

	private Date date;
	private Scanner scanner;
	private String path;

	public Storage() {
		scanner = new Scanner(System.in);
		date = new Date();
		path = "";
	}

	public void save(Contato[] contatos) {
		System.out.println("Insira o caminho onde o arquivo será salvo");
		path = scanner.next();

		try {

			foo = new FileOutputStream(path + "_agenda_bkp_" + date.getTime());
			oos = new ObjectOutputStream(foo);
			oos.writeObject(contatos);
			oos.close();
			foo.close();

			System.out.println("Dados salvos com sucesso");
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public Contato[] load() {
		Contato[] contatos = null;

		System.out.println("Insira o caminho absoluto do arquivo que será restaurado");
		path = scanner.next();

		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
			contatos = (Contato[]) ois.readObject();

			fis.close();
			ois.close();
			
			System.out.println("Arquivos carregados com sucesso!");
	
			return contatos;

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro ao carregar o arquivo");
		}

		return contatos;
	}
}
