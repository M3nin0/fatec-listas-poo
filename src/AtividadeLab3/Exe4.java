package br.edu.AtividadeLab3;

/*Escreva um m�todo m�ltiplo() que determina um par de inteiros se o se segundo �
m�ltiplo do primeiro. O m�todo deve retorna o valor boleano true se o segundo
n�mero for m�ltiplo do primeiro
 */

public class Exe4 {
	
	public boolean multiplo(int v1, int v2) {
		
		if((v2 % v1) == 0) {
			
			return true;
		
		} else {
			
			return false;
			
		}
		
	}
	
	public static void main(String[] args) {
	
		Exe4 mult = new Exe4();
		
		System.out.println(mult.multiplo(14, 28));
		
	}

}
