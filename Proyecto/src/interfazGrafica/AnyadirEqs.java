package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BD.ExtraccionBD;
import datos.Equipo;

public class AnyadirEqs extends JFrame {

	private static final long serialVersionUID = 1L;

	public AnyadirEqs() {
		this.setTitle("A�adir Equipos Nuevos");
		this.setBounds(440, 160, 485, 430);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//
		JPanel panel = new JPanel();
		JTextField nombreTxt = new JTextField();
		JFormattedTextField codigoTxt = new JFormattedTextField();
		JLabel title = new JLabel("A�ADIR EQUIPOS");
		JLabel nombre = new JLabel("Nombre");
		JLabel codigo = new JLabel("Codigo");
		JButton accept = new JButton("Aceptar");
		JButton delete = new JButton("Eliminar");
		JButton atras = new JButton("Atras");
		//
		panel.setBackground(Login.color);
		panel.setLayout(null);
		nombre.setBounds(70, 130, 70, 25);
		codigo.setBounds(70, 190, 100, 25);
		nombreTxt.setBounds(200, 125, 160, 35);
		codigoTxt.setBounds(200, 185, 160, 35);
		accept.setBounds(115, 260, 100, 40);
		delete.setBounds(240, 260, 100, 40);
		title.setBounds(180, 20, 130, 100);
		atras.setBounds(180, 340, 100, 30);
		//
		this.add(panel);
		panel.add(nombreTxt);
		panel.add(codigoTxt);
		panel.add(codigo);
		panel.add(nombre);
		panel.add(delete);
		panel.add(accept);
		panel.add(title);
		panel.add(atras);
		//
		accept.addActionListener(new ActionListener() {
			
			private Boolean esta;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = nombreTxt.getText();
					String c = codigoTxt.getText();
					int cod = Integer.parseInt(c);
					System.out.println(cod);
					Equipo eqTemporal = new Equipo(cod, nom);
					esta = false;
					for (Equipo eq : ExtraccionBD.equipos) {
						if(eq.equals(eqTemporal)) {
						 esta = true;
						}
					}
					if(esta == false) {
						//ExtraccionBD.addEquiposBD(cod, nom);
					}else if (nom==null || c==null ){
						JOptionPane.showMessageDialog(null, "Introduzca datos.");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Datos no v�lidos.");
				}
				
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				codigoTxt.setText(null);
				nombreTxt.setText(null);
				
			}
		});
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAdmin();
				dispose();
				
			}
		});
		//
		this.setVisible(true);
	}
}
