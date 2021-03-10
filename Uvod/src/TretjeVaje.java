import java.util.*;

public class TretjeVaje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Tocka {
	protected String ime;
	protected HashSet<Tocka> sosedi;
	
	public Tocka (String ime) {
		this.ime = ime;
	}
	
	public int stopnja() {
		return this.sosedi.size();
	}
	
	@Override
	public String toString() {
		return this.ime;
	}
}

class Graf {
	private int stevec;
	protected HashMap<String, Tocka> tocke;
	
	public Graf() {
		this.stevec = 0;
		this.tocke = new HashMap<String, Tocka>();
	}
	
	public Tocka tocka(String ime) {
		if (this.tocke.containsKey(ime)) return this.tocke.get(ime);
		return null;
	}
	
	public boolean povezava(Tocka a, Tocka b) {
		return a.sosedi.contains(b) || b.sosedi.contains(a);
	}
	
	public Tocka dodajTocko(String ime) {
		// Vrni obstoječo.
		if (this.tocke.containsKey(ime)) return this.tocke.get(ime);
		
		// Ustvari novo.
		Tocka tocka = new Tocka(ime);
		this.tocke.put(ime, tocka);
		this.stevec += 1;
		
		return tocka;
	}
	
	public Tocka dodajTocko() {
		return dodajTocko(Integer.toString(stevec));
	}
	
	public void dodajPovezavo(Tocka a, Tocka b) {
		self.tocke = 
	}
}
