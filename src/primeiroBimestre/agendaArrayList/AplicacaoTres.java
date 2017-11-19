package br.edu.agendaArrayList;

/*
 * 
 * Aplicativo da lista 3
 * Agenda feita utilizando ArrayList
 * 
 */

import java.util.Scanner;

public class AplicacaoTres {
	
	public static void main(String[] args) {
		
		AgendaArrayList agenda = new AgendaArrayList();
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
