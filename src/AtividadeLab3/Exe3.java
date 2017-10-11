package br.edu.AtividadeLab3;

import java.util.Scanner;

/*
 * Um estacionamento cobra uma taxa m�nima de R$2,00 para estacionar por at� tr�s
	horas. Um adicional de R$0,50 por hora n�o necessariamente inteira � cobrado ap�s
	as tr�s primeiras horas. Escreva um aplicativo que calcule e exiba as taxas de
	estacionamento para um cliente que estacionou. O aplicativo deve receber o intervalo
	de tempo que o ve�culo ficou estacionado e exibir a cobran�a para o cliente.
 * 
 */

public class Exe3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double taxa = 2.00;
		double horas;
		double cobranca = 0;
		
		System.out.println("Insira quantos minutos voc� ficou estacionado: ");
		horas = scanner.nextDouble();
		
		horas = horas / 60;
		
		if(horas > 3.0) {
			
			cobranca = Math.ceil(horas - 3) * 0.50;			
			cobranca += taxa;
			
		} else if (horas <= 3.0) {
			
			cobranca += taxa;
			
		}
		
		System.out.println("O tempo que voc� ficou estacionado ir� custar: R$" + String.format("%.2f", cobranca));
		
		scanner.close();
		
	}

}
