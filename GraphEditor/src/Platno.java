import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	 protected Graf graf;
	 
	 public Platno(int sirina, int visina) {
		 super();
		 
		 graf = null;
		 
		 this.setPreferredSize(new Dimension(sirina, visina));
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
	 }
}
