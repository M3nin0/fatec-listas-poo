package br.edu.AtividadeLab7;

import java.io.Serializable;

public class Usuario implements Comparable<Usuario>, Serializable {

	private String nome;
	private String nickname;
	private String senha;

	public Usuario() {

	}

	public Usuario(String nickname, String senha) {
		this.nickname = nickname;
		this.senha = senha;
	}

	public Usuario(String nome, String nickname, String senha) {

		this.nome = nome;
		this.nickname = nickname;
		this.senha = senha;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {

		Usuario user = (Usuario) obj;

		if (this.getNickname().equals(user.getNickname())) {
			if (this.getSenha().equals(user.getSenha())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
