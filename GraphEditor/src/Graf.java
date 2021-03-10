import java.util.HashMap;
import java.util.Map;

public class Graf {
	
	private int stevec; //samo znotraj tega clasa
	protected Map<String, Tocka> tocke;
	
	public Graf() {
		stevec = 0;
		tocke = new HashMap<String, Tocka>();
	}
	
	public Tocka tocka(String ime) {
		return tocke.get(ime);
	}
	
	public boolean povezava(Tocka v, Tocka u) {
		return v.sosedi.contains(u);
	}
	
	public Tocka dodajTocko(String ime) {
		Tocka v = tocka(ime); // če še ni v grafu vrne null
		if(v == null) {
			v = new Tocka(ime);
			tocke.put(ime, v);
		}
		return v;
	}
	
	public  Tocka dodajTocko() {
		while (true) {
			String ime = Integer.toString(++stevec);
			if (tocka(ime) != null) continue; // že obstaja taka točka
			Tocka v = new Tocka(ime);
			tocke.put(ime, v);
			return v;
		}
	}
	
	public void dodajPovezavo(Tocka v, Tocka u) {
		if (v == u ) return;
		v.sosedi.add(u);
		u.sosedi.add(v);
	}
	
	public void odstraniPovezavo(Tocka v, Tocka u) {
		v.sosedi.remove(u);
		u.sosedi.remove(v);
	}
	
	public void odstraniTocko(Tocka v) {
		for (Tocka u : v.sosedi) u.sosedi.remove(v);
		tocke.remove(v.ime);
	}
	
	private Tocka[] dodajTocke(int n) {
		Tocka[] tab = new Tocka[n];
		for(int i = 0 ; i<n ; ++i) tab[i] = dodajTocko();
		return tab;
	}
	
	public static Graf prazen(int n) {
		Graf graf = new Graf();
		graf.dodajTocke(n);
		return graf;		
	}
	
	public static Graf cikel(int n) {
		Graf graf = new Graf();
		Tocka[] tab = graf.dodajTocke(n);
		for (int i = 0; i<n; i++) graf.dodajPovezavo(tab[i], tab[(i+1) % n]);
		return graf;		
	}
	
	public static Graf poln(int n){
		Graf graf = new Graf();
		Tocka[] tab = graf.dodajTocke(n);
		for (int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
			graf.dodajPovezavo(tab[i], tab[j]);	
			}
		}
		return graf;
	}
	
	public static Graf polnDvodelen(int n, int m){ // dopolni
		Graf graf = new Graf();
		Tocka[] tab1 = graf.dodajTocke(n);
		Tocka[] tab2 = graf.dodajTocke(m);
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
			graf.dodajPovezavo(tab1[i], tab2[j]);	
			}
		}
		return graf;
	}
	
	public void izpis() {
		for (Tocka v : this.tocke.values()) {
			System.out.print(v + ":");
			for (Tocka u : v.sosedi) System.out.print(" " + u);
			System.out.println();
		}
		
	}
	
	public void razporedi(double x, double y, double r) {
		int n = tocke.size();
		int i = 0;
		for (Tocka v: this.tocke.values()) {
			v.x = x + r * Math.cos(2 * i * Math.PI / n);
			v.y = y + r * Math.sin(2 * i * Math.PI / n);
			++i;
		}
		
	}

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
