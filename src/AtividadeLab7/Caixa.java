package br.edu.AtividadeLab7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Caixa {

	private static List<String> regVendas = new ArrayList<>();
	private static List<String> regPagamentos = new ArrayList<>();
	private static double histVendas = 0;
	private static double histPagamentos = 0;

	private static double valorEmCaixa = 0;
	private static double totalMovimentado = 0; // Valor que abrange o que foi ganho e o que foi gasto

	public void addVendas(String descricao, double valorVenda) {

		regVendas.add(descricao);

		Caixa.histVendas += valorVenda;
		Caixa.valorEmCaixa += valorVenda;
		Caixa.totalMovimentado += valorVenda;
	}

	public void addPagamentos(String descricao, double valorPagamento) {

		regPagamentos.add(descricao);

		Caixa.histPagamentos += valorPagamento;
		Caixa.valorEmCaixa -= valorPagamento;
		Caixa.totalMovimentado += valorPagamento;

	}

	public String getRegVendas() {

		StringBuffer sb = new StringBuffer();

		sb.append("\n");
		for (String vendas : regVendas) {
			sb.append(vendas);
			sb.append("\n");
			sb.append("\n");
		}

		return sb.toString();

	}

	public String getRegPagamentos() {

		StringBuffer sb = new StringBuffer();

		sb.append("\n");
		for (String pagamentos : regPagamentos) {
			sb.append(pagamentos);
			sb.append("\n");
			sb.append("\n");
		}

		return sb.toString();

	}
	
	//Arquivos para serem movimentados e lidos facilmente
	public void salvaInfos() {

		Caixa caixa = new Caixa();
		String pagamentos = caixa.getRegPagamentos();
		String vendas = caixa.getRegVendas();

		try {

			File fVendas = new File("./infosVendas.txt");
			FileWriter fwV = new FileWriter(fVendas);
			BufferedWriter escreveV = new BufferedWriter(fwV);

			escreveV.write(vendas);

			escreveV.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {
			File fPagamentos = new File("./infosPagamentos.txt");
			FileWriter fwP = new FileWriter(fPagamentos);
			BufferedWriter escreveP = new BufferedWriter(fwP);

			escreveP.write(pagamentos);

			escreveP.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {
			File file = new File("./numeros.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter escreve = new BufferedWriter(fw);
			StringBuilder sb = new StringBuilder();

			sb.append("\n");
			sb.append(Caixa.getHistVendas());
			sb.append("\n");
			sb.append(Caixa.getHistPagamentos());
			sb.append("\n");
			sb.append(Caixa.valorEmCaixa);
			sb.append("\n");
			sb.append(Caixa.totalMovimentado);
			sb.append("\n");

			escreve.write(sb.toString());

			escreve.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		JOptionPane.showMessageDialog(null, "Dados Exportados com sucesso!");

	}

	public void recuperaInfos() {

		File fVendas = new File("./infosVendas.txt");
		File fPagamentos = new File("./infosPagamentos.txt");
		File file = new File("./numeros.txt");

		try {
			FileReader rVendas = new FileReader(fVendas);
			BufferedReader br = new BufferedReader(rVendas);

			while ((br.readLine()) != null) {

				regVendas.add(br.readLine());

			}

			br.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {
			FileReader rPagamentos = new FileReader(fPagamentos);
			BufferedReader br = new BufferedReader(rPagamentos);

			while ((br.readLine()) != null) {

				regPagamentos.add(br.readLine());
			}

			br.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {
			FileReader rNumeros = new FileReader(file);
			BufferedReader br = new BufferedReader(rNumeros);

			while ((br.readLine()) != null) {
				Caixa.histVendas = Double.parseDouble(br.readLine());
				Caixa.histPagamentos = Double.parseDouble(br.readLine());
				Caixa.valorEmCaixa = Double.parseDouble(br.readLine());
				Caixa.totalMovimentado = Double.parseDouble(br.readLine());
			}

			br.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "Dados importados com sucesso!");

	}

	public double getTotalMovimentado() {
		return totalMovimentado;
	}

	public double getValorEmCaixa() {
		return valorEmCaixa;
	}

	public static double getHistVendas() {
		return histVendas;
	}

	public static double getHistPagamentos() {
		return histPagamentos;
	}

	public static void setRegVendas(List<String> regVendas) {
		Caixa.regVendas = regVendas;
	}

	public static void setRegPagamentos(List<String> regPagamentos) {
		Caixa.regPagamentos = regPagamentos;
	}

}
