package br.edu.AtividadeLab2;

import java.util.Scanner;

public class Exe1 {
	
	public static void main(String[] args) {
		
		Scanner value = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("Insira o primeiro valor: ");
		num1 = value.nextInt();
		System.out.println("Insira o segundo valor: ");
		num2 = value.nextInt();

		value.close();
		
		//Soma
		System.out.println("A soma dos valores é " + (num1 + num2));
		
		//Subtração
		System.out.println("A subtração dos valores é " + (num1 - num2));
		
		//Divisão
		System.out.println("A divisão dos valores é " + (num1 / num2));
		
		//Multiplicação
		System.out.println("O produto dos valores é " + (num1 * num2));
		
	}
}