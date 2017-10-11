package br.edu.agendaArray;

/*
 * Aplicativo da lista 3
 * Agenda feita utilizando Array
 * 
 */

import java.util.Scanner;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		Scanner scanner = new Scanner(System.in);
		
		int sair = 0, opcao = 0;
		
		while(sair == 0) {
			switch(opcao) {
			case 0:
				agenda.imprimirOpcoes();
				opcao = scanner.nextInt();
				break;
			case 1:
				agenda.imprimirPessoas();
				opcao = 0;
				break;
			case 2:
				agenda.cadastrarPessoa();
				opcao = 0;
				break;
			case 3:
				sair = 1;
				break;
			default:
				System.out.println("Op��o invalida. Escolha novamente");
				opcao = 0;
				break;
			}
		}
		scanner.close();
	}

}
