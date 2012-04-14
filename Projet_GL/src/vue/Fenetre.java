package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Ligne;
import modele.Metro;
import modele.Station;

public class Fenetre extends JPanel {
	
	private Metro metro;
	private final int TAILLE_CERCLE = 16;
	
	public Fenetre(Metro m) {
		if(m != null) metro = m;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(600, 500);
		frame.setContentPane(this);
		frame.setBackground(Color.white);
		frame.setTitle("Metro");
		frame.setLocationRelativeTo(null);
		
		setBackground(Color.white);
		setVisible(true);
		
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		for(Station s : metro.getStations()) {
			g.setColor(Color.yellow);
			g.fillOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE, TAILLE_CERCLE);
			g.setColor(Color.black);
			g.drawOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE+1, TAILLE_CERCLE+1);
		}
		
		for(Ligne ligne : metro.getMetro()) {
			ArrayList<Station> stations = ligne.getStations();
			g.setColor(ligne.getCouleurLigne());
			for(int i = 0; i < stations.size() - 1; i ++) {
				int[] pointx = {stations.get(i).getX()+1, stations.get(i+1).getX()+1, stations.get(i+1).getX()-1, stations.get(i).getX()-1};
				int[] pointy = {stations.get(i).getY()+1, stations.get(i+1).getY()+1, stations.get(i+1).getY()-1, stations.get(i).getY()-1};
				g.fillPolygon(pointx, pointy, 4);
				g.drawLine(stations.get(i).getX(), stations.get(i).getY(), stations.get(i+1).getX(), stations.get(i+1).getY());
			}
		}
	}

}
