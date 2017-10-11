package br.edu.AtividadeLab2;

public class Exe5 {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		
		cliente.conta = 124335;
		cliente.limite = 560.60;
		cliente.saldoInicial = 0;
		cliente.totalItens = 480;
		
		cliente.verificaSaldo();
		
		cliente.totalItens += 120.25;
		
		cliente.verificaSaldo();
		
		
	}

}
