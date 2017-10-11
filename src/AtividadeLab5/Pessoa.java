package br.edu.AtividadeLab5;

public abstract class Pessoa implements Contato{

	private  String nome;
	private String telefone;
	private String email;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String telefone, String email) {
		
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		
	}
	
	
	public String dadosFormatados() {
		
		String dadosFormatados;
		
		dadosFormatados = "\nNome: " + this.getNome();
		dadosFormatados = "\nTelefone: " + this.getTelefone();
		dadosFormatados = "\nEmail: " + this.getEmail();
		
		return dadosFormatados;
		
	}
	
	public String dados() {
		
		String dados = "";
		
		dados += this.getNome() + "\n";
		dados += this.getTelefone() + "\n";
		dados += this.getEmail() + "\n";
		
		return dados;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
