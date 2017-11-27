package exe_2;

public class Principal {
	public static void main(String[] args) {

		int[] a = {-7, 1, 5, 2, -4, 3, 0};
		
		int equilibrio = Median.equilibrium(a);

		if (equilibrio != -1) {
			System.out.println("O equilibrio é " + equilibrio);
		} else
			System.out.println("Não há equilibrio");
	}
}
