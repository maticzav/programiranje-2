
public class Poudarek {

	public static void main(String[] args) {
		System.out.println(poudari("Zadnja novica"));
	}
	
	public static String poudari(String niz) {
		String s = "";
		
		for (int i = 0; i < niz.length(); ++i) {
			char znak = niz.charAt(i);
			if (i > 0) s += ' ';
			s += Character.toUpperCase(znak);
		}
		
		return s;
	}

}
