package exe_1;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		String nome = "";
		String email = "";
		Integer telefone = 0;

		Agenda<Contato> agenda = new Agenda<>();
		Save<Contato> save = new Save<>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Bem-vindo a agenda eletrônica");
		while (true) {
			System.out.println("Escolha uma das opções: \n");
			System.out.println("1 - Consultar usuários cadastrados\n"
					+ "2 - Adicionar usuário\n3 - Remover usuário\n4 - Configurações\n5 - Sair");
			Integer choses = scan.nextInt();

			switch (choses) {
			case 1:
				agenda.listUser();
				System.out.println("Precione qualquer tecla para continuar");
				scan.nextLine();
				break;
			case 2:
				System.out.println("Insira um nome");
				nome = scan.next();
				System.out.println("Insira o email");
				email = scan.next();
				System.out.println("Insira o número de telefone");
				telefone = scan.nextInt();
				agenda.add(new Contato(nome, email, telefone));
				break;
			case 3:
				agenda.listUser();
				System.out.println("Insira o nome do contato que será excluido");
				nome = scan.next();
				agenda.remove(new Contato(nome, "", 000));
				break;
			case 4:
				System.out.println("1 - Fazer backup da agenda\n2 - Recuperar backup da agenda");
				choses = scan.nextInt();

				if (choses == 1) {
					save.dumpItens(agenda.getObjetos());
				} else if (choses == 2) {
					agenda.setObjetos(save.reload());
				}
				break;
			case 5:
				System.out.println("Bye");
				System.exit(0);
			}
		}
	}
}
