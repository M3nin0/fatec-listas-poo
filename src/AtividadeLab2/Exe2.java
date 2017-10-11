package br.edu.AtividadeLab2;

import java.util.Scanner;

public class Exe2 {
	
	public static void main(String[] args) {

		Scanner value = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("Insira o primeiro número: ");
		num1 = value.nextInt();
		
		System.out.println("Insira o segundo número: ");
		num2 = value.nextInt();
		
		System.out.println("A soma é " + (num1 + num2));
		System.out.println("A média é " + (num1 + num2) / 2);
		
		value.close();
		
		if(num1 > num2) {
			System.out.println("1° - " + num1 + "\n" + " 2° - " + num2);
		} else {
			System.out.println("1° - " + num2 + "\n" + " 2° - " + num1);
		}
		
	}

}
