import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class PredavanjeIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


abstract class Lik {
	protected double x, y, theta;
	protected Color barva;
	
	public Lik(double x, double y, double theta, Color barva) {
		this.x = x;
		this.y = y;
		this.theta = theta;
		this.barva = barva;
	}
	
	public void premakni(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public void zavrti(double dtheta) {
		this.theta += dtheta;
	}
	
	
	public void setColor(Color barva) {
		this.barva = barva;
	}
	
	public abstract boolean vsebujeTocko(double x, double y);
	public abstract void narisi(Graphics g);
}

class Krog extends Lik {
	private double polmer;
	
	public Krog(double x, double y, Color barva, double polmer) {
		super(x, y, 0.0, barva);
		this.polmer = polmer;
	}

	@Override
	public boolean vsebujeTocko(double x, double y) {
		double dx = x - this.x;
		double dy = y - this.y;
		
		double d = Math.sqrt(dx * dx + dy * dy);
		
		return d <= this.polmer;
	}

	@Override
	public void narisi(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}