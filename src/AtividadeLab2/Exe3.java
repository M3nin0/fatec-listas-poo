package br.edu.AtividadeLab2;

import java.util.Scanner;

public class Exe3 {

	public static void main(String[] args) {

		int num = 0;
		int maior = 0;
		int menor = 0;

		Scanner value = new Scanner(System.in);
		
		System.out.println("Insira um número: ");
		num = value.nextInt();
	
		maior = num;
		menor = num;
		
		for (int i = 0; i < 4; i++) {
		
			System.out.println("Insira um número: ");
			num = value.nextInt();		

			if (num > maior) {
				maior = num;
			} else if (num < menor) {
				menor = num;
			}
			

		}
		value.close();

		System.out.println("O maior número é " + maior + " e o menor é o " + menor);
	}
}
