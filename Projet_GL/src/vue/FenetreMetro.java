package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modele.Chemin;
import modele.Ligne;
import modele.Metro;
import modele.Station;

public class FenetreMetro extends JPanel implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;

	private final int TAILLE_CERCLE = 16;
	private final String INFO_DUREE = "Dur�e du voyage : ";
	private final String INFO_CHANGEMENT = "Nombre de changement : ";
	
	private int abscisse_user;
	private int ordonnee_user;
	
	private boolean depart_choisit;
	private boolean arrivee_choisit;
	private boolean chemin_court_choisit;
	private boolean chemin_moins_changement_choisit;
	
	private Station depart;
	private Station arrivee;
	
	private Metro metro;
	private JFrame fenetre;
	private JButton quitter;
	private JButton nouveau;
	private JButton chemin_plus_court;
	private JButton chemin_moins_chang;
	private JLabel label_affichage_depart;
	private JLabel label_affichage_arrivee;
	
	private JLabel label_info_duree;
	private JLabel label_info_chemin_moins_changement;
	
	//un soucis plus on clique plus il y a le bouton quitter qui s'ajoute
	//ca doit venir du faite que c'est le constructeur ?
	public FenetreMetro(Metro metro){
		if(metro != null){
			this.metro = metro;
		}
		depart = null;
		arrivee = null;
		abscisse_user = -1;
		ordonnee_user = -1;
		depart_choisit = false;
		arrivee_choisit = false;
		chemin_court_choisit = false;
		chemin_moins_changement_choisit = false;
		this.setLayout(null);
		this.addMouseListener(this);
		Font police = new Font("Tekton Pro", Font.BOLD, 18);
		
		//bouton quitter
		quitter = new JButton("Quitter");
		quitter.setToolTipText("quitter l'application");
		quitter.addActionListener(this);
		quitter.setFont(police);
		quitter.setForeground(Color.DARK_GRAY);
		quitter.setBounds(0, 0, 100, 30);
		quitter.setFocusPainted(false);
		quitter.setBorderPainted(false);
		quitter.setContentAreaFilled(false);
		this.add(quitter);

		//bouton nouveau
		nouveau = new JButton("<html>Nouveau<br>Chemin</html>");
		nouveau.setToolTipText("chercher un nouveau chemin");
		nouveau.addActionListener(this);
		nouveau.addMouseListener(this);
		nouveau.setFont(police);
		nouveau.setForeground(Color.DARK_GRAY);
		nouveau.setBounds(100, 0, 100, 40);
		nouveau.setFocusPainted(false);
		nouveau.setBorderPainted(false);
		nouveau.setContentAreaFilled(false);
		nouveau.setVisible(false);
		this.add(nouveau);
		
		//affichage centrale
		label_affichage_depart = new JLabel();
		label_affichage_depart.setFont(police);
		label_affichage_depart.setForeground(Color.DARK_GRAY);
		label_affichage_depart.setBounds(220, 0, 400, 30);
		this.add(label_affichage_depart);
		label_affichage_arrivee = new JLabel();
		label_affichage_arrivee.setFont(police);
		label_affichage_arrivee.setForeground(Color.DARK_GRAY);
		label_affichage_arrivee.setBounds(220, 20, 400, 30);
		this.add(label_affichage_arrivee);
		
		//boutons chemins
		chemin_plus_court = new JButton("Chemin plus court");
		chemin_plus_court.setToolTipText("pour trouver le chemin le plus rapide entre d�part/arriv�e");
		chemin_plus_court.addActionListener(this);
		chemin_plus_court.addMouseListener(this);
		chemin_plus_court.setFont(police);
		chemin_plus_court.setForeground(Color.DARK_GRAY);
		chemin_plus_court.setBounds(600, 0, 200, 25);
		chemin_plus_court.setFocusPainted(false);
		chemin_plus_court.setBorderPainted(false);
		chemin_plus_court.setContentAreaFilled(false);
		chemin_plus_court.setVisible(false);
		this.add(chemin_plus_court);
		chemin_moins_chang = new JButton("Chemin moins de changement");
		chemin_moins_chang.setToolTipText("pour trouver avec le moins de changement");
		chemin_moins_chang.addActionListener(this);
		chemin_moins_chang.addMouseListener(this);
		chemin_moins_chang.setFont(police);
		chemin_moins_chang.setForeground(Color.DARK_GRAY);
		chemin_moins_chang.setBounds(590, 20, 300, 30);
		chemin_moins_chang.setFocusPainted(false);
		chemin_moins_chang.setBorderPainted(false);
		chemin_moins_chang.setContentAreaFilled(false);
		chemin_moins_chang.setVisible(false);
		this.add(chemin_moins_chang);
		
		//JLable information
		label_info_duree = new JLabel(INFO_DUREE);
		label_info_duree.setFont(police);
		label_info_duree.setForeground(Color.DARK_GRAY);
		label_info_duree.setBounds(20, 480, 200, 30);
		label_info_duree.setVisible(false);
		this.add(label_info_duree);
		label_info_chemin_moins_changement = new JLabel(INFO_CHANGEMENT);
		label_info_chemin_moins_changement.setFont(police);
		label_info_chemin_moins_changement.setForeground(Color.DARK_GRAY);
		label_info_chemin_moins_changement.setBounds(300, 480, 250, 30);
		label_info_chemin_moins_changement.setVisible(false);
		this.add(label_info_chemin_moins_changement);
		
		fenetre = new JFrame();
		fenetre.setContentPane(this);
		fenetre.pack();
		fenetre.setSize(900, 500);
		fenetre.setLocationRelativeTo(fenetre.getParent());
		
		//faire disparaitre tout le contour de la fenetre
		fenetre.dispose();
		fenetre.setUndecorated(true);
		fenetre.setVisible(true);
		
		JOptionPane.showMessageDialog(fenetre, "Veuillez nous indiquer o� vous vous trouvez", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		for(Station s : metro.getStations()) {
			if(s.equals(depart) || s.equals(arrivee)){
				g.setColor(Color.MAGENTA);
				g.fillOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE, TAILLE_CERCLE);
				g.setColor(Color.black);
				g.drawOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE+1, TAILLE_CERCLE+1);
			}else{
				g.setColor(Color.yellow);
				g.fillOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE, TAILLE_CERCLE);
				g.setColor(Color.black);
				g.drawOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE+1, TAILLE_CERCLE+1);
			}
		}
		if(chemin_court_choisit && depart != null && arrivee != null){
			afficherChemin(g);
		}else if(chemin_moins_changement_choisit && depart != null && arrivee != null){
			afficherChemin(g);
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

	public void afficherChemin(Graphics g){
		if(chemin_court_choisit){
			Chemin chemin = metro.getPlusCourtChemin(depart, arrivee);
			label_info_duree.setText(INFO_DUREE+chemin.getDureeChemin());
			label_info_chemin_moins_changement.setText(INFO_CHANGEMENT+chemin.getNbChangement());
			label_info_duree.setVisible(true);
			label_info_chemin_moins_changement.setVisible(true);
			for(Station s : chemin.getChemin()){
				g.setColor(Color.GREEN);
				g.fillOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE, TAILLE_CERCLE);
				g.setColor(Color.black);
				g.drawOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE+1, TAILLE_CERCLE+1);
			}
		}else if(chemin_moins_changement_choisit){
			Chemin chemin = metro.getMoinsChangementChemin(depart, arrivee);
			label_info_duree.setText(INFO_DUREE+chemin.getDureeChemin());
			label_info_chemin_moins_changement.setText(INFO_CHANGEMENT+chemin.getNbChangement());
			label_info_duree.setVisible(true);
			label_info_chemin_moins_changement.setVisible(true);
			for(Station s : chemin.getChemin()){
				g.setColor(Color.BLUE);
				g.fillOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE, TAILLE_CERCLE);
				g.setColor(Color.black);
				g.drawOval(s.getX()-TAILLE_CERCLE/2, s.getY()-TAILLE_CERCLE/2, TAILLE_CERCLE+1, TAILLE_CERCLE+1);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		
		if(obj == quitter){
			System.exit(1);
		}else if(obj == chemin_plus_court){
			chemin_court_choisit = true;
			chemin_moins_changement_choisit = false;
			this.revalidate();
			this.repaint();
		}else if(obj == chemin_moins_chang){
			chemin_court_choisit = false;
			chemin_moins_changement_choisit = true;
			this.revalidate();
			this.repaint();
		}else if(obj == nouveau){
			depart = null;
			arrivee = null;
			chemin_court_choisit = false;
			chemin_moins_changement_choisit = false;
			depart_choisit = false;
			arrivee_choisit = false;
			chemin_moins_chang.setVisible(false);
			chemin_plus_court.setVisible(false);
			abscisse_user = -1;
			ordonnee_user = -1;
			label_affichage_depart.setText("");
			label_affichage_arrivee.setText("");
			label_info_duree.setText("");
			label_info_chemin_moins_changement.setText("");
			label_info_duree.setVisible(false);
			label_info_chemin_moins_changement.setVisible(false);
			this.revalidate();
			this.repaint();
			fenetre.setSize(900, 510);
			fenetre.setSize(900, 500);
			JOptionPane.showMessageDialog(fenetre, "Veuillez nous indiquer o� vous vous trouvez", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		//solution trouve pour le probleme de rafraichissement
		this.revalidate();
		this.repaint();
		fenetre.setSize(900, 510);
		fenetre.setSize(900, 500);
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		//soucis avec recrassement du texte
		if(arg0.getButton() == MouseEvent.BUTTON1){
			if(!depart_choisit && !arrivee_choisit){
				abscisse_user = arg0.getX();
				ordonnee_user = arg0.getY();
				depart = metro.rechercheProcheStation(abscisse_user, ordonnee_user);
				label_affichage_depart.setText("Votre station de d�part : "+depart.getNom());
				label_affichage_depart.setToolTipText("Coordonn�e : "+abscisse_user+"x"+ordonnee_user);
				JOptionPane.showMessageDialog(fenetre, "Veuillez nous indiquer o� vous voulez vous rendre", "Information", JOptionPane.INFORMATION_MESSAGE);
				depart_choisit = true;
				this.revalidate();
				this.repaint();
			}else if(depart_choisit && !arrivee_choisit){
				abscisse_user = arg0.getX();
				ordonnee_user = arg0.getY();
				arrivee = metro.rechercheProcheStation(abscisse_user, ordonnee_user);
				label_affichage_arrivee.setText("Votre station d'arriv�e : "+arrivee.getNom());
				label_affichage_depart.setToolTipText("Coordonn�e : "+abscisse_user+"x"+ordonnee_user);
				arrivee_choisit = true;
				chemin_moins_chang.setVisible(true);
				chemin_plus_court.setVisible(true);
				nouveau.setVisible(true);
				this.revalidate();
				this.repaint();
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}