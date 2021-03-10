import java.util.HashMap;

public class Graf {
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
//		self.tocke = 
	}

	public void razporedi(double x, double y, double r) {
		int n = this.tocke.size();
		int i = 0;

		for (Tocka tocka : this.tocke.values()) {
			tocka.x = x + r * Math.cos(i * Math.PI / n);
			tocka.y = y + r * Math.sin(i * Math.PI / n);
			i += 1;
		}
	}
}