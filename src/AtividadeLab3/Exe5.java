package br.edu.AtividadeLab3;

public class Exe5 {

	public static void main(String[] args) {

		int numeros[] = new int[999];
		int acc = 0;

		// Populando Array
		for (int i = 0; i < numeros.length - 1; i++) {

			numeros[i] = i + 2;
		}

		// Comparando e verificando primos
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = 0; j < numeros.length - 1; j++) {

				if ((numeros[i] % numeros[j]) == 0) {
					acc++;
				}
			}
			if (acc < 2) {
				System.out.println(numeros[i]);

			}
			acc = 0;

		}

	}

}
