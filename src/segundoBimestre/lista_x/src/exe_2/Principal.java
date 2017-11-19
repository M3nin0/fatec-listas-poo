package exe_2;

public class Principal {
	public static void main(String[] args) {
		Alfabeto alfabeto = new Alfabeto();
		
		int total = alfabeto.countBurraco("Siga o coelho");
		
		System.out.println("O total de burracos é: " + total);
	}
}
