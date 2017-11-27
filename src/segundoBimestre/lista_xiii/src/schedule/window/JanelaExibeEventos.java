package schedule.window;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import schedule.events.Evento;
import schedule.schedule.Editable;

@SuppressWarnings("serial")
public class JanelaExibeEventos extends JanelaExibicao<Evento> implements Editable<Evento> {

	public JanelaExibeEventos() {
		setTitle("Eventos");
		update();
		setVisible(true);
	}

	public void edita(Evento evento) {

		Integer diaEvento = 0;
		Integer anoEvento = 0;

		JanelaMenu.listEventos.remove(evento);

		String nome = JOptionPane.showInputDialog("Insira o novo nome do evento\nEm branco para não alterar");
		String endereco = JOptionPane.showInputDialog("Insira o novo endereço do evento\nEm branco para não alterar");
		String dia = JOptionPane.showInputDialog("Insira o novo dia do evento\nEm branco para não alterar");
		String mes = JOptionPane.showInputDialog("Insira o nome do novo mês\nEm branco para não alterar");
		String ano = JOptionPane.showInputDialog("Insira o ano do evento\nEm branco para não alterar");
		String horario = JOptionPane.showInputDialog("Insira o novo horário (HH:MM)\nEm branco para não alterar");

		if (nome.trim().equals(""))
			nome = evento.getNome();
		if (endereco.trim().equals(""))
			endereco = evento.getEnderecoDoEvento();

		try {
			if (dia.trim().equals(""))
				diaEvento = evento.getDiaDoEvento();
			else
				diaEvento = Integer.parseInt(dia);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Apenas números no campo dia");
		}

		if (mes.trim().equals(""))
			mes = evento.getMes();
		if (ano.trim().equals(""))
			anoEvento = evento.getAno();
		else
			anoEvento = Integer.parseInt(ano);

		if (horario.trim().equals(""))
			horario = evento.getHorarioDeInicio();

		JanelaMenu.listEventos.add(new Evento(nome, endereco, diaEvento, mes, anoEvento, horario));
	}

	public void ver(Evento evento) {
		StringBuilder sb = new StringBuilder();

		sb.append("Nome do evento: ");
		sb.append(evento.getNome());
		sb.append("\nEndereco: ");
		sb.append(evento.getEnderecoDoEvento());
		sb.append("\nData: ");
		sb.append(evento.getDiaCompleto());
		sb.append("\nHora de inicio: ");
		sb.append(evento.getHorarioDeInicio());

		JOptionPane.showMessageDialog(null, sb.toString());
	}

	public void excluir(Evento evento) {
		JanelaMenu.listEventos.remove((Evento) boxItens.getSelectedItem());
		JOptionPane.showMessageDialog(null, "Operação de exclusão realizada com sucesso!");
		update();
	}

	@Override
	protected void update() {
		boxItens.removeAllItems();
		for (Evento evento : JanelaMenu.listEventos) {
			boxItens.addItem(evento);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEdit)
			edita((Evento) boxItens.getSelectedItem());
		else if (e.getSource() == btnVisualiza) {
			if (boxItens.getItemCount() == 0) {
				JOptionPane.showMessageDialog(null, "A lista está vazia");
				return;
			}
		
			ver((Evento) boxItens.getSelectedItem());
		}

		else if (e.getSource() == btnUpdate)
			update();
		else if (e.getSource() == btnExclude)
			excluir((Evento) boxItens.getSelectedItem());
		else if (e.getSource() == btnVoltar)
			setVisible(false);
	}
}
