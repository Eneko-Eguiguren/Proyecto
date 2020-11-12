package interfazUsuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datos.Usuario;

public class Registro extends JFrame {
	Color color = new Color(200,180,150);
	
public Registro() {
	//
	this.setTitle("Register");
	this.setBounds(440, 160, 485, 430);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	//
	JPanel panel = new JPanel();
	JTextField name = new JTextField(30);
	JPasswordField password = new JPasswordField(30);
	JPasswordField repeatPassword = new JPasswordField(30);
	JLabel usrName = new JLabel("NOMBRE DE USUARIO");
	JLabel pswrd1 = new JLabel("CONTRASEÑA");
	JLabel pswrd2 = new JLabel("REPETIR CONTRASEÑA");
	JButton accept = new JButton("Registrarse");
	JButton delete = new JButton("Borrar");
	//
	panel.setLayout(null);
	panel.setBackground(color);
	name.setBounds(170, 50, 190, 40);
	password.setBounds(170, 130, 190, 40);
	repeatPassword.setBounds(170, 210, 190, 40);
	usrName.setBounds(30, 50, 160, 40);
	pswrd1.setBounds(30, 130, 160, 40);
	pswrd2.setBounds(30, 210, 160, 40);
	accept.setBounds(90, 290, 110, 40);
	delete.setBounds(230, 290, 110, 40);
	
	accept.setBackground(Color.BLACK);
	delete.setBackground(Color.BLACK);
	accept.setForeground(Color.WHITE);
	delete.setForeground(Color.WHITE);
	name.setForeground(Color.BLACK);
	password.setForeground(Color.BLACK);
	repeatPassword.setForeground(Color.BLACK);
	//
	
	this.add(panel);
	panel.add(name);
	panel.add(password);
	panel.add(pswrd1);
	panel.add(pswrd2);
	panel.add(usrName);
	panel.add(repeatPassword);
	panel.add(accept);
	panel.add(delete);
	//
	delete.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			name.setText(null);
			password.setText(null);
			repeatPassword.setText(null);
			
		}
	});
	accept.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(password.getPassword().equals( repeatPassword.getPassword())) {
				char[] c = password.getPassword();
				Usuario usr = new Usuario();
				usr.setContraseña(c);
				usr.setNombre(name.getText());
			}
			
		}
	});
	//
	this.setVisible(true);
	
	
	
}
public static void main(String[] args) {
	new Registro();
}
}
