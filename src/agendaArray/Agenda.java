package br.edu.agendaArray;

import java.util.Scanner;

public class Agenda {

	//Array
	private Pessoa[] pessoas;
	private Scanner scanner;
	private String choose;
	private int index = 0;
	
	public Agenda() {
		pessoas = new Pessoa[5];
		scanner = new Scanner(System.in);
	}
	
	public void cadastrarPessoa() {
		
		while(true) {
			
			System.out.println("Insira o nome do contato: ");
			String nome = scanner.next();
			System.out.println("Insira o telefone: ");
			String telefone = scanner.next();
			System.out.println("Insira o email: ");
			String email = scanner.next();
			
			Pessoa temp = new Pessoa(nome, telefone, email);
			
			pessoas[index] = temp;
			index++;
			
			System.out.println("Você deseja cadastrar outro usuário ?");
			choose = scanner.next();
			
			if(choose.toLowerCase().equals("sim")) {
				continue;
			} else {
				break;
			}
		}
		
	}
	public void imprimirOpcoes() {
		System.out.println( "Escolha uma opção: \n" +
																			"1 - Listar contatos\n" +
																			"2 - Incluir contatos\n" +
																			"3 - Sair");	
	}
	public void imprimirPessoas() {
		
		for(Pessoa pessoa : pessoas) {
			if(pessoa != null) {
			System.out.println("\n Nome:" + pessoa.getNome() + 
																					"\n Telefone: " + pessoa.getTelefone() +
																					"\n Email: " + pessoa.getEmail() + "\n");
		}
	}
}
	public Pessoa[] getPessoas() {
		return pessoas;
	}
	public void setPessoas(Pessoa[] pessoas) {
		this.pessoas = pessoas;
	}
}
