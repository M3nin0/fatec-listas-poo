package exe_3;

public class Diamante {
	private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String letras[];

	public Diamante() {
		letras = alfabeto.split("");
		// espacos = new StringBuilder();
	}

	private StringBuilder geraEspacos(String fim) {

		StringBuilder espacos = new StringBuilder();

		int contador = 0;
		while (true) {
			espacos.append(" ");

			if ((letras[contador].equals(fim)))
				break;
			contador++;
		}

		return espacos;
	}

	public void fazDiamante(String fim) {

		fim = fim.toUpperCase();

		StringBuilder espacos = geraEspacos(fim);
		StringBuilder linhas = new StringBuilder();

		int contador = 0;
		String espacoLinha = "";
				
		while (true) {
			linhas.append(espacos.toString() + letras[contador] + espacoLinha + espacoLinha + letras[contador] + "\n");
			
			espacoLinha += " ";
	
			espacos.deleteCharAt(espacos.length() - 1);

			if (letras[contador].equals(fim))
				break;
			contador += 1;
		}
		
		System.out.print(linhas.toString().replace("AA", "A"));
		String[] rows = linhas.toString().split("\n");

		for (int i = rows.length - 2; i >= 0; i--) {
			
			if (i == 0) {
				System.out.println(rows[i].replace("AA", "A"));
				break;
			}	
			System.out.println(rows[i]);
		}
	}
}
