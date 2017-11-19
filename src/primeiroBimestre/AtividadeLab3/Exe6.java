package br.edu.AtividadeLab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe6 {

	public static void main(String[] args) {

		ArrayList<Pessoa> cadastrados = new ArrayList<Pessoa>();
		String choose;

		String meses[] = { "__", "Janeiro", "Fevereiro", "Mar�o", "Abrir", "Maio", "Junho", "Julho", "Agosto",
				"Setembro", "Outubro", "Novembro", "Dezembro" };

		int index = 0;
		int sair = 0;
		int bool = 0;

		Scanner s = new Scanner(System.in);

		for (int mes = 1; mes <= 13; mes++) {

			if (mes > 12) {
				mes = 1;
			}

			bool = 0;
			while (sair != 1 && bool == 0) {
				System.out.println("M�s atual: " + meses[mes]);
				System.out.println("Escolha uma op��o:\n" + "1 - Cadastrar cliente\n" + // Checked
						"2 - Editar cliente\n" + // Checked
						"3 - Consultar informa��o de cliente\n" + // Checked
						"4 - Creditar cliente\n" + // Checked
						"5 - Excluir usu�rio\n" + "6 - Fechar m�s\n" + "7 - Sair"); // Checked

				choose = s.next();

				switch (choose) {

				// Cadastrar usu�rio
				case "1":
					System.out.println("Cadastro de usu�rio\nInsira as informa��es do usu�rio\n");
					System.out.println("Nome: ");
					String nome = s.next();
					System.out.println("E-mail");
					String email = s.next();
					System.out.println("Telefone: ");
					String telefone = s.next();
					System.out.println("Endere�o: ");
					String endereco = s.next();

					cadastrados.add(new Pessoa(nome, email, telefone, endereco, index, 0));
					index++;

					break;

				// Editar usuario
				case "2":
					System.out.println("Edi��o de usu�rio\n");

					System.out.println("Escolha o ID do usu�rio que ser� editado: ");

					for (Pessoa p : cadastrados) {

						System.out.println("ID: " + p.getId() + " Nome: " + p.getNome());

					}

					int edit = s.nextInt();

					System.out.println("Qual informa��o deseja editar ?\n - Email \n - Telefone \n - Endere�o");
					choose = s.next();

					if (choose.toLowerCase().equals("email")) {

						Pessoa p = cadastrados.get(edit);

						System.out.println("Insira o novo email: ");
						String mail = s.next();
						p.setEmail(mail);

					} else if (choose.toLowerCase().equals("telefone")) {

						Pessoa p = cadastrados.get(edit);

						System.out.println("Insira o novo telefone: ");
						String phone = s.next();
						p.setEmail(phone);
					}
					break;

				// Consultar usu�rio
				case "3":
					System.out.println("Consulta de informa��es\n");

					System.out.println("Escolha o ID do usu�rio que ser� editado: ");

					for (Pessoa p : cadastrados) {

						System.out.println("ID: " + p.getId() + " Nome: " + p.getNome());

					}
					int search = s.nextInt();

					Pessoa p = cadastrados.get(search);

					System.out.println("Nome: \n" + p.getNome() + "\n" + "Email: \n" + p.getEmail() + "\n"
							+ "Telefone: \n" + p.getTelefone() + "\n" + "Endere�o: \n" + p.getEndereco() + "\n"
							+ "Gastos Mensais: \n" + p.getGastoMes(mes) + "\n" + "Gastos anuais (Ou at� o m�s atual) \n"
							+ p.calculaAno(mes));

					break;

				// Creditar usu�rio
				case "4":
					System.out.println("Creditar cliente\n");

					System.out.println("Escolha o ID do usu�rio que ser� editado: ");

					for (Pessoa p1 : cadastrados) {

						System.out.println("ID: " + p1.getId() + " Nome: " + p1.getNome());

					}
					int credit = s.nextInt();

					System.out.println("Qual valor ser� adicionado ao cliente ?");
					double value = s.nextDouble();

					p = cadastrados.get(credit);

					p.setGasto(value);
					p.setGastoMes(mes);

					break;

				// Excluir usu�rio
				case "5":
					System.out.println("Excluir usu�rio\n");

					System.out.println("Escolha o ID do usu�rio que ser� excluido");

					for (Pessoa p1 : cadastrados) {

						System.out.println("ID: " + p1.getId() + " Nome: " + p1.getNome());

					}
					int exclude = s.nextInt();

					System.out.println(cadastrados.size());

					cadastrados.remove(cadastrados.get(exclude));

					System.out.println("Remo��o feita com sucesso!");

					System.out.println(cadastrados.size());

					break;

				// Fechar m�s
				case "6":
					System.out.println(
							"O m�s foi encerrado! Consulte as informa��es dos clientes para saber seus gastos neste m�s");
					bool = 1;

					break;

				case "7":
					System.out.println("At� mais");
					System.exit(0);

				default:
					System.out.println("Erro! Op��o invalida!");
					break;

				}
			}
		}
		s.close();
	}
}
