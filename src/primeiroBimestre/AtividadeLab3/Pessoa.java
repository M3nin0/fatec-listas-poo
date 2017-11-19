package br.edu.AtividadeLab3;

//Classe criada para resolver o exercício 6

public class Pessoa {
		
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private int id;
	private double gasto;
	private double[] gastoMes = new double[13];
	private double[] gastoAno = new double[13];
	
	public Pessoa(String nome, String email, String telefone, String endereco, int id, double gasto) {
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.id = id;
		this.gasto = gasto;
		
	}

	public Pessoa() {};

	public double calculaAno(int index) {
		
		int total = 0;
		
		for(int j = 1; j < index; j++) {
			
			gastoAno[j] = gastoMes[j];
			
		}
		
		for(int i = 1; i < index; i++) {
			
			total += gastoAno[i];
			
		}
		
		return total;
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getGasto() {
		return gasto;
	}
	public void setGasto(double gasto) {
		this.gasto = gasto;
	}
	public double getGastoMes(int index) {
		return gastoMes[index];
	}
	public void setGastoMes( int index) {
		
		this.gastoMes[index] += gasto;
		
		gasto = 0;
	}
	
	public int getId() {
		return id;
	}
}
