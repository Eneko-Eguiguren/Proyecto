package interfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BD.ExtraccionBD;
import datos.Competicion;

public class AnyadirFavs extends JFrame {

	private static final long serialVersionUID = 1L;
	Color color = new Color(200, 180, 150);

	public AnyadirFavs(String usuarioActual) {
		this.setBounds(500, 200, 300, 300);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(color);
		JComboBox<String> comps = new JComboBox<String>();
		comps.setBounds(70, 70, 120, 50);
		JComboBox<Integer> anyos = new JComboBox<Integer>();
		anyos.setBounds(2000, 2000, 0, 0);
		JLabel nombreComp = new JLabel("Elija competicion");
		JButton aceptar1 = new JButton("Pasar a años");
		JButton aceptar2 = new JButton("Añadir favorito");
		aceptar1.setBackground(Color.BLACK);
		aceptar1.setForeground(color);
		aceptar1.setBounds(50, 150, 180, 30);
		nombreComp.setBounds(20, 15, 250, 30);
		aceptar2.setBackground(Color.BLACK);
		aceptar2.setForeground(color);
		aceptar2.setBounds(3000, 3000, 0, 0);
		ArrayList<String> compsArray = ExtraccionBD.getNomCompeticionesSinRepetir();
		for (String c : compsArray) {
			comps.addItem(c);
		}
		this.add(comps);

		this.add(aceptar1);
		this.add(aceptar2);
		this.add(anyos);
		this.add(nombreComp);

		aceptar1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nomComp = (String) comps.getSelectedItem();
				aceptar1.setBounds(3000, 3000, 0, 0);
				aceptar2.setBounds(50, 150, 180, 30);
				comps.setBounds(2200, 2000, 0, 0);
				nombreComp.setText("Elegir el año de la " + nomComp);
				anyos.setBounds(70, 70, 120, 50);
				ArrayList<Integer> anyosC = ExtraccionBD.getAnyoCompeticion(nomComp);
				for (Integer i : anyosC) {
					anyos.addItem(i);
				}

			}
		});
		aceptar2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				String nomComp = (String) comps.getSelectedItem();
				int anyo = (Integer) anyos.getSelectedItem();
				Competicion c = ExtraccionBD.getCompeticion(nomComp, anyo);
				if (!ExtraccionBD.isCompInFavs(usuarioActual, c)) {
					 ExtraccionBD.addUsuarioCompeticionBD(usuarioActual, c.getNombre(),anyo);
					
				} else {
					JOptionPane.showMessageDialog(null, "Ya esta en favoritos.");
				}
			}
		});
		this.setVisible(true);
	}

}
