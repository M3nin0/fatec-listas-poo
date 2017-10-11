package br.edu.agendaVector;

/*
 * 
 * Aplicativo da lista 3
 * Agenda feita utilizando Vector
 * 
 */

import java.util.Scanner;

public class AplicacaoDois {

	public static void main(String[] args) {
		
		AgendaVetor agenda = new AgendaVetor();
		Scanner scanner = new Scanner(System.in);
		String choose = null;
		
		agenda.imprimirOpcoes();
		choose = scanner.next();
		
		while(true) {
			switch(choose) {
			case "1":
				agenda.imprimirPessoas();
				agenda.imprimirOpcoes();
				choose = scanner.next();
				break;
			case "2":
				agenda.cadastrarPessoa();
				agenda.imprimirOpcoes();
				choose = scanner.next();
				break;
			case "3":
				System.exit(0);
				
			default:
				System.out.println("Op��o invalida! Escolha novamante");
				agenda.imprimirOpcoes();
				break;
			}
			
		}
	}
}
