package br.edu.AtividadeLab5;

public class Aluno extends Pessoa {

	private int numeroMatricula;

	public Aluno(String nome, String telefone, String email, int numeroMatricula) {

		super(nome, telefone, email);

		this.numeroMatricula = numeroMatricula;

	}

	public String dadosFormatados() {

		String dadosFormatados = super.dadosFormatados();
		dadosFormatados = dadosFormatados + "\nMatricula " + this.getNumeroMatricula();

		return dadosFormatados;

	}

	public String dados() {

		String dados = super.dados();

		dados += this.getNumeroMatricula();

		return "__\n" + dados;

	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

}
