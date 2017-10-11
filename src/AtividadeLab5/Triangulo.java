package br.edu.AtividadeLab5;

public class Triangulo {
	
	//Classe criada para a solução do exercício 3

	private double ladoUm;
	private double ladoDois;
	private double ladoTres;

	public Triangulo(double ladoUm, double ladoDois, double ladoTres) {

		this.ladoUm = ladoUm;
		this.ladoDois = ladoDois;
		this.ladoTres = ladoTres;

	}

	public void verificaTriangulo() {

		double hip;

		// a^2 = b^2 + c^2
		if (ladoUm > ladoDois) {
			if (ladoUm > ladoTres) {

				hip = ladoUm;
				ladoDois = Math.pow(ladoDois, 2);
				ladoTres = Math.pow(ladoTres, 2);

				if (hip == (Math.sqrt(ladoDois + ladoTres))) {
					System.out.println("Este triangulo é retângulo");
					System.exit(0);
				}
					
			} else {
				hip = ladoTres;

				ladoUm = Math.pow(ladoUm, 2);
				ladoDois = Math.pow(ladoDois, 2);

				if (hip == (Math.sqrt(ladoUm + ladoDois))) {
					System.out.println("Este triangulo é retângulo");
					System.exit(0);
				}
					
			}
		} else if (ladoDois > ladoUm) {
			if (ladoDois > ladoTres) {

				hip = ladoDois;
				ladoUm = Math.pow(ladoUm, 2);
				ladoTres = Math.pow(ladoTres, 2);

				if (hip == (Math.sqrt(ladoUm + ladoTres))) {
					System.out.println("Este triangulo é retângulo");
					System.exit(0);
				}
					
			} else {
				hip = ladoTres;

				ladoUm = Math.pow(ladoUm, 2);
				ladoDois = Math.pow(ladoDois, 2);

				if (hip == (Math.sqrt(ladoUm + ladoDois))) {
					System.out.println("Este triangulo é retângulo");
					System.exit(0);
				}
					
			}
		} else if (ladoTres > ladoUm) {
			if (ladoTres > ladoDois) {

				hip = ladoTres;
				ladoUm = Math.pow(ladoUm, 2);
				ladoDois = Math.pow(ladoDois, 2);

				if (hip == (Math.sqrt(ladoUm + ladoDois))) {
					System.out.println("Este triangulo é retângulo");
					System.exit(0);
				}
					
			} else {
				
				hip = ladoDois;

				ladoUm = Math.pow(ladoUm, 2);
				ladoTres = Math.pow(ladoTres, 2);

				if (hip == (Math.sqrt(ladoUm + ladoTres))) {
					System.out.println("Este triangulo é retângulo");
					System.exit(0);
				}
			}
		}
		System.out.println("Esses lados não formam um triângulo retângulo");
		System.exit(1);
	}
}
