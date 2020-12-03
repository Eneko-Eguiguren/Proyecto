package interfazUsuario;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datos.Main;

public class Principal extends JFrame {
	Color color = new Color(200,180,150);
	public Principal() {
		//
		this.setTitle("History Football");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBounds(180, 30, 1000, 700);
		//
		JPanel p = new JPanel();
		
		JLabel icon = new JLabel(new ImageIcon("src/images/icono7.png"));
		JComboBox<String> anyos = new JComboBox<String>();
		for (int i = 1950; i < 2020; i++) {
			String numero = String.valueOf(i);
			anyos.addItem(numero);
		
		
		
		icon.setBounds(-10, -5, 100, 100);
		
		anyos.setBounds(1270,0,100,75);
	
		anyos.setBackground(color.BLACK);
		anyos.setForeground(color.WHITE);
		p.setLayout(null);
		//
		this.add(p);
		p.add(icon);
	
		p.add(anyos);
		//
		this.setVisible(true);
	}
	
	
}	public static void main(String[] args) {
	new Principal();
	
}}
