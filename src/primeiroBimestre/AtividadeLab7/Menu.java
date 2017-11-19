package br.edu.AtividadeLab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu() {

		Relatorio relatorio = new Relatorio();
		Cadastro cadastro = new Cadastro();
		Caixa caixa = new Caixa();
		Venda venda = new Venda();
		Pagamento pagamento = new Pagamento();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrarVenda = new JButton("Registrar venda");
		btnRegistrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venda.registraOperacao("Venda");
			}
		});
		btnRegistrarVenda.setBounds(96, 92, 216, 25);
		contentPane.add(btnRegistrarVenda);

		JButton btnRegistrarRecebimento = new JButton("Registrar recebimento");
		btnRegistrarRecebimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venda.registraOperacao("Recebimento");
			}
		});
		btnRegistrarRecebimento.setBounds(96, 115, 216, 25);
		contentPane.add(btnRegistrarRecebimento);

		JButton btnRegistrarPagamento = new JButton("Registrar pagamento");
		btnRegistrarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamento.registraOperacao("Pagamento");
			}
		});
		btnRegistrarPagamento.setBounds(96, 227, 216, 25);
		contentPane.add(btnRegistrarPagamento);

		JButton btnRegistrarDespesas = new JButton("Registrar despesas");
		btnRegistrarDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamento.registraOperacao("Despesa");
			}
		});
		btnRegistrarDespesas.setBounds(96, 254, 216, 25);
		contentPane.add(btnRegistrarDespesas);

		JLabel lblEntradaDeCaixa = new JLabel("Entrada de caixa");
		lblEntradaDeCaixa.setBounds(148, 65, 216, 15);
		contentPane.add(lblEntradaDeCaixa);

		JLabel lblSaidaDeCaixa = new JLabel("Saida de caixa");
		lblSaidaDeCaixa.setBounds(148, 201, 216, 15);
		contentPane.add(lblSaidaDeCaixa);

		JButton btnCadastrarUsurio = new JButton("Cadastrar usuário");
		btnCadastrarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cadastro.cadastraUsuario();
				cadastro.salvaUsuarios();
			}
		});
		btnCadastrarUsurio.setBounds(12, 390, 190, 25);
		contentPane.add(btnCadastrarUsurio);

		JButton btnGerarRelatrio = new JButton("Gerar relatório");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorio.report();
			}
		});
		btnGerarRelatrio.setBounds(12, 420, 190, 25);
		contentPane.add(btnGerarRelatrio);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(12, 450, 117, 25);
		contentPane.add(btnSair);

		JButton btnFluxoTotalDe = new JButton("Fluxo total de caixa");
		btnFluxoTotalDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StringBuffer sb = new StringBuffer("Suas operações movimentaram\n");
				sb.append(caixa.getTotalMovimentado());

				JOptionPane.showMessageDialog(null, sb.toString());
				

			}
		});
		btnFluxoTotalDe.setBounds(12, 365, 190, 25);
		contentPane.add(btnFluxoTotalDe);
		
		JButton btnImport = new JButton("Importar");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caixa.recuperaInfos();
			}
		});
		btnImport.setBounds(279, 365, 136, 25);
		contentPane.add(btnImport);
		
		JButton btnExport = new JButton("Exportar");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caixa.salvaInfos();
			}
		});
		btnExport.setBounds(279, 390, 136, 25);
		contentPane.add(btnExport);
	}

}
