package br.edu.AtividadeLab6;

import java.io.Serializable;

public class Produto implements Comparable<Produto>, Serializable{

	private String tipoProduto;
	private String quantidade;

	public Produto() {
	};

	public Produto(String tipoProduto, String quantidade) {
		this.tipoProduto = tipoProduto;
		this.quantidade = quantidade;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public boolean equals(Object obj) {
		
		Produto temp = (Produto) obj;
		
		if(this.tipoProduto.equals(temp.tipoProduto)) {
			return true;
		} else {
			return false;
		}
		
	}
	@Override
	public int compareTo(Produto o) {
		return tipoProduto.compareTo(o.getTipoProduto());
	}
	
}