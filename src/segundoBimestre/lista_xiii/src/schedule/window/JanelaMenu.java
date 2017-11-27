package schedule.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import schedule.contact.Contato;
import schedule.events.Evento;
import schedule.schedule.Agenda;

@SuppressWarnings("serial")
public class JanelaMenu extends JFrame implements ActionListener {

	private JMenuBar barMenu;
	private JMenu cadastro;
	private JMenu eventos;
	private JMenu avisos;
	private JMenu configuracoes;
	private JMenuItem btnCadastrar;
	private JMenuItem btnVerContatos;
	private JMenuItem btnCadastraEvento;
	private JMenuItem btnVerEventos;
	private JMenuItem btnVerAvisos;
	private JMenuItem btnConfiguraBackup;
	private JMenuItem btnSair;

	protected static Agenda<Contato> listContatos;
	protected static Agenda<Evento> listEventos;

	public JanelaMenu() {

		listContatos = new Agenda<>();
		listEventos = new Agenda<>();

		setTitle("Agenda pessoal");
		setSize(600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		barMenu = new JMenuBar();
		setJMenuBar(barMenu);

		cadastro = new JMenu("Cadastrar");
		eventos = new JMenu("Eventos");
		avisos = new JMenu("Avisos");
		configuracoes = new JMenu("Configurações");

		barMenu.add(cadastro);
		barMenu.add(eventos);
		barMenu.add(avisos);
		barMenu.add(configuracoes);

		btnVerContatos = new JMenuItem("Ver contatos");
		btnCadastrar = new JMenuItem("Cadastrar contato");
		btnVerEventos = new JMenuItem("Consultar eventos");
		btnCadastraEvento = new JMenuItem("Cadastrar evento");
		btnVerAvisos = new JMenuItem("Ver avisos");
		btnConfiguraBackup = new JMenuItem("Configurar backup");
		btnSair = new JMenuItem("Sair");

		btnVerContatos.addActionListener(this);
		btnCadastrar.addActionListener(this);
		btnVerEventos.addActionListener(this);
		btnCadastraEvento.addActionListener(this);
		btnVerAvisos.addActionListener(this);
		btnConfiguraBackup.addActionListener(this);
		btnSair.addActionListener(this);

		cadastro.add(btnVerContatos);
		cadastro.add(btnCadastrar);

		eventos.add(btnVerEventos);
		eventos.add(btnCadastraEvento);

		avisos.add(btnVerAvisos);

		configuracoes.add(btnConfiguraBackup);
		configuracoes.add(btnSair);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerContatos) {
			new JanelaExibeContatos();
		} else if (e.getSource() == btnCadastrar) {
			new JanelaCadastroDeContato();
		} else if (e.getSource() == btnVerEventos) {
			new JanelaExibeEventos();
		} else if (e.getSource() == btnCadastraEvento) {
			new JanelaCadastroDeEvento();
		} else if (e.getSource() == btnVerAvisos) {
			new JanelaAvisos();
		}
		else if (e.getSource() == btnConfiguraBackup) {
			new JanelaBackup();
		} else if (e.getSource() == btnSair) {
			System.exit(0);
		}
	}
}
