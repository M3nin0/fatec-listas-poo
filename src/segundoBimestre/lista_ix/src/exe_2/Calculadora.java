package exe_2;

public class Calculadora {
	public static Double soma(Double numUm, Double numDois) {
		return numUm + numDois;
	}

	public static Double divide(Double numUm, Double numDois) {
		try {
			return numUm / numDois;
		} catch (ArithmeticException e) {
			return 0.0;
		}
	}

	public static Double multiple(Double numUm, Double numDois) {
		return numUm * numDois;
	}

	public static Double subtrai(Double numUm, Double numDois) {
		return numUm - numDois;
	}
}
