package br.edu.AtividadeLab7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField cmpLogin;
	private JPasswordField cmpSenha;
	
	static Login login = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		Cadastro cadastro = new Cadastro();
		
		cadastro.recuperaUsuarios();
		
		setResizable(false);
		setTitle("Login - Fluxo de caixa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(206, 31, 98, 34);
		contentPane.add(lblLogin);
		
		cmpLogin = new JTextField();
		cmpLogin.setBounds(138, 68, 183, 27);
		contentPane.add(cmpLogin);
		cmpLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(206, 107, 98, 27);
		contentPane.add(lblSenha);
		
		cmpSenha = new JPasswordField();
		cmpSenha.setBounds(138, 139, 183, 27);
		contentPane.add(cmpSenha);
		
		JButton btnLogin = new JButton("Fazer login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Cadastro.getCadastrados(cmpLogin.getText(), cmpSenha.getText())) {
					Menu frame = new Menu();
					login.setVisible(false);
					frame.setVisible(true);
				};
			}
		});
		btnLogin.setBounds(167, 207, 117, 25);
		contentPane.add(btnLogin);
	}
}
