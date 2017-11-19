package exe_1;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Desenho extends JComponent {

	@SuppressWarnings("unused")
	private int altura;
	@SuppressWarnings("unused")
	private int largura;

	public Desenho(int largura, int altura) {
		this.altura = altura;
		this.largura = largura;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 15; i++) {
			g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
		}
	}

}
