package exe_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public static void main(String[] args) throws InterruptedException {
		Agenda<Contato> agenda = new Agenda<>();
		agenda.add(new Contato("Felipe", "email@email.com", 123456789, 0));
		
		Thread.sleep(10);
		
//		agenda.remove(0);
		
		
	}
}
