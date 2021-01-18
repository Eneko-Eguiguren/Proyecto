package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
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

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	Color color = new Color(200, 180, 150);
	Font f = new Font("arial", 1, 16);

	public MenuPrincipal(String usuarioActual) {
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
		JMenuItem favoriteCompetitions = new JMenuItem("Mis competiciones favoritas",
				new ImageIcon("src/images/fav2.png"));
		JMenuItem filtros = new JMenuItem("Filtrar resultados");
		JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
		JPanel panelCentral = new JPanel();
		JPanel panelLeft = new JPanel();
		JPanel panelCentralSuperior = new JPanel();
		JPanel panelCentralInferior = new JPanel();
		JPanel panelInferior = new JPanel();
		JPanel panelListaComps = new JPanel();
		JLabel uActual = new JLabel("Usuario actual :     " + usuarioActual);
		JLabel comps = new JLabel("Competiciones :");
		JButton buscar = new JButton(new ImageIcon("src/images/buscar.png"));
		JComboBox<Integer> anyoCombo = new JComboBox<Integer>();
		for (int i = 2020; i > 1950; i--) {
			anyoCombo.addItem(i);
		}
		JList<String> list = new JList<String>();
		list.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);

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
		cerrarSesion.setIcon(new ImageIcon("src/images/cerrarsesion.png"));
		mBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		addTeams.setFont(f);
		addCompetitions.setFont(f);
		favoriteTeams.setFont(f);
		favoriteCompetitions.setFont(f);
		filtros.setFont(f);
		cerrarSesion.setFont(f);
		panelCentral.setBackground(Color.BLUE);
		panelCentral.setLayout(null);
		panelLeft.setPreferredSize(new Dimension(200, MAXIMIZED_VERT));
		panelInferior.setPreferredSize(new Dimension(MAXIMIZED_HORIZ, 30));
		panelCentralSuperior.setBounds(20, 20, 740, 150);
		panelCentralInferior.setBounds(20, 190, 200, 100);
		panelCentralSuperior.setBackground(Color.GRAY);
		panelCentralInferior.setBackground(Color.BLACK);
		panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLeft.setLayout(null);
		anyoCombo.setBounds(0, 30, 150, 50);
		buscar.setBounds(150, 30, 50, 50);
		buscar.setBackground(Color.WHITE);
		anyoCombo.setBackground(Color.WHITE);
		comps.setBounds(0, 0, 200, 30);
		panelListaComps.setLayout(new BorderLayout());
		panelListaComps.setBounds(10, 85, 180, 500);
		scrollPane.setBounds(0, 0, 180, 500);
	
		panelLeft.setBackground(color);
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
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelLeft, BorderLayout.WEST);
		this.add(panelInferior, BorderLayout.SOUTH);
		panelCentral.add(panelCentralInferior);
		panelCentral.add(panelCentralSuperior);
		panelInferior.add(uActual);
		panelLeft.add(anyoCombo, BorderLayout.NORTH);
		panelLeft.add(comps);
		panelLeft.add(buscar);
		panelLeft.add(panelListaComps);
		panelListaComps.add(scrollPane);
		addFavoritos.add(addTeams);
		addFavoritos.add(addCompetitions);
		misEquipos.add(favoriteTeams);
		misCompeticiones.add(favoriteCompetitions);
		lineas.add(filtros);
		miCuenta.add(cerrarSesion);
		//
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
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MenuPrincipal("eneko");
	}
}
