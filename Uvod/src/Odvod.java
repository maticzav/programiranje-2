
public class Odvod {

	public static void main(String[] args) {
		double[] p1 = {1, 2, 3};
		double[] p2 = {4, -1, 2, 0, 1};
		
		double[] op1 = odvod(p1);
		double[] op2 = odvod(p2, 2);

		izpis(op1);
		izpis(op2);
	}
	
	public static double[] odvod(double []p) {
		return odvod(p, 1);
	}
	
	// Vrne odvod polinom predstavljenega s tabelo
	// koeficientov, pri čimer je prvi element tabele
	// prosti člen.
	public static double[] odvod(double [] p, int n) {
		// Ničelni odvodi.
		if (n >= p.length) return new double[0];
		
		// Izračunamo odvod polinoma.
		double[] op = new double[p.length - n];
		
		int f = 1;
		for (int i = 2; i <= n; ++i) f *= i;
		for (int i = n; i < p.length; ++i) {
			op[i - n] = f * p[i];
			f /= i - n + 1;
			f *= i + 1;
		}
		
		return op;
	}
		
	// Izpiše polinom.
	public static void izpis(double[] p) {
		System.out.print('{');
		
		for (int i = 0; i < p.length; ++i) {
			 if (i > 0) System.out.print(", ");
			 System.out.print(p[i]);
		}
		
		System.out.println('}');
	}

}
