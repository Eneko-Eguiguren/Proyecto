package interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public VentanaAdmin() {
		this.setTitle("Administrador");
		this.setBounds(440, 160, 485, 430);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout());
		//
		JPanel panel = new JPanel();
		JButton anyadirJugs = new JButton("Añadir Jugadores");
		JButton anyadirComps = new JButton("Añadir Competiciones");
		JButton anyadirEquipo = new JButton("Añadir Equipos");
		
		//
		panel.setLayout(new GridLayout());
		
		//
		this.add(panel);
		panel.add(anyadirComps);
		panel.add(anyadirEquipo);
		panel.add(anyadirJugs);
		//
		anyadirComps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		anyadirEquipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnyadirEqs();
				dispose();
			}
		});
		//
		this.setVisible(true);
	}
	
}
