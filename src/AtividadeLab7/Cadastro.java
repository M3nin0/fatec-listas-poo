package br.edu.AtividadeLab7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Cadastro {

	protected static List<Usuario> usuarios = new ArrayList<>();

	public static void cadastraUsuario() {

		String nome = JOptionPane.showInputDialog("Insira seu nome completo");
		String nickname = JOptionPane.showInputDialog("Insira seu nome de usuario");
		String senha = JOptionPane.showInputDialog("Insira sua senha");

		if (usuarios.size() != 0) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNickname().equals(nickname)) {
					JOptionPane.showMessageDialog(null, "Este nome de usuário já está cadastrado!");
					return;
				}
			}
		}
		usuarios.add(new Usuario(nome, nickname, senha));

		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

	}

	// Verifica quem está cadastrado (Login)
	public static boolean getCadastrados(String nickname, String senha) {
		// Definindo o root
		usuarios.add(new Usuario("root", "root", "toor"));

		Usuario userLogin = new Usuario(nickname, senha);

		for (Usuario usuario : usuarios) {
			if (userLogin.equals(usuario)) {
				JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Falha ao fazer o login");
		return false;

	}

	public void salvaUsuarios() {

		try {

			FileOutputStream out0 = new FileOutputStream("./usuarios.bin");
			ObjectOutputStream out1 = new ObjectOutputStream(out0);

			out1.writeObject(usuarios);

			out1.close();
			out0.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	// Para suprimir os erros
	@SuppressWarnings("unchecked")
	public void recuperaUsuarios() {

		try {
			FileInputStream in0 = new FileInputStream("./usuarios.bin");

			ObjectInputStream in1 = new ObjectInputStream(in0);

			// Cast para o tipo da variavel que irá receber o objeto
			usuarios = (List<Usuario>) in1.readObject();

			in1.close();
			in0.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
