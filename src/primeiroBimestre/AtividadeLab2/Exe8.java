package br.edu.AtividadeLab2;

import java.util.Scanner;

public class Exe8 {
	
	public static void main(String[] args) {
		
		Scanner value = new Scanner(System.in);
		
		int nums, e1 = 0, e2  = 0, e3 = 0, e4 = 0, index;
		
		System.out.println("Insira um valor");
		nums = value.nextInt();
		
		value.close();
		
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
		
		//Substitua cada d�gito pelo resultado da adi��o de 7 ao d�gito e obtendo o resto depois da vis�o do novo valor por 10.
		e1 = (e1 + 7) % 10; 
		e2 = (e2 + 7) % 10; 
		e3 = (e3 + 7) % 10; 
		e4 = (e4 + 7) % 10;
		
		//Troque ent�o o primeiro d�gito pelo terceiro e o segundo d�gito pelo quarto
		
		index = e1;
		e1 = e3;
		e3 = index;
		index = e2;
		e2 = e4;
		e4 = index;
		
		System.out.println(String.format("%d%d%d%d", e1,e2,e3,e4));
	}
}
