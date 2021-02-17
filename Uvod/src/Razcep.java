
public class Razcep {

	public static void main(String[] args) {
		razcep(1024);
		razcep(5761665);
	}
	
	public static void razcep(int n) {
		char op = '=';
		
		System.out.print(n);
		
		for (int d = 2; d <= n; ++d) {
			int e = 0;
			
			while (n % d == 0) {
				n /= d;
				++e;
			}
			
			if (e > 0) {
				System.out.print(" " + op + ' ' + d);
				if (e > 1) System.out.print("^" + e);
				op = '*';
			}
		}
		
		System.out.println();
	}

}
