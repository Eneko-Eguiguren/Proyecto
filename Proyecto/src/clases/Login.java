package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import CFont.CustomFont;

public class Login  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color colorAzul = new Color(100,110,255);
	CustomFont cf = new CustomFont();
	public Login() {
		//
		this.setTitle("LogIn");
		this.setBounds(440, 160, 485, 430);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//
		JPanel panel = new JPanel();
		JLabel title1 = new JLabel("FOOTBALL");
		JLabel title2 = new JLabel("RESULTS");
		JLabel icon = new JLabel(new ImageIcon("src/images/icono5.png"));
		JLabel usr = new JLabel("USUARIO");
		JLabel password = new JLabel("CONTRASEÑA");
		JTextField usrTxt = new JTextField(20);
		JPasswordField passwordTxt = new JPasswordField(30);
		JButton accept = new JButton("Entrar");
		JButton delete = new JButton("Borrar");
		JButton register = new JButton("¿Eres nuevo?");
		//
		panel.setLayout(null);
		panel.setBackground(colorAzul);
		usr.setBounds(70, 130, 70, 25);
		password.setBounds(70, 190, 100, 25);
		usrTxt.setBounds(200, 125, 160, 35);
		passwordTxt.setBounds(200, 185, 160, 35);
		accept.setBounds(115, 260, 100, 40);
		delete.setBounds(240, 260, 100, 40);
		title1.setBounds(80, 20, 130, 100);
		title2.setBounds(248, 20, 100, 100);
		icon.setBounds(190, 40, 54, 54);
		register.setBounds(160, 330, 140, 40);
		
		icon.setBackground(colorAzul);
		title1.setFont(cf.MyFont(1, 24));
		title1.setForeground(Color.BLACK);
		title2.setFont(cf.MyFont(1, 24));
		title2.setForeground(Color.BLACK);
		register.setBorderPainted(false);
		register.setBackground(colorAzul);
		//
		this.add(panel);
		panel.add(usr);
		panel.add(password);
		panel.add(usrTxt);
		panel.add(passwordTxt);
		panel.add(accept);
		panel.add(delete);
		panel.add(register);
		panel.add(title1);
		panel.add(icon);
		panel.add(title2);
		//
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordTxt.setText(null);
				usrTxt.setText(null);
				
			}
		});
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// registro.setvisible(true);
				dispose();
				
			}
		});
		//
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
//		try { // Cambiamos el look and feel (se tiene que hacer antes de crear la GUI
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (Exception e) { }
		new Login();
	}
}
