package exe_1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contato implements Serializable {

	private int telefone;
	private int id;
	private String nome;
	private String email;

	public Contato(String nome, String email, int telefone, int id) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Contato))
			return false;

		Contato contato = (Contato) obj;

		if (!contato.getNome().equals(this.nome))
			return false;
		return true;
	}
}
