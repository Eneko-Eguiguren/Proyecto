package interfazUsuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

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
		JPanel pSuperior = new JPanel();
		JButton equiposFav = new JButton(new ImageIcon("src/images/escudo.png"));
		JButton competicionesFav = new JButton(new ImageIcon("src/images/copa.png"));
		JButton selecUsuarios = new JButton(new ImageIcon("src/images/user.png"));
		JButton icon = new JButton(new ImageIcon("src/images/lineas.png"));
		JButton anyadirFavs = new JButton(new ImageIcon("src/images/fav3.png"));
		JComboBox<String> anyos = new JComboBox<String>();
		for (int i = 1950; i < 2020; i++) {
			String numero = String.valueOf(i);
			anyos.addItem(numero);
		
		
		pSuperior.setBounds(0, 0, 1800, 100);
		icon.setBounds(0, 0, 100, 100);
		anyadirFavs.setBounds(943, 0, 100, 100);
		equiposFav.setBounds(626, 0, 100, 100);
		competicionesFav.setBounds(309, 0, 100, 100);
		selecUsuarios.setBounds(1260, 0, 100, 100);

		pSuperior.setBackground(color);
		equiposFav.setBackground(color);
		selecUsuarios.setBackground(color);
		competicionesFav.setBackground(color);
		icon.setBackground(color);
		anyadirFavs.setBackground(color);
		anyadirFavs.setBorderPainted(false);
		selecUsuarios.setBorderPainted(false);
		equiposFav.setBorderPainted(false);
		competicionesFav.setBorderPainted(false);
		p.setLayout(null);
		pSuperior.setLayout(null);
		
		anyadirFavs.setToolTipText("Añadir Jugadores/Competiciones favoritos.");
		selecUsuarios.setToolTipText("Selecciona otro usuario.");
		competicionesFav.setToolTipText("Ver tus competiciones favoritas.");
		equiposFav.setToolTipText("Ver tus equipos favoritos.");
		UIManager.put("ToolTip.background", new ColorUIResource(0, 0, 0));
		UIManager.put("ToolTip.foreground", color);
		//
		this.add(p);
		p.add(pSuperior);
		pSuperior.add(icon);
		pSuperior.add(anyadirFavs);
		pSuperior.add(equiposFav);
		pSuperior.add(selecUsuarios);
		pSuperior.add(competicionesFav);
		//p.add(anyos);
		//
		icon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel opciones = new JPanel();
				JButton atras = new JButton("atras");
				p.add(opciones);
				p.add(atras);
				opciones.setBounds(0, 100, 300, 1000);
				atras.setBounds(0, 100, 300, 40);
				opciones.setBackground(Color.BLACK);
				atras.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						opciones.setVisible(false);
						atras.setVisible(false);
						
						
					}
				});
//				icon.setIcon(new ImageIcon());
//				icon.setBackground(color.BLACK);
//				icon.setBorderPainted(false);
			}
		});
		this.setVisible(true);
	}
	
	
}	public static void main(String[] args) {
	new Principal();
	
}}
