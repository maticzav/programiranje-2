
public class Ena {

	public static void main(String[] args) {
		
		// Nastavitve.
		final int N = 10;
		
		// Algoritem. Vedno začnemo z "1".
		String[] tabela = new String[N];
		tabela[0] = "1";
		
		System.out.println(tabela[0]);
		
		for (int i = 1; i < N; i++) {
			tabela[i] = naslednji(tabela[i - 1]);
			System.out.println(tabela[i]);
		}
	}
	
	private static String naslednji(String prejsnji) {
		// Obdelamo podatke.
		char[] znaki = prejsnji.toCharArray();
		
		// Pripravimo spremenljivke, začnemo s prvim znakom.
		char znak = znaki[0];
		int n = 1;
		String niz = "";
		
		// Obdelamo vse nize.
		for (int i = 1; i < znaki.length; i++) {
			if (znaki[i] == znak) n++;
			else {
				niz += Integer.toString(n);
				niz += znak;
				
				// Ponastavimo začetne vrednosti.
				n = 1;
				znak = znaki[i];
			}
		}
		
		// Dodamo še zadnji znak.
		niz += Integer.toString(n);
		niz += znak;
		
		return niz;
	}

}
