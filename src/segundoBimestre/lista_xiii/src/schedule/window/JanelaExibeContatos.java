package schedule.window;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import schedule.contact.Contato;
import schedule.schedule.Editable;

@SuppressWarnings("serial")
public class JanelaExibeContatos extends JanelaExibicao<Contato> implements Editable<Contato> {

	public JanelaExibeContatos() {

		panel.add(boxItens);

		update();
		setVisible(true);
	}

	protected void update() {

		if (boxItens.getItemCount() != 0)
			boxItens.removeAllItems();
		for (Contato contact : JanelaMenu.listContatos)
			boxItens.addItem(contact);
	}

	@Override
	public void edita(Contato contato) {

		if (boxItens.getItemCount() == 0) {
			JOptionPane.showMessageDialog(null, "A lista está vazia");
			return;
		}

		JanelaMenu.listContatos.remove(contato);

		String nome = JOptionPane.showInputDialog("Insira o novo nome\nEm branco para não alterar");
		String email = JOptionPane.showInputDialog("Insira o novo email\nEm branco para não alterar");
		String telefone = JOptionPane.showInputDialog("Insira o novo número de telefone\nEm branco para não alterar");
		String endereco = JOptionPane.showInputDialog("Insira o novo endereço\nEm branco para não alterar");

		Integer telTemp;

		if (nome.trim().equals(""))
			nome = contato.getNome();
		if (email.trim().equals(""))
			email = contato.getEmail();
		if (telefone.trim().equals(""))
			telTemp = contato.getTelefone();
		else
			telTemp = Integer.parseInt(telefone);
		if (endereco.trim().equals(""))
			endereco = contato.getEndereco();

		JanelaMenu.listContatos.add(new Contato(nome, email, telTemp, endereco));

		update();
	}

	@Override
	public void excluir(Contato e) {
		JanelaMenu.listContatos.remove(e);

	}

	@Override
	public void ver(Contato e) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("Informações do usuário selecionado");
		stringBuilder.append("\n");
		stringBuilder.append("Nome: ");
		stringBuilder.append(e.getNome());
		stringBuilder.append("\n");
		stringBuilder.append("Email: ");
		stringBuilder.append(e.getEmail());
		stringBuilder.append("\n");
		stringBuilder.append("Telefone: ");
		stringBuilder.append(e.getTelefone());
		stringBuilder.append("\n");
		stringBuilder.append("Endereço: ");
		stringBuilder.append(e.getEndereco());
		stringBuilder.append("\n");

		JOptionPane.showMessageDialog(null, stringBuilder.toString());
		stringBuilder.setLength(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnUpdate) {
			update();
		} else if (e.getSource() == btnEdit) {

			edita((Contato) boxItens.getSelectedItem());

			JOptionPane.showMessageDialog(null, "Operação de atualização realizada com sucesso!");

		} else if (e.getSource() == btnExclude) {
			excluir((Contato) boxItens.getSelectedItem());
		} else if (e.getSource() == btnVisualiza) {

			if (!(boxItens.getItemCount() == 0))
				ver((Contato) boxItens.getSelectedItem());
			else
				JOptionPane.showMessageDialog(null, "Não há itens na lista");

		} else if (e.getSource() == btnVoltar) {
			setVisible(false);
		}
	}
}
