package schedule.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import schedule.events.Evento;

@SuppressWarnings("serial")
public class JanelaCadastroDeEvento extends JanelaCadastro implements ActionListener {

	private JLabel lblNomeEvento;
	private JLabel lblEndereco;
	private JLabel lblDiaEvento;
	private JLabel lblMes;
	private JLabel lblAno;
	private JLabel lblHorarioInicio;

	private JTextField inputNomeDoEvento;
	private JTextField inputEnderecoDoEvento;
	private JTextField inputDiaInicioDoEvento;
	private JTextField inputAno;

	// Caixa com as números
	// utiliza-se spinner
	private SpinnerModel modelHour, modelSecond;
	private JSpinner inputHour;
	private JSpinner inputSecond;

	private String[] months = {"Janeiro", "Fevereiro", "Março", "Abrir", "Maio", "Junho", "Julho", "Agosto",
			"Setembro", "Outubro", "Novembro", "Dezembro"};

	public static Map<String, Integer> meses = new HashMap<>();

	private JComboBox<String> boxMes = new JComboBox<>(months);

	public JanelaCadastroDeEvento() {

		popula();

		// SpinnerNumberModel(value, min, max, step)
		modelHour = new SpinnerNumberModel(1, 0, 23, 1);
		modelSecond = new SpinnerNumberModel(1, 00, 59, 1);

		inputHour = new JSpinner(modelHour);
		inputSecond = new JSpinner(modelSecond);

		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);

		setTitle("Cadastro de eventos");

		lblNomeEvento = new JLabel("Nome do evento");
		lblEndereco = new JLabel("Endereço");
		lblDiaEvento = new JLabel("Dia");
		lblMes = new JLabel("Mês");
		lblAno = new JLabel("Ano");
		lblHorarioInicio = new JLabel("Hora");

		inputNomeDoEvento = new JTextField();
		inputEnderecoDoEvento = new JTextField();
		inputDiaInicioDoEvento = new JTextField();
		inputAno = new JTextField();

		// x, y, width, height
		lblNomeEvento.setBounds(40, 25, 130, 25);
		lblEndereco.setBounds(40, 65, 100, 25);
		lblDiaEvento.setBounds(40, 95, 100, 25);
		lblMes.setBounds(40, 135, 100, 25);
		lblAno.setBounds(40, 180, 100, 25);

		lblHorarioInicio.setBounds(40, 220, 100, 25);

		inputNomeDoEvento.setBounds(170, 25, 125, 25);
		inputEnderecoDoEvento.setBounds(170, 65, 125, 25);
		inputDiaInicioDoEvento.setBounds(170, 95, 125, 25);
		inputAno.setBounds(170, 180, 125, 25);

		boxMes.setBounds(185, 130, 100, 25);

		inputHour.setBounds(190, 220, 35, 25);
		inputSecond.setBounds(227, 220, 35, 25);

		btnCadastra.addActionListener(this);
		btnLimparCampos.addActionListener(this);
		btnVoltar.addActionListener(this);

		panel.add(lblNomeEvento);
		panel.add(lblEndereco);
		panel.add(lblDiaEvento);
		panel.add(lblMes);
		panel.add(lblAno);
		panel.add(lblHorarioInicio);

		panel.add(btnCadastra);
		panel.add(btnVoltar);
		panel.add(btnLimparCampos);

		panel.add(inputHour);
		panel.add(inputSecond);
		panel.add(inputNomeDoEvento);
		panel.add(inputEnderecoDoEvento);
		panel.add(inputDiaInicioDoEvento);
		panel.add(inputAno);

		panel.add(boxMes);

		setVisible(true);
	}

	public void popula() {
		int c = 1;
		while (c < months.length) {
			meses.put(months[c], c);
			c += 1;
		}
	}

	public void cadastro() {

		/*
		 * Verificação é feita no getText, caso esteja vazio ele faz reset nos campos e
		 * o processo tem de ser refeito
		 */
		String nome = inputNomeDoEvento.getText();
		String endereco = inputEnderecoDoEvento.getText();
		String ano = inputAno.getText();
		String mes = (String) boxMes.getSelectedItem();
		Integer diaEvento = Integer.parseInt(inputDiaInicioDoEvento.getText());
		String horario = inputHour.getValue() + ":" + inputSecond.getValue();

		JanelaMenu.listEventos.add(new Evento(nome, endereco, diaEvento, mes, Integer.parseInt(ano), horario));

		cleanInput();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCadastra) {
			try {
				cadastro();
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			} catch (Exception agr0) {
				JOptionPane.showMessageDialog(null, agr0.getMessage());
			}
			cleanInput();
		} else if (e.getSource() == btnLimparCampos) {
			cleanInput();
		} else if (e.getSource() == btnVoltar)
			setVisible(false);
	}

	@Override
	protected void cleanInput() {
		inputNomeDoEvento.setText("");
		inputDiaInicioDoEvento.setText("");
		inputAno.setText("");
		inputEnderecoDoEvento.setText("");
		inputHour.setValue(1);
		inputSecond.setValue(1);
	}
}
