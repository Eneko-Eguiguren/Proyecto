package interfazUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BD.ExtraccionBD;
import datos.Equipo;

public class AnyadirEqs extends JFrame {

	
	public AnyadirEqs() {
		this.setTitle("Añadir Equipos Nuevos");
		this.setBounds(440, 160, 485, 430);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//
		JPanel panel = new JPanel();
		JTextField nombreTxt = new JTextField();
		JFormattedTextField codigoTxt = new JFormattedTextField();
		JLabel title = new JLabel("AÑADIR EQUIPOS");
		JLabel nombre = new JLabel("Nombre");
		JLabel codigo = new JLabel("Codigo");
		JButton accept = new JButton("Aceptar");
		JButton delete = new JButton("Eliminar");
		//
		panel.setLayout(null);
		nombre.setBounds(70, 130, 70, 25);
		codigo.setBounds(70, 190, 100, 25);
		nombreTxt.setBounds(200, 125, 160, 35);
		codigoTxt.setBounds(200, 185, 160, 35);
		accept.setBounds(115, 260, 100, 40);
		delete.setBounds(240, 260, 100, 40);
		title.setBounds(180, 20, 130, 100);
		//
		this.add(panel);
		panel.add(nombreTxt);
		panel.add(codigoTxt);
		panel.add(codigo);
		panel.add(nombre);
		panel.add(delete);
		panel.add(accept);
		panel.add(title);
		//
		accept.addActionListener(new ActionListener() {
			
			private Boolean esta;

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = nombreTxt.getText();
				String c = codigoTxt.getText();
				int cod = Integer.parseInt(c);
				Equipo eqTemporal = new Equipo(cod, nom);
				esta = false;
				for (Equipo eq : ExtraccionBD.equipos) {
					if(eq.equals(eqTemporal)) {
					 esta = true;
					}
				}
				if(esta == false) {
					ExtraccionBD.addEquiposBD(cod, nom);
				}// poner el error sobre panatalla
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				codigoTxt.setText(null);
				nombreTxt.setText(null);
				
			}
		});
		//
		this.setVisible(true);
	}
}
