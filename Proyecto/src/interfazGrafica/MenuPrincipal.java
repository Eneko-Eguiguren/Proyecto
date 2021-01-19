package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BD.ExtraccionBD;
import datos.Competicion;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	Color color = new Color(200, 180, 150);
	Font f = new Font("arial", 1, 16);

	public MenuPrincipal(String usuarioActual) {
		this.setTitle("History Football");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(180, 30, 1000, 700);
		// MENU
		JMenuBar mBar = new JMenuBar();
		JMenu miCuenta = new JMenu();
		JMenu space = new JMenu("                                      ");
		JMenu space1 = new JMenu("                                      ");
		JMenu space2 = new JMenu("                                      ");
		JMenu space3 = new JMenu("                                      ");
		JMenu space4 = new JMenu("                                      ");
		JMenu space5 = new JMenu("                                      ");
		JMenu addFavoritos = new JMenu();
		JMenu misCompeticiones = new JMenu();
		JMenu settings = new JMenu();
		JMenu allComps = new JMenu();
		JMenuItem addCompetitions = new JMenuItem("Añadir favoritas");
		JMenuItem favoriteCompetitions = new JMenuItem("Mis competiciones favoritas");
		JMenuItem todasLasComps = new JMenuItem("Todas las competiciones.");
		JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
		mBar.setBackground(color);
		space.setEnabled(false);
		space1.setEnabled(false);
		space2.setEnabled(false);
		space3.setEnabled(false);
		space4.setEnabled(false);
		space5.setEnabled(false);
		misCompeticiones.setIcon(new ImageIcon("src/images/fav2.png"));
		addFavoritos.setIcon(new ImageIcon("src/images/fav1.png"));
		miCuenta.setIcon(new ImageIcon("src/images/user.png"));
		allComps.setIcon(new ImageIcon("src/images/copa.png"));
		settings.setIcon(new ImageIcon("src/images/setting.png"));
		cerrarSesion.setIcon(new ImageIcon("src/images/cerrarsesion.png"));
		mBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		addCompetitions.setFont(f);
		favoriteCompetitions.setFont(f);
		todasLasComps.setFont(f);
		cerrarSesion.setFont(f);

		// PANEL CENTRAL
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(null);
		this.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setBackground(color);
		JPanel panelCentralSuperior = new JPanel();
		JPanel panelCentralInferior = new JPanel();
		JLabel todosLosEquipos = new JLabel("Todos los equipos de la competición : ");
		JLabel informacionComp = new JLabel("Infromación de la competición : ");
		JLabel nombreComp = new JLabel("Nombre :  ");
		JLabel anyoComp = new JLabel("Año :  ");
		JLabel paisComp = new JLabel("Pais :  ");
		JLabel campeonComp = new JLabel("Campeón :  ");
		JLabel subcampeonComp = new JLabel("Subcampeón :  ");
		JLabel banderaPais = new JLabel();

		informacionComp.setFont(new Font("arial", 1, 14));
		todosLosEquipos.setFont(new Font("arial", 1, 14));
		panelCentralInferior.setLayout(null);
		panelCentralSuperior.setLayout(null);
		panelCentralSuperior.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCentralInferior.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCentralSuperior.setBounds(20, 20, 740, 150);
		panelCentralInferior.setBounds(20, 190, 740, 390);
		todosLosEquipos.setBounds(230, 10, 300, 20);
		informacionComp.setBounds(245, 10, 300, 20);
		nombreComp.setBounds(10, 50, 250, 20);
		anyoComp.setBounds(285, 50, 250, 20);
		paisComp.setBounds(555, 50, 250, 20);
		campeonComp.setBounds(10, 100, 250, 20);
		subcampeonComp.setBounds(285, 100, 250, 20);
		banderaPais.setBounds(7, -25, 100, 100);
		panelCentralSuperior.setBackground(Color.WHITE);
		panelCentralInferior.setBackground(Color.WHITE);
		// PANEL IZQUIERDA
		JPanel panelLeft = new JPanel();
		panelLeft.setPreferredSize(new Dimension(200, MAXIMIZED_VERT));
		JLabel comps = new JLabel("Todas las competiciones :");
		JPanel panelInferior = new JPanel();
		JPanel panelListaComps = new JPanel();
		JButton buscar = new JButton(new ImageIcon("src/images/buscar.png"));
		JButton buscar2 = new JButton(new ImageIcon("src/images/buscar.png"));
		JButton enter = new JButton(new ImageIcon("src/images/flecha.png"));
		JComboBox<Integer> anyoCombo = new JComboBox<Integer>();
		for (int i = 2020; i > 1950; i--) {
			anyoCombo.addItem(i);
		}
		JList<String> list = new JList<String>();
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new MiCellRenderer());
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLeft.setLayout(null);
		anyoCombo.setBounds(0, 30, 150, 50);
		buscar.setBounds(150, 30, 50, 50);
		buscar2.setBounds(3000, 3000, 0, 0);
		buscar.setBackground(Color.WHITE);
		anyoCombo.setBackground(Color.WHITE);
		comps.setBounds(0, 0, 200, 30);
		panelListaComps.setLayout(new BorderLayout());
		panelListaComps.setBounds(10, 85, 180, 450);
		scrollPane.setBounds(0, 0, 180, 500);
		enter.setBounds(10, 530, 180, 50);
		enter.setBackground(Color.WHITE);
		panelLeft.setBackground(color);

		// PANEL INFERIOR
		JLabel uActual = new JLabel("Usuario actual :     " + usuarioActual);
		panelInferior.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 30));

		// ADDS
		this.setJMenuBar(mBar);
		mBar.add(space1);
		mBar.add(allComps);
		mBar.add(space);
		mBar.add(addFavoritos);
		mBar.add(space3);
		mBar.add(misCompeticiones);
		mBar.add(space5);
		mBar.add(settings);
		mBar.add(space2);
		mBar.add(miCuenta);

		this.add(panelLeft, BorderLayout.WEST);
		this.add(panelInferior, BorderLayout.SOUTH);
		panelCentral.add(panelCentralInferior);
		panelCentral.add(panelCentralSuperior);
		panelInferior.add(uActual);
		panelLeft.add(anyoCombo, BorderLayout.NORTH);
		panelLeft.add(comps);
		panelLeft.add(buscar);
		panelLeft.add(buscar2);
		panelLeft.add(panelListaComps);
		panelLeft.add(enter);
		panelListaComps.add(scrollPane);
		addFavoritos.add(addCompetitions);
		misCompeticiones.add(favoriteCompetitions);
		allComps.add(todasLasComps);
		miCuenta.add(cerrarSesion);
		panelCentralInferior.add(todosLosEquipos);
		panelCentralSuperior.add(informacionComp);
		panelCentralSuperior.add(anyoComp);
		panelCentralSuperior.add(nombreComp);
		panelCentralSuperior.add(paisComp);
		panelCentralSuperior.add(campeonComp);
		panelCentralSuperior.add(subcampeonComp);
		panelCentralSuperior.add(banderaPais);
		// ACTION LISTENERS
		buscar2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				if (anyoCombo.getSelectedItem() != null) {
					int anyo = (Integer) anyoCombo.getSelectedItem();
					ArrayList<String> comps = ExtraccionBD.getNomCompeticionesPorAnyoUsuario(usuarioActual, anyo);
					if (!comps.isEmpty()) {
						for (String comp : comps) {
							modelo.addElement(comp);
							list.setModel(modelo);
						}
					}
				}

			}
		});
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				if (anyoCombo.getSelectedItem() != null) {
					int anyo = (Integer) anyoCombo.getSelectedItem();
					ArrayList<String> comps = ExtraccionBD.getNomCompeticionesPorAnyo(anyo);
					if (!comps.isEmpty()) {
						for (String comp : comps) {
							modelo.addElement(comp);
							list.setModel(modelo);
						}
					}
				}

			}
		});
		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();

			}
		});
		favoriteCompetitions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comps.setText("Mis competiciones favoritas :");
				modelo.clear();
				buscar.setBounds(3000, 3000, 0, 0);
				buscar2.setBounds(150, 30, 50, 50);
				panelListaComps.setBounds(10, 85, 180, 450);
				enter.setBounds(10, 500, 180, 50);

			}
		});
		todasLasComps.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				comps.setText("Todas las competiciones :");
				buscar.setBounds(150, 30, 50, 50);
				buscar2.setBounds(3000, 3000, 0, 0);
				panelListaComps.setBounds(10, 85, 180, 450);
				enter.setBounds(10, 530, 180, 50);
			}
		});

		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null) {
					anyoComp.setText("Año :  ");
					nombreComp.setText("Nombre :  ");
					paisComp.setText("Pais :  ");
					banderaPais.setIcon(new ImageIcon("src/images/"));
					campeonComp.setText("Campeón :  ");
					subcampeonComp.setText("Subcampeón :  ");
					String compSeleccionada = list.getSelectedValue();
					int anyo = (Integer) anyoCombo.getSelectedItem();
					Competicion c = ExtraccionBD.getCompeticion(compSeleccionada, anyo);
					System.out.println(c.getGanador().getNombre());
					anyoComp.setText("Año :  " + c.getAnyo());
					nombreComp.setText("Nombre :  " + compSeleccionada);
					paisComp.setText("Pais :  " + c.getPais());
					banderaPais.setIcon(new ImageIcon("src/images/" + c.getPais() + ".png"));
					campeonComp.setText("Campeón :  " + c.getGanador().getNombre());
					subcampeonComp.setText("Subcampeón :  " + c.getSubcampeon().getNombre());
				}
			}
		});
		this.setVisible(true);
	}

	public static void setInfoComp(String nomComp, int anyo) {
		String pais = ExtraccionBD.getPaisCompeticion(nomComp);
	}

	public static void main(String[] args) {
		new MenuPrincipal("eneko");
	}

}
