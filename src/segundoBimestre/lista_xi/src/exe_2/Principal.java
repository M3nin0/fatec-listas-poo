package exe_2;

public class Principal {
	public static void main(String[] args) { 
		
		int[] a = new int[10];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = i * 2;
		}
		
		Median.equilibrium(a);
	}
}
