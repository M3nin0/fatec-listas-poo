package schedule.events;

import java.io.Serializable;

import schedule.window.JanelaCadastroDeEvento;

@SuppressWarnings("serial")
public class Evento implements Serializable {

	private String nome;
	private String enderecoDoEvento;

	private Integer diaDoEvento;
	private String mes;
	private Integer ano;
	private String horarioDeInicio;

	private Integer mesNum;

	public Evento(String nome, String enderecoDoEvento, Integer diaDoEvento, String mes, Integer ano,
			String horarioDeInicio) {

		this.nome = nome;
		this.enderecoDoEvento = enderecoDoEvento;
		this.diaDoEvento = diaDoEvento;
		this.mes = mes;
		this.ano = ano;
		this.horarioDeInicio = horarioDeInicio;

		mesNum = JanelaCadastroDeEvento.meses.get(mes);
	}

	public Integer getMesNum() {
		return mesNum;
	}

	public Integer getAno() {
		return ano;
	}

	public String getNome() {
		return nome;
	}

	public String getEnderecoDoEvento() {
		return enderecoDoEvento;
	}

	public Integer getDiaDoEvento() {
		return diaDoEvento;
	}

	public String getDiaCompleto() {
		return diaDoEvento + " de " + mes + " de " + ano;
	}

	public String getMes() {
		return mes;
	}

	public String getHorarioDeInicio() {
		return horarioDeInicio;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public boolean equals(Object e) {

		/*
		 * equals melhorado: Neste equals faço a verificação se o objeto e é um evento
		 * 
		 * instanceof pode ser lido como "é um"
		 */
		if (!(e instanceof Evento))
			return false;
		Evento evento = (Evento) e;

		if (!this.nome.equals(evento.getNome()))
			return false;
		return true;
	}

}
