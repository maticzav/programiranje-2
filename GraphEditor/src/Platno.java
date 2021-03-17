import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	protected Graf graf;

	protected Color barvaPovezave;
	protected Color barvaTocke;
	protected Color barvaRobaTocke;
	protected Color barvaIzbraneTocke;
	protected Color barvaAktivneTocke;

	protected float debelinaPovezave;
	protected int debelinaRobaTocke;
	protected int polmerTocke;

	protected Tocka aktivnaTocka;
	protected Set<Tocka> izbraneTocke;

	public Platno(int sirina, int visina) {
		super();

		graf = null;

		this.setPreferredSize(new Dimension(sirina, visina));

		this.barvaPovezave = Color.black;
		this.barvaTocke = Color.white;
		this.barvaRobaTocke = Color.black;
		this.barvaIzbraneTocke = Color.red;
		this.barvaAktivneTocke = Color.green;

		this.debelinaPovezave = 1;
		this.debelinaRobaTocke = 1;
		this.polmerTocke = 5;

		this.aktivnaTocka = null;
		this.izbraneTocke = new HashSet<Tocka>();

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);

		this.setFocusable(true);
	}

	public void nastaviGraf(Graf graf) {
		this.graf = graf;
		this.repaint();
	}

	private static int round(double x) {
		return (int) (x + 0.5);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (graf == null)
			return;

		// Nariši graf.
		Graphics2D g2D = (Graphics2D) g;

		// Nariši povezave.
		g2D.setColor(this.barvaPovezave);
		g2D.setStroke(new BasicStroke(this.debelinaPovezave));

		for (Tocka tocka : this.graf.tocke.values()) {
			for (Tocka soseda : tocka.sosedi) {
				if (tocka.ime.compareTo(soseda.ime) < 0) {
					g2D.drawLine(round(tocka.x), round(tocka.y), round(soseda.x), round(soseda.y));
				}
			}
		}

		// Nariši točke.
		for (Tocka tocka : this.graf.tocke.values()) {
			int x = round(tocka.x);
			int y = round(tocka.y);

			int r_rob = this.polmerTocke;
			g2D.setColor(this.barvaRobaTocke);
			g2D.fillOval(x - r_rob, y - r_rob, 2 * r_rob, 2 * r_rob);

			int r_tocke = this.polmerTocke - this.debelinaRobaTocke;
			if (this.aktivnaTocka == tocka) {
				g2D.setColor(this.barvaAktivneTocke);
			} else if (this.izbraneTocke.contains(tocka)) {
				g2D.setColor(this.barvaIzbraneTocke);
			} else {
				g2D.setColor(this.barvaTocke);
			}
			g2D.fillOval(x - r_tocke, y - r_tocke, 2 * r_tocke, 2 * r_tocke);
		}

	}

	private int prejsnjiX;
	private int prejsnjiY;

	private int zacetniX;
	private int zacetniY;

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		// Naredimo premik.
		int dx = x - this.prejsnjiX;
		int dy = y - this.prejsnjiY;

		if (this.aktivnaTocka == null) {
			// Premaknemo izbrane točke.
			for (Tocka tocka : this.izbraneTocke) {
				tocka.x += dx;
				tocka.y += dy;
			}
		} else {
			// Premaknemo aktivno točko.
			this.aktivnaTocka.x += dx;
			this.aktivnaTocka.y += dy;
		}

		// Popravimo prejšnje vrednosti.
		this.prejsnjiX = x;
		this.prejsnjiY = y;

		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		// Poiščemo najbližjo
		Tocka najblizja = null;
		double oddaljenostNajblizje = Double.POSITIVE_INFINITY;

		for (Tocka tocka : this.graf.tocke.values()) {
			int dx = x - round(tocka.x);
			int dy = y - round(tocka.y);

			double oddaljenost = Math.sqrt(dx * dx + dy * dy);
			double threshold = this.polmerTocke + 10;

			if (oddaljenost < threshold && oddaljenost < oddaljenostNajblizje) {
				najblizja = tocka;
				oddaljenostNajblizje = oddaljenost;
			}
		}

		// Nastavimo začeto pozicijo miske.
		this.prejsnjiX = x;
		this.prejsnjiY = y;

		this.zacetniX = x;
		this.zacetniY = y;

		// Nastavimo aktivno točko.
		if (najblizja == null) {
			Tocka tocka = this.graf.dodajTocko();

			for (Tocka izbrana : this.izbraneTocke) {
				this.graf.dodajPovezavo(izbrana, tocka);
			}

			tocka.x = x;
			tocka.y = y;

			najblizja = tocka;
		}

		this.aktivnaTocka = najblizja;

		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int dx = x - this.zacetniX;
		int dy = y - this.zacetniY;

		double oddaljenost = Math.sqrt(dx * dx + dy * dy);

//		double threshold = this.polmerTocke + 10;
		double threshold = 4;

		if (oddaljenost <= threshold) {
			if (this.izbraneTocke.contains(this.aktivnaTocka)) {
				this.izbraneTocke.remove(this.aktivnaTocka);
			} else {
				this.izbraneTocke.add(this.aktivnaTocka);
			}

		}

		// Sprostimo točko.
		this.aktivnaTocka = null;

		// Narišemo še enkrat.
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
