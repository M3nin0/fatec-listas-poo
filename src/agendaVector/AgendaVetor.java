package br.edu.agendaVector;

import java.util.Scanner;
import java.util.Vector;

import br.edu.agendaArray.Pessoa;

public class AgendaVetor {
	

		private Vector<Pessoa> pessoas;
		private Scanner scanner;
		private String choose;
		
		public AgendaVetor() {
			pessoas = new Vector<Pessoa>();
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
				
				pessoas.add(temp);
				
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
		public Vector<Pessoa> getPessoas() {
			return pessoas;
		}
		public void setPessoas(Vector<Pessoa> pessoas) {
			this.pessoas = pessoas;
		}
	

}
