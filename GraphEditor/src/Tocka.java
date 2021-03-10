import java.util.HashSet;

public class Tocka {
	protected String ime;
	protected HashSet<Tocka> sosedi;
	
	double x;
	double y;
	
	public Tocka (String ime) {
		this.ime = ime;
		this.x = 0;
		this.y = 0;
	}
	
	public int stopnja() {
		return this.sosedi.size();
	}
	
	@Override
	public String toString() {
		return this.ime;
	}
}