package interfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.ExtraccionBD;
import datos.Usuario;

public class Registro extends JFrame {
	private static final long serialVersionUID = 1L;
	Color color = new Color(200, 180, 150);

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
		JButton atras = new JButton("Atras");
		//
		panel.setLayout(null);
		panel.setBackground(color);
		name.setBounds(170, 50, 190, 40);
		password.setBounds(170, 130, 190, 40);
		repeatPassword.setBounds(170, 210, 190, 40);
		usrName.setBounds(30, 50, 160, 40);
		pswrd1.setBounds(30, 130, 160, 40);
		pswrd2.setBounds(30, 210, 160, 40);
		accept.setBounds(110, 275, 110, 40);
		delete.setBounds(240, 275, 110, 40);
		atras.setBounds(180, 330, 100, 30);

		accept.setBackground(Color.BLACK);
		delete.setBackground(Color.BLACK);
		accept.setForeground(Color.WHITE);
		delete.setForeground(Color.WHITE);
		name.setForeground(Color.BLACK);
		password.setForeground(Color.BLACK);
		repeatPassword.setForeground(Color.BLACK);
		atras.setBackground(Color.BLACK);
		atras.setForeground(color);

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
		panel.add(atras);
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
				boolean iguales = false;
				
				if (password.getPassword().length == repeatPassword.getPassword().length) {
					char[] c = password.getPassword();
					char[] ca = password.getPassword();
					String contr1 = String.valueOf(c);
					String contr2 = String.valueOf(ca);
					for (int i = 0; i < contr1.length(); i++) {
						if (contr1.charAt(i) == contr2.charAt(i)) {
							iguales = true;
						}
					}
				}

				if (iguales) {
					char[] c = password.getPassword();
					String contr = String.valueOf(c);
					try {
						ExtraccionBD.addUsuarioBD(name.getText(), contr, ExtraccionBD.usuarios.size() + 1);
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
						dispose();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Datos erroneos.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Las contraseñas deben ser iguales.");
				}
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

	public static void main(String[] args) {
		new Registro();

	}
}
