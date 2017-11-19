package exe_2;

import java.util.HashMap;

public class Alfabeto {

	private HashMap<String, Integer> map;
	private int total = 0;

	public Alfabeto() {
		map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("D", 1);
		map.put("O", 1);
		map.put("P", 1);
		map.put("Q", 1);
	}

	public int countBurraco(String texto) {
		String novo[] = texto.toUpperCase().trim().split("");

		for (String letra : novo)
			if (map.containsKey(letra))
				total += map.get(letra);
		return total;
	}

}
