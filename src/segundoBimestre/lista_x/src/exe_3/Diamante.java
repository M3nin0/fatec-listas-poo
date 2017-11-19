package exe_3;

public class Diamante {
	private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String letras[];
	private String espacos;

	public Diamante() {
		letras = alfabeto.split("");
		espacos = "";
	}

	public void fazDiamante(String fim) {

		fim = fim.toUpperCase();
		StringBuilder sb = new StringBuilder();

		int contador = 1;
		sb.append("A\n");
		while (contador <= letras.length) {

			sb.append((letras[contador] + espacos + letras[contador]) + "\n");
			espacos += " ";
			

			if ((letras[contador].equals(fim)))
				break;
			contador++;

		}

		System.out.print(sb.toString().replace(fim, "").trim());
		System.out.println(sb.reverse().toString());

	}

}
