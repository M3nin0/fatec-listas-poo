package schedule.schedule;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public class Agenda<E> implements Iterable<E>, Serializable {
	private Set<E> objetos;

	public Agenda() {
		objetos = new HashSet<>();
	}

	public void add(E e) {
		objetos.add(e);
	}

	public void remove(E e) {
		objetos.remove(e);
	}

	public Set<E> getObjetos() {
		return objetos;
	}

	/*
	 * iterator utilizado por conta da utilização da agenda no for-each. Como esta
	 * virou uma estrutura de dados para armazenar itens é importante que haja o
	 * interable
	 */
	@Override
	public Iterator<E> iterator() {
		return objetos.iterator();
	}
}
