package exe_1;

public class Contato implements Comparable{
	
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public int compareTo(Object arg0) {
		Contato contato = (Contato) arg0;
		if (contato.getId() > this.getId())
			return 1;
		else if (contato.getId() == this.getId())
			return 0;
		return -1;
	}
}
