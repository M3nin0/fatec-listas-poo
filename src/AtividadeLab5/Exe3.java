package br.edu.AtividadeLab5;

import java.util.Scanner;

/*
 * Escreva um aplicativo que leia três valores, diferentes de zero, inseridos pelo usuário e
 * determine e imprima se eles poderiam representar os lados de um triangulo retângulo
 */

public class Exe3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Insira o valor do lado A: ");
		int a = scan.nextInt();
		System.out.println("Insira o valor do lado B: ");
		int b = scan.nextInt();
		System.out.println("Insira o valor do lado C: ");
		int c = scan.nextInt();
		
		Triangulo triangulo = new Triangulo(a,b,c);
		
		triangulo.verificaTriangulo();
	
		scan.close();
	}
}