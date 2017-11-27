package exe_1;

import java.util.Scanner;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Agenda<Contato> agenda = new Agenda<>();
		Storage store = new Storage();
		Scanner scan = new Scanner(System.in);

		Integer chose = 0;

		while (true) {
			System.out.println("Bem-vindo ao sistema de cadastro");
			System.out.println("Escolha uma das opções: \n1 - Cadastrar" + "\n2 - Excluir\n3 - Ver contatos\n"
					+ "4 - Editar contato" + "\n5 - Configurações\n6 - Sair");
			chose = scan.nextInt();

			switch (chose) {
			case 1:
				System.out.println("Insira o nome do contato");
				String nome = scan.next();
				System.out.println("Insira o email");
				String email = scan.next();
				System.out.println("Insira o telefone");
				Integer telefone = Integer.parseInt(scan.next());

				agenda.add(new Contato(nome, email, telefone, Agenda.getIdsContato()));

				Agenda.setIdsContato(Agenda.getIdsContato() + 1);

				break;
			case 2:
				System.out.println("Escolha o ID do usuário que será excluido");
				Informacoes.showInformacoes(agenda.getContatos());
				Integer id = Integer.parseInt(scan.next());

				agenda.remove(id);
				break;

			case 3:
				Informacoes.showInformacoes(agenda.getContatos());
				System.out.println("Precione qualquer tecla para continuar");
				scan.nextLine();
				break;

			case 4:
				System.out.println("Escolha o ID ");
				Informacoes.showInformacoes(agenda.getContatos());
				chose = Integer.parseInt(scan.next());

				agenda.remove(chose);

				System.out.println("Insira o novo nome do contato");
				String newName = scan.next();
				System.out.println("Insira o novo email do contato");
				String newEmail = scan.next();
				System.out.println("Insira o novo número");
				Integer newPhone = scan.nextInt();

				agenda.add(new Contato(newName, newEmail, newPhone, chose));
				break;
			case 5:
				System.out.println("Escolha uma opção:\n1 - Salvar dados\n2 - Recuperar dados");
				chose = Integer.parseInt(scan.next());

				if (chose == 1) {
					store.save(agenda.getContatos());
				} else if (chose == 2) {
					agenda.setContatos(store.load());
				}
				break;

			case 6:
				System.exit(0);
				break;
			}
		}
	}
}
