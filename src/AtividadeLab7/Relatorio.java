package br.edu.AtividadeLab7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

public class Relatorio {
	
	public void report() {
		
		Caixa caixa = new Caixa();
		Date data = new Date();
		StringBuilder sb = new StringBuilder();
		File file = new File("./relatorio" + "_" + data.getTime() + ".txt");
		
		try {
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter escreve = new BufferedWriter(fw);
			
			String vendas = caixa.getRegVendas();
			String pagamentos = caixa.getRegPagamentos();
			
			escreve.write("Vendas/recebimentos/Pagamentos/despesas\n");
			escreve.write(vendas);
			escreve.write(pagamentos);
			
			sb.append("\n\nValor total em caixa: ");
			sb.append(caixa.getValorEmCaixa());
			sb.append("\nValor total movimentado: ");
			sb.append(caixa.getTotalMovimentado());
			
			sb.append("\nHistório de entrada e saída dos produtos\n");
			sb.append("Entradas\n");
			sb.append(Caixa.getHistVendas());
			sb.append("\nSaídas\n");
			sb.append(Caixa.getHistPagamentos());
			
			escreve.write(sb.toString());
				
			escreve.close();
			fw.close();
			
			
			JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso");
			
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
