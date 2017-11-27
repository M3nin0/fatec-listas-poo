package exe_1;

public class Informacoes {

	public static void showInformacoes(Object[] contatos) {

		for (int i = 0; i < contatos.length; i++) {

			if (!(contatos[i] instanceof Contato))
				continue;

			Contato temp = (Contato) contatos[i];
			System.out.println("ID: " + temp.getId() + "\nNome: " + temp.getNome() + "\nEmail: " + temp.getEmail()
					+ "\nTelefone: " + temp.getTelefone());
			System.out.println("========\n");
		}
	}
}
