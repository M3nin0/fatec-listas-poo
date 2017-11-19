package br.edu.AtividadeLab4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		Scanner scan = new Scanner(System.in);
		
		int sair = 1;
		int escolha = 0;
		
		do {
			System.out.println("Escolha o que você deseja fazer: ");
			System.out.println("1 - Cadastrar usuários");
			System.out.println("2 - Listar todos os usuários cadastrados");
			System.out.println("3 - Editar usuário");
			System.out.println("4 - Remover usuário");
			System.out.println("5 - Sair");
			
			escolha = scan.nextInt();
			
			switch(escolha) {
			
				case 1:
					agenda.cadastrar();
					
					break;
				case 2:
					agenda.listarTodos();
					
					break;
					
				case 3:
					agenda.editar();
					
					break;
					
				case 4:
					agenda.excluir();
					
					break;
					
				case 5:
					System.exit(0);
					
					break;
					
				default:
					System.out.println("Escolha invalida!!!");
					
					break;
			}
			
		}while(sair != 0);
		
		scan.close();
		
	}

}
