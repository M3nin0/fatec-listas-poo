package schedule.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import schedule.popup.PopUp;

@SuppressWarnings("serial")
public class JanelaAvisos extends JFrame implements ActionListener {

	private JPanel panel;

	private JButton btnUpdate;
	private JButton btnVoltar;

	private PopUp popUp;

	private DefaultListModel<String> modelAvisos;
	private JList<String> listAvisos;

	public JanelaAvisos() {

		modelAvisos = new DefaultListModel<>();

		popUp = new PopUp();
		modelAvisos = popUp.genAvisos(JanelaMenu.listEventos); 
		
		listAvisos = new JList<>(modelAvisos);
		
		btnUpdate = new JButton("Atualizar");
		btnVoltar = new JButton("Voltar");

		panel = new JPanel();
		setContentPane(panel);

		setTitle("Avisos");
		setSize(550, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		btnVoltar.setBounds(0, 250, 100, 20);
		btnUpdate.setBounds(245, 250, 100, 20);
		listAvisos.setBounds(200, 125, 250, 180);
		
		btnUpdate.addActionListener(this);
		btnVoltar.addActionListener(this);

		panel.add(btnUpdate);
		panel.add(btnVoltar);
		panel.add(listAvisos);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVoltar)
			setVisible(false);
		else if (e.getSource() == btnUpdate) {
			modelAvisos.setSize(0);
			modelAvisos = popUp.genAvisos(JanelaMenu.listEventos); 
		}
	}
}
