package exe_2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {
	private JButton btnSoma, btnSub, btnDiv, btnMult;
	private JLabel resultado;
	private JTextField num_1, num_2;

	public Janela() {
		setTitle("Cálculadora legal");

		setSize(new Dimension(500, 80));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 7, 7));

		btnSoma = new JButton("+");
		add(btnSoma);
		btnSoma.addActionListener(this);

		btnSub = new JButton("-");
		add(btnSub);
		btnSub.addActionListener(this);

		btnDiv = new JButton("/");
		add(btnDiv);
		btnDiv.addActionListener(this);

		btnMult = new JButton("*");
		add(btnMult);
		btnMult.addActionListener(this);

		num_1 = new JTextField();
		add(num_1);
		num_1.setColumns(5);

		num_2 = new JTextField();
		add(num_2);
		num_2.setColumns(5);

		resultado = new JLabel("Resultado:");
		add(resultado);

		setResizable(false);
		setDefaultCloseOperation(3);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSoma)
			resultado.setText(
					"Resultado: " + (Double.parseDouble(num_1.getText()) + Double.parseDouble(num_2.getText())));
		if (e.getSource() == btnSub)
			resultado.setText(
					"Resultado: " + (Double.parseDouble(num_1.getText()) - Double.parseDouble(num_2.getText())));
		if (e.getSource() == btnDiv)
			resultado.setText(
					"Resultado: " + (Double.parseDouble(num_1.getText()) / Double.parseDouble(num_2.getText())));
		if (e.getSource() == btnMult)
			resultado.setText(
					"Resultado: " + (Double.parseDouble(num_1.getText()) * Double.parseDouble(num_2.getText())));
	}

}
