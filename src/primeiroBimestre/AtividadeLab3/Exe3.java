package br.edu.AtividadeLab3;

import java.util.Scanner;

/*
 * Um estacionamento cobra uma taxa mínima de R$2,00 para estacionar por até três
	horas. Um adicional de R$0,50 por hora não necessariamente inteira é cobrado após
	as três primeiras horas. Escreva um aplicativo que calcule e exiba as taxas de
	estacionamento para um cliente que estacionou. O aplicativo deve receber o intervalo
	de tempo que o veículo ficou estacionado e exibir a cobrança para o cliente.
 * 
 */

public class Exe3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double taxa = 2.00;
		double horas;
		double cobranca = 0;
		
		System.out.println("Insira quantos minutos você ficou estacionado: ");
		horas = scanner.nextDouble();
		
		horas = horas / 60;
		
		if(horas > 3.0) {
			
			cobranca = Math.ceil(horas - 3) * 0.50;			
			cobranca += taxa;
			
		} else if (horas <= 3.0) {
			
			cobranca += taxa;
			
		}
		
		System.out.println("O tempo que você ficou estacionado irá custar: R$" + String.format("%.2f", cobranca));
		
		scanner.close();
		
	}

}
