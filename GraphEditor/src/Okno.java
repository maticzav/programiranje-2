import javax.swing.JFrame;

public class Okno extends JFrame {
	
	protected Platno platno;
	
	String naslov;
	
	public Okno(String naslov) {
		super();
		
		this.naslov = naslov;
		this.platno = new Platno(800, 800);
		
		this.add(this.platno);
	}
}
