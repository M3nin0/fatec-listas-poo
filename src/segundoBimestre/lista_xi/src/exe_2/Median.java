package exe_2;

public class Median {
	protected static Integer equilibrium(int[] a) {

		int equilibrioUm = 0;
		int equilibrioDois = 0;

		for (int i = 0; i < a.length; i++) {
			equilibrioUm = 0;
			equilibrioDois = 0;

			for (int j = 0; j <= a.length / 2; j++) {
				if (!(a[i] == a[j])) {
					equilibrioUm += a[j];
				}
			}
			for (int x = a.length / 2; x < a.length; x++) {
				if (!(a[i] == a[x])) {
					equilibrioDois += a[x];
				}
			}
	
			if (equilibrioUm == equilibrioDois)
				return a[i];
		}		
		return -1;
	}
}
