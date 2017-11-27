package schedule.window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import schedule.schedule.Cadastro;

@SuppressWarnings("serial")
public abstract class JanelaCadastro extends JFrame implements Cadastro {

	protected JPanel panel;

	protected JButton btnCadastra;
	protected JButton btnVoltar;
	protected JButton btnLimparCampos;

	// Método para limpar os campos
	protected abstract void cleanInput();

	public JanelaCadastro() {

		setSize(400, 380);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		btnCadastra = new JButton("Registrar");
		btnLimparCampos = new JButton("Reset");
		btnVoltar = new JButton("Voltar");

		btnCadastra.setBounds(135, 270, 100, 20);
		btnVoltar.setBounds(0, 320, 100, 20);
		btnLimparCampos.setBounds(280, 320, 100, 20);
	}
}
