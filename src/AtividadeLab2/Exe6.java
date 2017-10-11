package br.edu.AtividadeLab2;

import javax.swing.JOptionPane;

public class Exe6 {
		
	public static void main(String[] args) {
		
		Vendedor vendedor = new Vendedor("Felipe", 12);
		String choose;
		
		JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema de comissões");
		
		do {
			
			choose = JOptionPane.showInputDialog("Escolha uma opção\n" +
			"1 - Adicionar itens vendidos\n"+
			"2 - Calcular salario\n" + 
			"3 - Sair");
			
			switch(choose) {
			
			case "1":
				
				while(true) {
					choose = JOptionPane.showInputDialog("Insira o valor do item vendido");
					vendedor.venderItem(Double.parseDouble(choose));
					
					choose = JOptionPane.showInputDialog("Deseja adicionar mais alguma venda (sim/nao)?");
					
					if(choose.toLowerCase().equals("nao")) {
						break;
					}
				}
				
				break;
			
			case "2":
				
				JOptionPane.showMessageDialog(null, "Seu salário contando apenas com as vendas será de " + vendedor.calculaSalario());
				break;
				
			case "3":
				JOptionPane.showMessageDialog(null, "Até mais, tchau!");
				System.exit(0);
			
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				System.exit(1);
			}

		}while(true);
				
	}
	

}
