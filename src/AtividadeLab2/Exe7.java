package br.edu.AtividadeLab2;

import javax.swing.JOptionPane;

public class Exe7 {
		
	public static void main(String[] args) {
		
		String value;
		int horas, bonus;
		double vHora, vTotal;
		
		JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema do empregado");
		
		value = JOptionPane.showInputDialog("Insira a quantidade de horas trabalhadas");
		horas = Integer.parseInt(value);
		
		value = JOptionPane.showInputDialog("Insira o valor da hora");
		vHora = Double.parseDouble(value);
		
		if(horas > 40) {
			
			bonus = horas - 40;
			
			vTotal = vHora * 40;
			
			vTotal += (vHora * 0.5 ) * bonus ;
			
		} else {
			
			vTotal = vHora * horas;
		}
		
		JOptionPane.showMessageDialog(null, String.format("Seu salario esse mes foi %.2f", vTotal));
		
	}

}
