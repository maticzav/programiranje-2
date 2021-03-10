import java.io.*;

public class Predor {
	
	// Nastavitve
	private static final int OMEJITEV = 80; // v km/h
	private static final int DOLZINA = 622; // v metrih
	private static final String VHODNA = "./podatki.txt";
	private static final String IZHODNA = "./rezultati.txt";
	

	public static void main(String[] args) throws IOException {
		// Spremenljivke.
		BufferedReader in = new BufferedReader(new FileReader(VHODNA));       
		FileWriter out = new FileWriter(IZHODNA);
		
		while(in.ready()) {
			String vrstica = in.readLine().trim();
			
			String podatki[] = vrstica.split("\s+");
			
			// Izlušči podatke o vozniku in izračunaj hitrost.
			int vhod = Integer.valueOf(podatki[0]);
			int izhod = Integer.valueOf(podatki[1]);
			String tablica = podatki[2];
			
			int s = izhod - vhod;
			float ms = s / DOLZINA;
			float kmh = ms * (float) 3.6;
			
			if (kmh > OMEJITEV) {
				String voznik = tablica + " " + kmh + "km/h";
				System.out.print(voznik);
			}
		}

		in.close();
		out.close();
	}
}
