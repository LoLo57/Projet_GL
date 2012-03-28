import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Recherche extends JFrame {
	
	public static void main(String[] args){
		final String[] stations = {"Gare du nord", "Gare de l'est", "Porte Doree", "Jardin", "Tour Eiffel", "Trocadero"};
		
		Recherche rech = new Recherche();
		JPanel panel = new JPanel();
		final JTextArea textArea = new JTextArea();
		final JComboBox combobox = new JComboBox(stations);
		
		final ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText((String) combobox.getSelectedItem());
			}
		};
		
		combobox.addActionListener(al);
		
		textArea.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {}
			
			public void keyReleased(KeyEvent arg0) {
				combobox.removeActionListener(al);
				combobox.removeAllItems();
				for(String station : stations) {
					if(station.toLowerCase().contains(textArea.getText().toLowerCase())) combobox.addItem(station);
				}
				combobox.addActionListener(al);
			}
			
			public void keyPressed(KeyEvent arg0) {}
		});
		
		panel.setLayout(new GridLayout(2, 1));
		panel.add(textArea);
		panel.add(combobox);
		
		rech.setContentPane(panel);
		rech.setSize(200, 70);
		rech.setVisible(true);
		rech.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}