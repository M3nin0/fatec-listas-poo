package br.edu.AtividadeLab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

	Scanner scan = new Scanner(System.in);

	private List<Aluno> alunos = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();

	int indexP = 0;
	int indexA = 0;

	private int listaAlunos() {

		for (Aluno aluno : alunos) {

			System.out.println("Nome: " + aluno.getNome().toLowerCase() + " Matricula: " + aluno.getNumeroMatricula());

		}
		int choose = scan.nextInt();

		return choose;
	}

	private int listaProfessores() {

		for (Professor professor : professores) {

			System.out.println("Nome: " + professor.getNome() + " Matricula: " + professor.getNumeroRegistro());

		}
		int choose = scan.nextInt();

		return choose;

	}

	public void listarTodos() {

		System.out.println("Lista de todos os contatos de alunos: ");

		for (Aluno aluno : alunos) {

			if (aluno.getNome() == null)
				continue;

			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("N° Matricula: " + aluno.getNumeroMatricula());

		}

		System.out.println("Lista de contatos de professores: ");

		for (Professor professor : professores) {

			if (professor.getNome() == null)
				continue;

			System.out.println("Nome: " + professor.getNome());
			System.out.println("Telefone: " + professor.getTelefone());
			System.out.println("Email: " + professor.getTelefone());
			System.out.println("Registro: " + professor.getNumeroRegistro());
			System.out.println("Quantidade hora/aula: " + professor.getQuantidadeHoraAula());

		}

	}

	// Cadastra aluno
	public void cadastraUsuario() {

		System.out.println("Deseja cadatrar professor ou aluno ?");
		String escolha = scan.next();

		if (escolha.equals("aluno")) {

			System.out.println("Cadastro de aluno: ");

			System.out.println("Insira o nome do aluno: ");
			String nome = scan.next();
			System.out.println("Insira o telefone do aluno: ");
			String telefone = scan.next();
			System.out.println("Insira o email do aluno: ");
			String email = scan.next();

			alunos.add(indexA, new Aluno(nome, telefone, email, indexA));

			indexA++;

		} else if (escolha.equals("professor")) {

			System.out.println("Cadastro de professores: ");

			System.out.println("Insira o nome do professor: ");
			String nome = scan.next();
			System.out.println("Insira o telefone do professor: ");
			String telefone = scan.next();
			System.out.println("Insira o email: ");
			String email = scan.next();
			System.out.println("Insira a quantidade de horas aula: ");
			String horaData = scan.next();

			professores.add(indexP, new Professor(nome, telefone, email, indexP, horaData));

			indexP++;
		}
	}

	// Edita aluno
	public void editaUsuario() {

		System.out.println("Deseja editar professor ou aluno ?");
		String escolha = scan.next();

		if (escolha.equals("aluno")) {

			int index = listaAlunos();

			System.out.println("Aluno sendo editado: " + alunos.get(index).getNome());
			System.out.println("Insira o novo nome do aluno: ");
			String nome = scan.next();
			System.out.println("Insira o novo telefone do aluno: ");
			String telefone = scan.next();
			System.out.println("Insira o novo email do aluno: ");
			String email = scan.next();

			alunos.remove(alunos.get(index));
			alunos.add(index, new Aluno(nome, telefone, email, index));

		} else if (escolha.equals("professor")) {

			int index = listaProfessores();

			System.out.println("Professor a ser editado: " + professores.get(index).getNome());

			System.out.println("Insira o novo nome do professor: ");
			String nome = scan.next();
			System.out.println("Insira o novo telefone do " + professores.get(index).getNome() + ": ");
			String telefone = scan.next();
			System.out.println("Insira o novo email do " + professores.get(index).getNome() + ": ");
			String email = scan.next();
			System.out.println("Insira a quantidade de horas aula: ");
			String horaData = scan.next();

			professores.remove(professores.get(index));
			professores.add(index, new Professor(nome, telefone, email, index, horaData));

		} else {
			System.out.println("Opção invalida!");
		}

	}

	// Exclui aluno
	public void exclui() {

		System.out.println("Você deseja excluir alunos ou professores");
		String escolha = scan.next();

		if (escolha.equals("aluno")) {

			System.out.println("Exclusão de aluno\n" + "Escolha o aluno a ser excluido");

			int index = listaAlunos();

			alunos.remove(alunos.get(index));

		} else if (escolha.equals("professor")) {

			System.out.println("Exclusão de professores\n" + "Escolha o professor a ser excluido");

			int index = listaProfessores();

			professores.remove(professores.get(index));

		}

	}

	public void salvar() {

		int tipo = 0;

		File dir = new File("./Dados");

		dir.mkdir();

		if (dir.isDirectory())
			dir.mkdir();

		System.out.println("Deseja salvar os alunos ou os professores\n");
		System.out.println("1 - Alunos\n2 - Professores");
		tipo = scan.nextInt();

		try {

			if (tipo == 1) {

				File file = new File("./Dados/alunos.txt");
				FileWriter fw = new FileWriter(file);
				BufferedWriter escrever = new BufferedWriter(fw);

				for (Aluno aluno : alunos) {

					escrever.write(aluno.dados());

				}

				escrever.close();
				fw.close();

			} else if (tipo == 2) {

				File file = new File("./Dados/professores.txt");
				FileWriter fw = new FileWriter(file);
				BufferedWriter escrever = new BufferedWriter(fw);

				for (Professor professor : professores) {

					escrever.write(professor.dados());
				}

				escrever.close();
				fw.close();
			}

		} catch (IOException ex) {

			System.out.println("Erro ao ler o arquivo!!!");

		}

	}

	public void lerArquivo() {

		System.out.println("Deseja importar alunos ou professores ?");
		System.out.println("1 - Alunos\n 2 - Professores");
		int tipo = scan.nextInt();

		String nome;
		String telefone;
		String email;
		int numeroRegistro;
		String quantidadeHoraAula;

		try {

			if (tipo == 1) {

				File file = new File("./Dados/alunos.txt");
				FileReader reader = new FileReader(file);
				BufferedReader br = new BufferedReader(reader);

				while ((br.readLine()) != null) {

					nome = br.readLine();
					telefone = br.readLine();
					email = br.readLine();

					alunos.add(new Aluno(nome, telefone, email, indexA));

					indexA++;

				}
				br.close();

			} else if (tipo == 2) {

				File file = new File("./Dados/professores.txt");
				FileReader reader = new FileReader(file);
				BufferedReader br = new BufferedReader(reader);

				while ((br.readLine()) != null) {

					nome = br.readLine();
					telefone = br.readLine();
					email = br.readLine();
					numeroRegistro = Integer.parseInt(br.readLine());
					quantidadeHoraAula = br.readLine();

					professores.add(new Professor(nome, telefone, email, indexP, quantidadeHoraAula));

					indexP++;

				}
				br.close();

			}

		} catch (IOException ex) {

			System.out.println("Erro ao importar os dados");

		}

	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
