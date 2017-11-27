package schedule.contact;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contato implements Serializable {
	private String nome;
	private String email;
	private String endereco;
	private Integer telefone;

	public Contato(String nome, String email, Integer telefone, String endereco) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
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

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public boolean equals(Object e) {
		// Verifica se o objeto recebido é uma instância de contato
		if (!(e instanceof Contato))
			return false;
		
		Contato contato = (Contato) e;
		
		if (!contato.getNome().equals(this.nome))
			return false;
		return true;
	}
}
