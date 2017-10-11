package br.edu.AtividadeLab4;

public class Professor extends Pessoa {

	private String numeroRegistro;
	private String quantidadeHoraAula;
	private int id;

	public Professor(String nome, String telefone, String email, String numeroRegistro, String quantidadeHoraAula, int id) {

		super(nome, telefone, email);

		this.numeroRegistro = numeroRegistro;
		this.quantidadeHoraAula = quantidadeHoraAula;
		this.id = id;

	}

	public String dadosFormatados() {

		String dadosFormatados = super.dadosFormatados();

		dadosFormatados += "\nRegistro: " + this.getNumeroRegistro();
		dadosFormatados += "\nHora / Aula: " + this.getQuantidadeHoraAula();

		return dadosFormatados;

	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getQuantidadeHoraAula() {
		return quantidadeHoraAula;
	}

	public void setQuantidadeHoraAula(String quantidadeHoraAula) {
		this.quantidadeHoraAula = quantidadeHoraAula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
