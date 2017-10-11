package br.edu.AtividadeLab2;

import java.util.Scanner;

public class Exe8_2 {
	
	//Aplicativo criado para descriptografar os valores feitos no Exe8.java
	
	public static void main(String[] args) {
		
		Scanner value = new Scanner(System.in);
		int nums, e1, e2, e3, e4, index;
		
		System.out.println("Insira o valor criptografado: ");
		nums = value.nextInt();
		
		if(Integer.toString(nums).length() > 4) {
			
			System.out.println("O programa deve receber apenas elementos de quatro digitos!");
			System.exit(1);
		
		}

		e4 = nums % 10;
		nums = nums / 10;
		
		e3 = nums % 10;
		nums = nums / 10;
		
		e2 = nums % 10 ;
		nums = nums / 10;
		
		e1 = nums % 10;
		
		//Trocando os valores para a posição original
		//Onde o primeiro troca com o terceiro e o segundo com o quarto
		index = e1;
		e1 = e3;
		e3 = index;
		index = e2;
		e2 = e4;
		e4 = index;
		
		//Descriptografando
		e1 = ((e1 + 10) - 7) % 10;
		
		e2 = ((e2 + 10) - 7) % 10;
		
		e3 = ((e3 + 10) - 7) % 10;
		
		e4 = ((e4 + 10) - 7) % 10;
		
		System.out.println(String.format("%d%d%d%d", e1 , e2, e3, e4));

		value.close();
		
	}
}
