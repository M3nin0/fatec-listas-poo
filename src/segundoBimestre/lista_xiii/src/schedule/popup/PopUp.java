package schedule.popup;

import java.time.LocalDate;

/*
 * Classe que trata dos avisos
 * Esses que são exibidos para eventos que irão ocorrer dentro de dois 
 * dias.
 */

import javax.swing.DefaultListModel;

import schedule.events.Evento;
import schedule.schedule.Agenda;

public class PopUp {

	private DefaultListModel<String> modelAvisos;

	public PopUp() {
		modelAvisos = new DefaultListModel<>();
	}

	public DefaultListModel<String> genAvisos(Agenda<Evento> eventos) {

		String[] datas = new String[3];
		datas = String.valueOf(LocalDate.now()).split("-");

		int cont = 0;
		for (Evento evento : eventos) {
			int data = (evento.getDiaDoEvento() - Integer.parseInt(datas[2]));

			if (data <= 2 && evento.getMesNum() == Integer.parseInt(datas[1]) - 1
					&& evento.getAno() == Integer.parseInt(datas[0])) {

				String dd = "";
				if (data == 0)
					dd = " acontecerá em hoje. Consulte as informações do evento";
				else if (data == 1)
					dd = " acontecerá amanhã. Consulte as informações do evento";
				else
					dd = " acontecerá em " + data + " dias. Consulte as informações do evento";

				modelAvisos.add(cont, evento.getNome() + dd);

				cont++;
			}
		}

		return modelAvisos;
	}

}
