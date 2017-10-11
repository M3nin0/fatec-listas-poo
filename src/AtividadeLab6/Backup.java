package br.edu.AtividadeLab6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Backup {

	private List<Produto> cadastrados = new Vector<>();

	protected void salvaDados() throws FileNotFoundException, IOException {
		cadastrados = GerenciadorEstoque.getProdutos();

		if (cadastrados == null) {
			JOptionPane.showMessageDialog(null, "Não há nada para salvar");
			return;
		}

		try {

			FileOutputStream file = new FileOutputStream("./estoque.data");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(cadastrados);

			out.close();
			file.close();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

		} catch (Exception e) {
		}

	}

	@SuppressWarnings("unchecked")
	protected void recuperaDados()
			throws ClassNotFoundException, IOException, FileNotFoundException, ObjectStreamException {

		cadastrados = GerenciadorEstoque.getProdutos();

		if (cadastrados != null) {
			JOptionPane.showMessageDialog(null, "Seus dados serão substituidos pelos presentes no arquivo");
			cadastrados.clear();
			GerenciadorEstoque.setProdutos(cadastrados);
		}

		try {
			FileInputStream input = new FileInputStream("./estoque.data");
			ObjectInputStream oInput = new ObjectInputStream(input);

			cadastrados = (List<Produto>) oInput.readObject();

			GerenciadorEstoque.setProdutos(cadastrados);

			oInput.close();
			input.close();

			JOptionPane.showMessageDialog(null, "Recuperação feita com sucesso!");

		} catch (Exception e) {
		}

	}

}
