package exe_1;

public class Agenda<T> {

	private T[] contatos;
	private static Integer index = 0;
	private static Integer idsContato;

	@SuppressWarnings("unchecked")
	public Agenda() {
		contatos = (T[]) new Contato[10];
		idsContato = 0;
	}

	public void add(T t) {
		try {
			// Thread sem referência, isso porque ela apenas fará a adição
			// não realizando processos continuos (Não sendo necessário seu controle) 
			new Thread() {
				public void run() {
					for (int i = 0; i < contatos.length; i++) {
						if (contatos[i] == null) {
							contatos[i] = t;
							index += 1;
							break;
						}
					}
				}
			}.start();
		} catch (Exception e) {
			System.out.println("Erro ao iniciar a thread de adição de contatos");
		}
	}

	public void remove(int id) {
		new Thread() {
			public void run() {
				for (int i = 0; i < contatos.length; i++) {
					Contato temp = (Contato) contatos[i];
					if (temp.getId() == id) {
						contatos[i] = null;
						index += 1;
						break;
					}
				}
			}
		}.start();
	}

	@SuppressWarnings("unchecked")
	public void setContatos(Object[] contatos) {
		this.contatos = (T[]) contatos;
	}

	public T[] getContatos() {
		return contatos;
	}

	public int length() {
		return contatos.length;
	}

	public static int getIndex() {
		return index;
	}

	public static Integer getIdsContato() {
		return idsContato;
	}

	public static void setIdsContato(Integer idsContato) {
		Agenda.idsContato = idsContato;
	}

	public void toNull() {
		for (int i = 0; i < contatos.length; i++)
			contatos[i] = null;
	}
}
