package br.edu.AtividadeLab2;

import java.util.Scanner;

public class Exe4 {
		
	public static void main(String[] args) {
		
		Scanner value = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("Insira o primeiro número: ");
		num1 = value.nextInt();
		System.out.println("Insira o segundo número: ");
		num2 = value.nextInt();
		
		value.close();
		
		if((num1 % num2) == 0) {
			System.out.printf("O número %d é multiplo de %d\n", num1, num2);
		} else {
			System.out.println("Não são multiplos");
		}
		
		
	}

}
