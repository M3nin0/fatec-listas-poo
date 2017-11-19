package br.edu.AtividadeLab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Uma empresa que faz neg�cios por reembolso postal vende cinco produtos cujos
	pre�os de varejo s�o como segue: P1 R$1,00 � P2 R$2,98 � P3 R$9,98 � P4 R$4,49
	e P5 R$6,87. Escreva um aplicativo que leia uma s�rie de pares de n�meros como
	segue: c�digo do produto, quantidade vendida. Seu programa deve determinar o
	valor total de produtos vendidos, discriminando a porcentagem vendida em dinheiro
	de cada produto.
 */

public class Exe2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Input p1 55
		String codigo;
		Double value, total = 0.00;
		List<Produto> produtos = new ArrayList<>();

		String codecs[] = { "NONE", "P1", "P2", "P3", "P4", "P5" };
		Double values[] = { 99.99, 1.00, 2.98, 9.98, 4.49, 6.87 };

		for (int i = 1; i < codecs.length; i++) {
			produtos.add(new Produto(codecs[i], values[i]));

		}
		while (true) {
			codigo = scan.next();
			value = scan.nextDouble();

			for (Produto produto : produtos) {
				if (produto.getCodigo().equals(codigo)) {
					total += produto.getValue() * value;
				}
			}

			System.out.println("Deseja comprar mais produtos ?\nS - Sim\nN - Não");
			String option = scan.next();

			if (option.equals("S")) {
				continue;
			} else {
				break;
			}

		}
		
		System.out.println("O gasto total foi de: " + total);
		scan.close();

	}
}
