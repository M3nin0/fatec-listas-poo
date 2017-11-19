package br.edu.AtividadeLab7;

import javax.swing.JOptionPane;

//Classe que irá suportar os pagamentos e despesas
public class Pagamento implements Operacao {

	@Override
	public void operacao(String tipoOperacao, String produtoServicoEnvolvido, double valorOperacao) {

		Caixa caixa = new Caixa();
		StringBuilder sb = new StringBuilder("");

		sb.append("Operação: ");
		sb.append(tipoOperacao);
		sb.append(" ;Produto/Servico envolvido: ");
		sb.append(produtoServicoEnvolvido);
		sb.append(" ;Valor: R$");
		sb.append(valorOperacao);

		caixa.addPagamentos(sb.toString(), valorOperacao);

	}

	@Override
	public void registraOperacao(String tipoOperacao) {

		String produtoServicoEnvolvido = JOptionPane
				.showInputDialog("Insira o produto/serviço que gerou esta operação");
		double valorOperacao = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor da operação"));

		operacao(tipoOperacao, produtoServicoEnvolvido, valorOperacao);

	}

}
