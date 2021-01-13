package interfazGrafica;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	Color color = new Color(200,180,150);
	Font f = new Font("arial",1,16);
	public MenuPrincipal() {
		this.setTitle("History Football");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(180, 30, 1000, 700);
		
		JMenuBar mBar = new JMenuBar();
		JMenu miCuenta = new JMenu();
		JMenu space = new JMenu("                                  ");
		JMenu space2 = new JMenu("                                  ");
		JMenu space3 = new JMenu("                                  ");
		JMenu space4 = new JMenu("                                  ");
		JMenu space5 = new JMenu("                                  ");
		JMenu addFavoritos = new JMenu();
		JMenu misCompeticiones = new JMenu();
		JMenu misEquipos = new JMenu();
		JMenu settings = new JMenu();
		JMenu lineas = new JMenu();
		JMenuItem addTeams = new JMenuItem("Añadir equipos", new ImageIcon("src/images/anyadir.png"));
		JMenuItem addCompetitions = new JMenuItem("Añadir competiciones", new ImageIcon("src/images/anyadir.png"));
		JMenuItem favoriteTeams = new JMenuItem("Mis equipos favoritos", new ImageIcon("src/images/fav2.png"));
		JMenuItem favoriteCompetitions = new JMenuItem("Mis competiciones favoritas", new ImageIcon("src/images/fav2.png"));
		//
		mBar.setBackground(color);
		space.setEnabled(false);
		space2.setEnabled(false);
		space3.setEnabled(false);
		space4.setEnabled(false);
		space5.setEnabled(false);
		misCompeticiones.setIcon(new ImageIcon("src/images/copa.png"));
		misEquipos.setIcon(new ImageIcon("src/images/escudo.png"));
		addFavoritos.setIcon(new ImageIcon("src/images/fav1.png"));
		miCuenta.setIcon(new ImageIcon("src/images/user.png"));
		lineas.setIcon(new ImageIcon("src/images/menu.png"));
		settings.setIcon(new ImageIcon("src/images/setting.png"));
		mBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		addTeams.setFont(f);
		addCompetitions.setFont(f);
		favoriteTeams.setFont(f);
		favoriteCompetitions.setFont(f);
		
		//
		this.setJMenuBar(mBar);
		mBar.add(lineas);
		mBar.add(space);
		mBar.add(addFavoritos);
		mBar.add(space3);
		mBar.add(misCompeticiones);
		mBar.add(space5);
		mBar.add(misEquipos);
		mBar.add(space4);
		mBar.add(settings);
		mBar.add(space2);
		mBar.add(miCuenta);
		
		addFavoritos.add(addTeams);
		addFavoritos.add(addCompetitions);
		misEquipos.add(favoriteTeams);
		misCompeticiones.add(favoriteCompetitions);
		//
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MenuPrincipal();
	}
}
