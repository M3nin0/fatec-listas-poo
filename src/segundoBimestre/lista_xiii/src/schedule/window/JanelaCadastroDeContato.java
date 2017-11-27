package schedule.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import schedule.contact.Contato;

@SuppressWarnings("serial")
public class JanelaCadastroDeContato extends JanelaCadastro implements ActionListener {

	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JLabel lblEndereco;

	private JTextField inputName;
	private JTextField inputEmail;
	private JTextField inputTelefone;
	private JTextField inputEndereco;

	public JanelaCadastroDeContato() {

		panel = new JPanel();
		setContentPane(panel);

		setTitle("Cadastro de contatos");

		panel.setLayout(null);

		inputName = new JTextField();
		inputEmail = new JTextField();
		inputTelefone = new JTextField();
		inputEndereco = new JTextField();

		lblName = new JLabel("Nome");
		lblEmail = new JLabel("Email");
		lblTelefone = new JLabel("Telefone");
		lblEndereco = new JLabel("Endereço");

		lblName.setBounds(80, 80, 80, 25);
		lblEmail.setBounds(80, 120, 80, 25);
		lblTelefone.setBounds(80, 160, 80, 25);
		lblEndereco.setBounds(80, 200, 80, 25);

		// X, Y, largura, altura
		inputName.setBounds(220, 80, 100, 25);
		inputEmail.setBounds(220, 120, 100, 25);
		inputTelefone.setBounds(220, 160, 100, 25);
		inputEndereco.setBounds(220, 200, 100, 25);

		btnCadastra.addActionListener(this);
		btnVoltar.addActionListener(this);
		btnLimparCampos.addActionListener(this);

		panel.add(lblName);
		panel.add(lblEmail);
		panel.add(lblTelefone);
		panel.add(lblEndereco);
		panel.add(inputName);
		panel.add(inputEmail);
		panel.add(inputTelefone);
		panel.add(inputEndereco);
		panel.add(btnCadastra);
		panel.add(btnVoltar);
		panel.add(btnLimparCampos);

		setVisible(true);
	}

	public void cadastro() {
		String nome = inputName.getText();
		String email = inputEmail.getText();
		String telefone = inputTelefone.getText();
		String endereco = inputEndereco.getText();

		try {
			if (nome.trim().equals("") || email.trim().equals("") || telefone.trim().equals("")
					|| endereco.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
			} else {
				JanelaMenu.listContatos.add(new Contato(nome, email, Integer.parseInt(telefone), endereco));
				cleanInput();
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Preencha os campos corretamente\nLembrando que o telefone deve conter apenas números");
			inputTelefone.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCadastra) {
			cadastro();
		} else if (arg0.getSource() == btnVoltar)
			setVisible(false);
		else if (arg0.getSource() == btnLimparCampos)
			cleanInput();
	}

	@Override
	protected void cleanInput() {
		inputEmail.setText("");
		inputName.setText("");
		inputTelefone.setText("");
		inputEndereco.setText("");
	}
}
