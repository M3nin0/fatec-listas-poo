package br.edu.AtividadeLab7;

//Interface para obrigar que uma função de operação seja implementada
public interface Operacao {
	
	void registraOperacao(String tipoOperacao);
	void operacao(String tipoOperacao, String produtoServicoEnvolvido, double valorOperacao);


}
