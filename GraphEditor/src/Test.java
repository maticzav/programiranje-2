
public class Test {

	public static void main(String[] args) {
		
		Graf graf = Graf.poln(10);
		
		graf.razporedi(400, 400, 350);
		
		Okno okno = new Okno("Test");
		
		okno.pack();
		okno.setVisible(true);
		
		okno.platno.nastaviGraf(graf);
	}

}
