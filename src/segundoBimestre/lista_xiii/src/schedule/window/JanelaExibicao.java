package schedule.window;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public abstract class JanelaExibicao<E> extends JFrame implements ActionListener{

	protected JPanel panel;

	protected JButton btnUpdate;
	protected JButton btnExclude;
	protected JButton btnEdit;
	protected JButton btnVisualiza;
	protected JButton btnVoltar;

	protected JComboBox<E> boxItens;

	protected JanelaExibicao() {
		panel = new JPanel();

		setTitle("Contatos");
		setSize(450, 350);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setContentPane(panel);
		panel.setLayout(null);

		boxItens = new JComboBox<E>();
		boxItens.setBounds(150, 100, 150, 20);

		btnUpdate = new JButton("Atualizar");
		btnExclude = new JButton("Excluir");
		btnEdit = new JButton("Editar");
		btnVisualiza = new JButton("Ver");
		btnVoltar = new JButton("Voltar");

		btnUpdate.setBounds(120 , 185, 100, 20);
		btnEdit.setBounds(10, 185, 100, 20);
		btnExclude.setBounds(335, 185, 100, 20);
		btnVisualiza.setBounds(230, 185, 100, 20);
		btnVoltar.setBounds(0, 250, 100, 20);

		btnUpdate.addActionListener(this);
		btnEdit.addActionListener(this);
		btnExclude.addActionListener(this);
		btnVisualiza.addActionListener(this);
		btnVoltar.addActionListener(this);

		panel.add(btnUpdate);
		panel.add(btnEdit);
		panel.add(btnExclude);
		panel.add(btnVisualiza);
		panel.add(btnVoltar);
		panel.add(boxItens);

	}

	protected abstract void update();

}
