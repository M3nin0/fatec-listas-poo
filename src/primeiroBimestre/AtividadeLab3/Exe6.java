package br.edu.AtividadeLab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe6 {

	public static void main(String[] args) {

		ArrayList<Pessoa> cadastrados = new ArrayList<Pessoa>();
		String choose;

		String meses[] = { "__", "Janeiro", "Fevereiro", "Março", "Abrir", "Maio", "Junho", "Julho", "Agosto",
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
				System.out.println("Mês atual: " + meses[mes]);
				System.out.println("Escolha uma opção:\n" + "1 - Cadastrar cliente\n" + // Checked
						"2 - Editar cliente\n" + // Checked
						"3 - Consultar informação de cliente\n" + // Checked
						"4 - Creditar cliente\n" + // Checked
						"5 - Excluir usuário\n" + "6 - Fechar mês\n" + "7 - Sair"); // Checked

				choose = s.next();

				switch (choose) {

				// Cadastrar usuário
				case "1":
					System.out.println("Cadastro de usuário\nInsira as informações do usuário\n");
					System.out.println("Nome: ");
					String nome = s.next();
					System.out.println("E-mail");
					String email = s.next();
					System.out.println("Telefone: ");
					String telefone = s.next();
					System.out.println("Endereço: ");
					String endereco = s.next();

					cadastrados.add(new Pessoa(nome, email, telefone, endereco, index, 0));
					index++;

					break;

				// Editar usuario
				case "2":
					System.out.println("Edição de usuário\n");

					System.out.println("Escolha o ID do usuário que será editado: ");

					for (Pessoa p : cadastrados) {

						System.out.println("ID: " + p.getId() + " Nome: " + p.getNome());

					}

					int edit = s.nextInt();

					System.out.println("Qual informação deseja editar ?\n - Email \n - Telefone \n - Endereço");
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

				// Consultar usuário
				case "3":
					System.out.println("Consulta de informações\n");

					System.out.println("Escolha o ID do usuário que será editado: ");

					for (Pessoa p : cadastrados) {

						System.out.println("ID: " + p.getId() + " Nome: " + p.getNome());

					}
					int search = s.nextInt();

					Pessoa p = cadastrados.get(search);

					System.out.println("Nome: \n" + p.getNome() + "\n" + "Email: \n" + p.getEmail() + "\n"
							+ "Telefone: \n" + p.getTelefone() + "\n" + "Endereço: \n" + p.getEndereco() + "\n"
							+ "Gastos Mensais: \n" + p.getGastoMes(mes) + "\n" + "Gastos anuais (Ou até o mês atual) \n"
							+ p.calculaAno(mes));

					break;

				// Creditar usuário
				case "4":
					System.out.println("Creditar cliente\n");

					System.out.println("Escolha o ID do usuário que será editado: ");

					for (Pessoa p1 : cadastrados) {

						System.out.println("ID: " + p1.getId() + " Nome: " + p1.getNome());

					}
					int credit = s.nextInt();

					System.out.println("Qual valor será adicionado ao cliente ?");
					double value = s.nextDouble();

					p = cadastrados.get(credit);

					p.setGasto(value);
					p.setGastoMes(mes);

					break;

				// Excluir usuário
				case "5":
					System.out.println("Excluir usuário\n");

					System.out.println("Escolha o ID do usuário que será excluido");

					for (Pessoa p1 : cadastrados) {

						System.out.println("ID: " + p1.getId() + " Nome: " + p1.getNome());

					}
					int exclude = s.nextInt();

					System.out.println(cadastrados.size());

					cadastrados.remove(cadastrados.get(exclude));

					System.out.println("Remoção feita com sucesso!");

					System.out.println(cadastrados.size());

					break;

				// Fechar mês
				case "6":
					System.out.println(
							"O mês foi encerrado! Consulte as informações dos clientes para saber seus gastos neste mês");
					bool = 1;

					break;

				case "7":
					System.out.println("Até mais");
					System.exit(0);

				default:
					System.out.println("Erro! Opção invalida!");
					break;

				}
			}
		}
		s.close();
	}
}
