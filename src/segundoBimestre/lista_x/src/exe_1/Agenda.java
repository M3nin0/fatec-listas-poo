package exe_1;

import java.util.Arrays;

public class Agenda<T> implements Runnable {

	private T[] contatos;
	private int index = 0;

	@SuppressWarnings("unchecked")
	public Agenda() {
		/*
		 * Crio o objeto do tipo mais genérico possível, após isso faço o casting para o
		 * tipo de T
		 */
		contatos = (T[]) new Object[10];
	}

	public void add(T t) {
//		new Thread() {
//			public void run() {
//				contatos[index] = t;
//				index++;
//			}
//		}.start();
		
		contatos[index] = t;
		index++;
		
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println(contatos[0]);
//		Arrays.sort(contatos);
		System.out.println(contatos[0]);
		int a = Arrays.binarySearch(contatos, 0);
		
//		System.out.println(a);
	}

	public void remove(int id) {	
		new Thread() {
			public void run() { 
				
				System.out.println(contatos[0]);
				
				int a = Arrays.binarySearch(contatos, id);
								
				System.out.println(a);
				
//				contatos[a] = null;
			}
		}.start();
	}

	public T[] getAgenda() {
		return contatos;
	}

	public T getItem() {
		return contatos[0];
	}

	public void run() {

	}

}
