package br.edu.AtividadeLab3;

public class Produto {
	
	// Utilizado para resolver o exercício 2

	private String codigo;
	private Double value;

	public Produto(String codigo, Double value) {

		this.codigo = codigo;
		this.value = value;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
