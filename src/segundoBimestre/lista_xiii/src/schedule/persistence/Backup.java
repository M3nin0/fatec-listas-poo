package schedule.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import schedule.contact.Contato;
import schedule.events.Evento;
import schedule.schedule.Agenda;

public class Backup {

	// Usando o JFileChooser para selecionar o arquivo
	private static JFileChooser filer = new JFileChooser();
	private static Date date = new Date();

	/*
	 * Método para adequar a barra de diretórios ao sistema operacional utilizado
	 */
	private static String sysVer() {
		String separator = "";
		if (System.getProperty("os.name").contains("Windows"))
			separator = "\\";
		else if (System.getProperty("os.name").contains("Linux"))
			separator = "/";

		return separator;
	}

	private static String selDir(String type) {
		/*
		 * A definição de fileSelection define que serão listados apenas diretórios,
		 * assim mesmo utilizando o selectedFile, será utilizado apenas o caminho do
		 * diretório
		 */

		filer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		filer.showOpenDialog(null);

		return filer.getSelectedFile().getAbsolutePath() + sysVer() + type + "_" + date.getTime() + ".t";
	}

	public static void salvaContatos(Agenda<Contato> contatos) {
		try {
			FileOutputStream fos = new FileOutputStream(selDir("contatos"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(contatos);
			oos.close();

			JOptionPane.showMessageDialog(null, "Os contatos foram salvos com sucesso");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os contatos");
		}
	}

	public static void salvaEventos(Agenda<Evento> eventos) {
		try {
			FileOutputStream fos = new FileOutputStream(selDir("eventos"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(eventos);
			oos.close();

			JOptionPane.showMessageDialog(null, "Os eventos foram salvos com sucesso");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os eventos");
		}
	}

	@SuppressWarnings("unchecked")
	public static Agenda<Contato> recoverContatos() {

		filer.showOpenDialog(null);

		try {
			FileInputStream fis = new FileInputStream(filer.getSelectedFile().getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object temp = ois.readObject();

			ois.close();

			JOptionPane.showMessageDialog(null, "Os contatos foram recuperados com sucesso");
			return (Agenda<Contato>) temp;

		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar ler o arquivo");
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static Agenda<Evento> recoverEventos() {
		filer.showOpenDialog(null);

		try {
			FileInputStream fis = new FileInputStream(filer.getSelectedFile().getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(fis);

			/*
			 * Apenas para fechar o fluxo de dados
			 */
			Object temp = ois.readObject();
			ois.close();

			JOptionPane.showMessageDialog(null, "Os eventos foram recuperados com sucesso");
			return (Agenda<Evento>) temp;

		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar ler o arquivo");
		}
		return null;
	}
}
