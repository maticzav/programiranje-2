
public class Collatz {

	public static void main(String[] args) {
		System.out.println(dolzina(60));
		System.out.println(najvecji(60));
		izpis(60);
	}
	
//	public static int

	public static int dolzina(int n) {
		int stevec = 1;
		while (n > 1) {
			if (n % 2 == 0) n /= 2;
			else n = 3 * n + 1;
			
			++stevec;
		}
		
		return stevec;
	}
	
	public static  int najvecji(int n) {
		int max = n;
		
		while (n > 1) {
			if (n % 2 == 0) n /= 2;
			else n = 3 * n + 1;
			
			if (n > max) max = n;
		} 
		
		return max;
	}
	
	public static void izpis(int n) {
		System.out.print(n);
		
		while (n > 1) {
			if (n % 2 == 0) n /= 2;
			else n = 3 * n + 1;
			
			System.out.print(" " + n);
		}
	}
}
