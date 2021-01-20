package interfazGrafica;

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
	Color color = new Color(200,180,150);
	public VentanaAdmin() {
		this.setTitle("Administrador");
		this.setBounds(440, 160, 485, 430);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JButton anyadirComps = new JButton("Añadir Competiciones");
		JButton anyadirEquipo = new JButton("Añadir Equipos");
		JButton anyadirEqsAcomp = new JButton("Añadir equipos a competicion");
		JButton atras = new JButton("Atras");
		
		//
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new GridLayout());
		anyadirComps.setBackground(color);
		anyadirEquipo.setBackground(color);
		anyadirEqsAcomp.setBackground(color);

		atras.setBackground(color);
		
		//
		this.add(panel1);
		panel1.add(panel2, BorderLayout.CENTER);
		panel2.add(anyadirComps);
		panel2.add(anyadirEquipo);
		panel2.add(anyadirEqsAcomp);
		panel1.add(atras, BorderLayout.SOUTH);
		//
		anyadirComps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnyadirComps();
				dispose();
				
			}
		});
		anyadirEquipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnyadirEqs();
				dispose();
			}
		});
		anyadirEqsAcomp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnyadirEqsAComp();
				
			}
		});
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
			}
		});
		//
		this.setVisible(true);
	}
	
}
