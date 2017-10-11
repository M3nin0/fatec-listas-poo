package br.edu.AtividadeLab5;

import java.util.Scanner;

public class Exe2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Agenda agenda = new Agenda();

		int sair = 0;

		System.out.println("Bem-vindo, ao sistema de agenda");

		while (sair != 1) {

			System.out.println("Escolha o que deseja fazer:");
			System.out.println(
					"1 - Cadastrar\n2 - Editar\n3 - Remover\n4 - Listar\n5 - Salvar\n6 - Importar dados\n7 - Sair");
			int escolha = scan.nextInt();

			switch (escolha) {

			case 1:
				agenda.cadastraUsuario();

				break;
			case 2:
				agenda.editaUsuario();

				break;

			case 3:
				agenda.exclui();

				break;

			case 4:
				agenda.listarTodos();

				break;

			case 5:

				agenda.salvar();

				break;

			case 6:

				agenda.lerArquivo();

				break;

			case 7:

				System.out.println("Tchau!");
				scan.close();

				sair = 1;

				break;

			default:
				System.out.println("Opção invalida!");

				break;
			}
		}
	}
}
