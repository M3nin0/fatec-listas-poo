package schedule.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JanelaContatos extends JFrame implements ActionListener {

	public JanelaContatos() {
		setTitle("Contatos");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
