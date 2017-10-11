package br.edu.AtividadeLab2;

//Classe criada para ser utilizada no exerc�cio 5 (Exe5)

public class Cliente {
	
	int conta;
	double saldoInicial;
	double saldo;
	double totalItens;
	double aplicados;
	double limite;
	
	
	public double calculaSaldo() {
		
		return this.saldo = (this.saldoInicial + this.totalItens) - this.aplicados;
	}
	
	public void verificaSaldo() {
		
		calculaSaldo();
		
		if(saldo > this.limite) {
			
			System.out.printf("Você excedeu o limite em %.2f! A conta deve ser paga o quanto antes!", saldo - limite);
			
		} else {
			
			System.out.printf("Você não excedeu o limite, e ainda tem %.2f para gastar\n",(this.limite - this.saldo));
		}
		
	}
}
