package br.edu.AtividadeLab4;

public class Aluno extends Pessoa{

	private String numeroMatricula;
	private int id;
	
	public Aluno(String nome, String telefone, String email, String numeroMatricula, int id) {
		
		super(nome, telefone, email);
		
		this.numeroMatricula = numeroMatricula;
		this.id = id;
		
	}
	
	public String dadosFormatados() {
		
		String dadosFormatados = super.dadosFormatados();
		
		dadosFormatados += dadosFormatados + "\nMatricula: " + this.getNumeroMatricula();
		
		return dadosFormatados;
		
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
