package br.edu.AtividadeLab5;

public class Professor extends Pessoa {

	private int numeroRegistro;
	private String quantidadeHoraAula;

	public Professor(String nome, String telefone, String email, int numeroRegistro, String quantidadeHoraAula) {

		super(nome, telefone, email);

		this.numeroRegistro = numeroRegistro;
		this.quantidadeHoraAula = quantidadeHoraAula;

	}

	public String dadosFormatados() {

		String dadosFormatados = super.dadosFormatados();

		dadosFormatados = dadosFormatados + "\nRegistro" + this.getNumeroRegistro();
		dadosFormatados = dadosFormatados + "\nHora/Aula: " + this.getQuantidadeHoraAula();

		return dadosFormatados;

	}

	public String dados() {

		String dados = super.dados();

		dados += this.getNumeroRegistro();
		dados += this.getQuantidadeHoraAula();

		return "__\n" + dados;

	}

	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getQuantidadeHoraAula() {
		return quantidadeHoraAula;
	}

	public void setQuantidadeHoraAula(String quantidadeHoraAula) {
		this.quantidadeHoraAula = quantidadeHoraAula;
	}

}
