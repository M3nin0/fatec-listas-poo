package br.edu.AtividadeLab6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectStreamException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {

		GerenciadorEstoque estoque = new GerenciadorEstoque();
		Backup bkp = new Backup();

		setTitle("Sistema de cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar produto");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estoque.cadastrarProduto();
			}
		});
		btnCadastrar.setBounds(31, 60, 199, 25);
		contentPane.add(btnCadastrar);

		JButton btnEditarProduto = new JButton("Editar produto");
		btnEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estoque.editarProduto();
			}
		});
		btnEditarProduto.setBounds(299, 60, 199, 25);
		contentPane.add(btnEditarProduto);

		JButton btnReport = new JButton("Gerar relatório");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.geraRelatorio();
			}
		});
		btnReport.setBounds(31, 161, 199, 25);
		contentPane.add(btnReport);

		JButton btnExclui = new JButton("Excluir produto");
		btnExclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estoque.excluirProduto();
			}
		});
		btnExclui.setBounds(299, 161, 199, 25);
		contentPane.add(btnExclui);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(381, 406, 117, 25);
		contentPane.add(btnSair);

		JButton btnImportarDados = new JButton("Importar dados");
		btnImportarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bkp.recuperaDados();
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao recuperar");
				}
			}
		});
		btnImportarDados.setBounds(12, 375, 199, 25);
		contentPane.add(btnImportarDados);

		JButton btnExportarDados = new JButton("Exportar dados");
		btnExportarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bkp.salvaDados();
				} catch (FileNotFoundException f) {
					JOptionPane.showMessageDialog(null, f.getMessage());
				} catch (IOException f) {
					JOptionPane.showMessageDialog(null, f.getMessage());
				}
			}
		});
		btnExportarDados.setBounds(12, 406, 199, 25);
		contentPane.add(btnExportarDados);
	}
}
