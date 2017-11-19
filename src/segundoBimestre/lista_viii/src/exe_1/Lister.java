package exe_1;

/*
 * Aviso:
 * Caso o programa seja executado no Linux é necessário faze-lo em modo root
 * caso contrário há diretórios que não permitirão o acesso
 */

import java.io.File;

public class Lister {

	public void listFiles() {

		File files = new File("/");
		for (File results : files.listFiles()) {
			if (results.isDirectory()) {
				System.out.println("Diretório: " + results.getName());
				listSubDir(results.getAbsolutePath());
			} else if (results.isFile()) {
				System.out.println("Arquivo: " + results.getName());
			}
		}
	}
	// Método recursivo para percorrer todos os arquivos
	public void listSubDir(String path) {
		File file = new File(path);
		for (File results : file.listFiles()) {
			if (results.isDirectory()) {
				System.out.println("Diretório: " + results.getName());
				listSubDir(results.getAbsolutePath());
			} else if (results.isFile()) {
				System.out.println("Arquivo: " + results.getName());
			}
		}
	}
}
