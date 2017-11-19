package br.edu.AtividadeLab2;

//Classe criada para resolver o exercício 6 (Exe 6)

public class Vendedor {
	
	String nome;
	int id;
	double salario = 0;
	double rendimento = 0;
	double vendas = 0;
	
	public Vendedor(String nome, int id) {
		
		this.nome = nome;
		this.id = id;
	}
	
	public void venderItem(double item) {
		
		this.vendas += item;
		
	}
	
	public double calculaRendimento() {
		
		return this.rendimento = this.vendas * 0.09;
		
	}
	
	public String calculaSalario() {
		
		calculaRendimento();
		
		salario += rendimento;
		
		return String.format("%.2f", salario + (4 * 200));
	}
}
