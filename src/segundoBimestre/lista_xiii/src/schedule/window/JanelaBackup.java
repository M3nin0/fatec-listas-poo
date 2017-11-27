package schedule.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import schedule.persistence.Backup;

@SuppressWarnings("serial")
public class JanelaBackup extends JFrame implements ActionListener {

	private JButton btnSalvaContato;
	private JButton btnSalvaEvento;
	private JButton btnRecoverContato;
	private JButton btnRecoverEvento;
	private JButton btnVoltar;

	private JPanel panel;

	public JanelaBackup() {

		setTitle("Backup");
		setSize(450, 150);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		panel = new JPanel();
		setContentPane(panel);

		btnSalvaContato = new JButton("Salvar contato");
		btnSalvaEvento = new JButton("Salvar evento");
		btnRecoverContato = new JButton("Recuperar contato salvos");
		btnRecoverEvento = new JButton("Recuperar eventos salvos");
		btnVoltar = new JButton("Voltar");

		btnSalvaContato.setBounds(225, 270, 60, 60);
		btnSalvaEvento.setBounds(225, 300, 60, 60);
		btnRecoverContato.setBounds(225, 320, 60, 60);
		btnRecoverEvento.setBounds(225, 350, 60, 60);
		btnVoltar.setBounds(225, 370, 30, 30);

		btnSalvaContato.addActionListener(this);
		btnSalvaEvento.addActionListener(this);
		btnRecoverContato.addActionListener(this);
		btnRecoverEvento.addActionListener(this);
		btnVoltar.addActionListener(this);

		panel.add(btnSalvaContato);
		panel.add(btnSalvaEvento);
		panel.add(btnRecoverContato);
		panel.add(btnRecoverEvento);
		panel.add(btnVoltar);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSalvaContato)
			Backup.salvaContatos(JanelaMenu.listContatos);

		else if (e.getSource() == btnSalvaEvento)
			Backup.salvaEventos(JanelaMenu.listEventos);

		else if (e.getSource() == btnRecoverContato)
			JanelaMenu.listContatos = Backup.recoverContatos();

		else if (e.getSource() == btnRecoverEvento)
			JanelaMenu.listEventos = Backup.recoverEventos();

		else if (e.getSource() == btnVoltar)
			setVisible(false);
	}
}
