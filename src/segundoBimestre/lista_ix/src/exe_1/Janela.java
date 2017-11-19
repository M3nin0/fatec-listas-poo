package exe_1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Janela extends JFrame {

	public Janela() {

		setTitle("Janela de desenho");
		setSize(new Dimension(400, 450));

		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 3));

		c.add(new Desenho(200, 250));
		
		setVisible(true);
	}

}
