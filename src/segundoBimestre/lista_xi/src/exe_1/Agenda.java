package exe_1;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Agenda<T> implements Serializable {
	private Set<T> objetos;

	public Agenda() {
		objetos = new TreeSet<>();
	}

	public void add(T objeto) {

		if (objetos.contains(objeto)) {
			System.out.println("Usuário já está na agenda");
		} else {
			new Thread() {
				public void run() {
					objetos.add(objeto);
				}
			}.start();
		}
	}

	public void remove(T objeto) {
		new Thread() {
			public void run() {
				objetos.remove(objeto);
			}
		}.start();
	}

	public void listUser() {
		for (T objeto : objetos) {
			System.out.println(objeto);
		}
	}

	public Set<T> getObjetos() {
		return objetos;
	}

	public void setObjetos(Set<T> objetos) {

		if (objetos == null)
			System.out.println("Erro ao importar os dados. Null não pode ser importado");

		this.objetos = objetos;
	}
}
