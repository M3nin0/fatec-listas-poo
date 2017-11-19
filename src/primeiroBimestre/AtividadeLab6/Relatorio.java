package br.edu.AtividadeLab6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Relatorio {

	private static List<Produto> produtos = new Vector<>();

	protected static void geraRelatorio() {

		produtos = GerenciadorEstoque.getProdutos();

		String cadastrados = GerenciadorEstoque.selecionaProd();

		if (cadastrados == null) {
			return;
		}

		File file = new File("./produtos.txt");
		Collections.sort(produtos);

		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter escreve = new BufferedWriter(fw);

			String report = "|Produto		|		Quantidade|\n";

			for (Produto produto : produtos) {

				report += "|" + produto.getTipoProduto() + "			" + "|			" + produto.getQuantidade()
						+ "|\n";
			}

			escreve.write(report);

			JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");

			escreve.close();

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Erro\n" + e.getMessage());

		}

	}

}
