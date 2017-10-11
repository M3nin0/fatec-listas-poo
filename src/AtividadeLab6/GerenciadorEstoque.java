package br.edu.AtividadeLab6;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GerenciadorEstoque {

	private static List<Produto> produtos = new Vector<>();

	// Método para cadastrar os produtos
	public void cadastrarProduto() {

		String tipoProduto = JOptionPane.showInputDialog("Insira o nome do produto");
		String quantidade = JOptionPane.showInputDialog("Insira a quantidade inicial");

		Produto prodTemp = new Produto(tipoProduto, quantidade);

		for (Produto produto : produtos) {

			if (produto.equals(prodTemp)) {
				JOptionPane.showMessageDialog(null, "Produto já cadastrado");
				return;
			}

		}

		try {
			produtos.add(new Produto(tipoProduto, quantidade));
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto\n" + "Erro: " + e.getMessage());

		}

		return;

	}

	// Método para listar produtos cadastrados
	protected static String selecionaProd() {

		if (produtos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não há produtos cadastrados!");
			return null;
		} else {

			String cadastrados = "Os produtos cadastrados são\n";

			for (Produto produto : produtos) {

				cadastrados += "  * " + produto.getTipoProduto() + "\n";
			}

			return cadastrados;
		}
	}

	protected void editarProduto() {

		String cadastrados = this.selecionaProd();

		if (cadastrados == null) {
			return;
		}

		String produtoEditado = JOptionPane.showInputDialog("Escolha o nome do produto a ser editado\n" + cadastrados);

		Produto prodTemp = new Produto(produtoEditado, "0");

		for (Produto produto : produtos) {

			if (produto.equals(prodTemp)) {
				produto.setTipoProduto(JOptionPane.showInputDialog("Insira o novo nome do produto"));
				produto.setQuantidade(JOptionPane.showInputDialog("Insira a nova quantidade"));
			}

		}
		JOptionPane.showMessageDialog(null, "O produto foi alterado com sucesso");
	}

	protected void excluirProduto() {

		String cadastrados = this.selecionaProd();

		if (cadastrados == null) {
			return;
		}

		String produtoErased = JOptionPane.showInputDialog("Escolha produto a ser excluido\n" + cadastrados);

		Produto prodTemp = new Produto(produtoErased, "0");

		for (Produto produto : produtos) {
			if (produto.equals(prodTemp)) {
				try {
					produtos.remove(produto);
					JOptionPane.showMessageDialog(null, "O produto foi excluido com sucesso!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não foi possível excluir este produto");
				}
			}
		}

	}

	protected static List<Produto> getProdutos() {
		return produtos;
	}

	public static void setProdutos(List<Produto> produtos) {
		GerenciadorEstoque.produtos = produtos;
	}

}
