package interfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BD.ExtraccionBD;

public class AnyadirEqsAComp extends JFrame {
	private static final long serialVersionUID = 1L;
	Color color = new Color(200, 180, 150);
	public AnyadirEqsAComp() {
		
		this.setBounds(440, 160, 485, 290);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setBackground(color);
		p.setLayout(null);
		
		JLabel elijeComp = new JLabel("Elija la competicion : ");
		elijeComp.setBounds(170, 10, 200, 30);
		
		JComboBox<String> compsCombo = new JComboBox<String>();
		compsCombo.setBounds(120, 70, 200, 50);
		for (String s : ExtraccionBD.getNomCompeticionesSinRepetir()) {
			compsCombo.addItem(s);
		}
		
		JButton accept = new JButton("Aceptar ");
		accept.setBounds(150, 160, 150, 40);
		accept.setBackground(Color.BLACK);
		accept.setForeground(color);
		
		JButton accept2 = new JButton("Aceptar ");
		accept2.setBounds(3000, 3000, 0, 0);
		accept2.setBackground(Color.BLACK);
		accept2.setForeground(color);
		
		JComboBox<Integer> anyos = new JComboBox<Integer>();
		
		this.add(p);
		p.add(elijeComp);
		p.add(compsCombo);
		p.add(accept);
		p.add(anyos);
		p.add(accept2);
		
		accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nomComp = (String) compsCombo.getSelectedItem();
				accept.setBounds(3000, 3000, 0, 0);
				accept2.setBounds(150, 160, 150, 40);
				compsCombo.setBounds(2200, 2000, 0, 0);
				elijeComp.setText("Elegir el año de la " + nomComp+":");
				elijeComp.setBounds(140, 10, 200, 30);
				anyos.setBounds(120, 70, 200, 50);
				ArrayList<Integer> anyosC = ExtraccionBD.getAnyoCompeticion(nomComp);
				for (Integer i : anyosC) {
					anyos.addItem(i);
				}

			}
		});
		accept2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnyadirEqsAComp2((String)compsCombo.getSelectedItem(),(Integer ) anyos.getSelectedItem());
				dispose();
				
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new AnyadirEqsAComp();
	}
}
