package exe_1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contato implements Comparable<Contato>, Serializable{
	private String nome;
	private String email;
	private Integer telefone;

	public Contato(String nome, String email, Integer telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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

	public boolean equals(Object obj) {

		Contato contato = (Contato) obj;

		if (contato.nome.toLowerCase().equals(this.nome.toLowerCase()))
			return true;

		return false;
	}

	public String toString() {
		return this.nome;
	}

	@Override
	public int compareTo(Contato arg0) {
		return this.nome.compareTo(arg0.nome);
	}
}
