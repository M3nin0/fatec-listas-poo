package br.edu.AtividadeLab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

	private List<Aluno> alunos = new ArrayList<>();
	private List<Professor> professores = new ArrayList<>();

	Scanner scanner = new Scanner(System.in);

	private int indexA = 0;
	private int indexP = 0;
	private int indx;
	
	public void cadastrar() {

		System.out.println("Deseja cadastrar aluno ou professor ?");
		String resp = scanner.next();

		System.out.println("Insira o nome: ");
		String nome = scanner.next();
		System.out.println("Insira o telefone: ");
		String telefone = scanner.next();
		System.out.println("Insira o email: ");
		String email = scanner.next();

		if (resp.toLowerCase().equals("aluno")) {

			System.out.println("Insira o n�mero da matricula");
			String matricula = scanner.next();

			alunos.add(new Aluno(nome, telefone, email, matricula, indexA));

			indexA++;

		} else if (resp.toLowerCase().equals("professor")) {

			System.out.println("Insira o n�mero de registro: ");
			String register = scanner.next();
			System.out.println("Insira a quantidade de horas/aula: ");
			String horas = scanner.next();

			professores.add(new Professor(nome, telefone, email, register, horas, indexP));

			indexP++;
		}

	}
	
	public void editar() {

		System.out.println("Edi��o de contatos");

		System.out.println("Deseja editar professor ou aluno ?");
		String resp = scanner.next();
		
		if(resp.toLowerCase().equals("aluno")) {
			System.out.println("Escolha o ID aluno a ser editado: ");
			
			for(Aluno aluno:alunos) {
				
				System.out.println("ID - " + aluno.getId() + " Nome: " + aluno.getNome());
				
			}
			indx = scanner.nextInt();
			
		} else if(resp.toLowerCase().equals("professor")) {
			
			System.out.println("Escolha o ID do professor a ser editado: ");
			
			for(Professor professor: professores) {
				
				System.out.println("ID - " + professor.getId() + " Nome: " + professor.getNome());
				
			}
			indx = scanner.nextInt();
			
			
		}
		
		System.out.println("Insira as novas informa��es: ");
		System.out.println("Nome: ");
		String nome = scanner.next();
		System.out.println("Telefone: ");
		String telefone = scanner.next();
		System.out.println("Email: ");
		String email = scanner.next();

		if (resp.toLowerCase().equals("aluno")) {

			System.out.println("Insira seu n�mero de m�tricula: ");
			String matricula = scanner.next();
			
			Aluno alunoEditado = alunos.get(indx);
			
			alunoEditado.setNome(nome);
			alunoEditado.setTelefone(telefone);
			alunoEditado.setEmail(email);
			alunoEditado.setNumeroMatricula(matricula);
			
			
		} else if (resp.toLowerCase().equals("professor")) {

			System.out.println("Insira seu n�mero de registro: ");
			String reg = scanner.next();
			System.out.println("Insira a quantidade de horas aula: ");
			String horas = scanner.next();
			
			Professor profEditado = professores.get(indx);
			
			profEditado.setNome(nome);
			profEditado.setTelefone(telefone);
			profEditado.setEmail(email);
			profEditado.setNumeroRegistro(reg);
			profEditado.setQuantidadeHoraAula(horas);
			
		}
		System.out.println("Altera��es feitas com sucesso!");
	}
	
	public void excluir() {
		
		System.out.println("Exclus�o de usu�rio");
		
		System.out.println("Excluir aluno ou professor ?");
		String ap = scanner.next();
		
		if(ap.toLowerCase().equals("aluno")) {
			
			System.out.println("Escolha o ID aluno a ser excluido: ");
			for(Aluno aluno:alunos) {
				
				System.out.println("ID - " + aluno.getId() + " Nome: " + aluno.getNome());
				
			}
			indx = scanner.nextInt();
			
			alunos.remove(alunos.get(indx));
			
			System.out.println("Aluno removido com sucesso");
			
		} else if(ap.toLowerCase().equals("professor")) {
			
			System.out.println("Escolha o ID do professor a ser editado: ");
			
			for(Professor professor: professores) {
				
				System.out.println("ID - " + professor.getId() + " Nome: " + professor.getNome());
				
			}
			indx = scanner.nextInt();
			
			professores.remove(professores.get(indx));
			
			System.out.println("Professor removido com sucesso!");
			
		}
				
	}

	public void listarTodos() {

		System.out.println("Lista de contatos de alunos: ");
		for (Aluno aluno : alunos) {

			System.out.println(aluno.dadosFormatados());

		}
		System.out.println("Lista de contatos de professores");
		for (Professor professor : professores) {

			System.out.println(professor.dadosFormatados());

		}

	}
}
