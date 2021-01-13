package interfazGrafica;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import CFont.CustomFont;
import datos.Usuario;



public class Login  extends JFrame{

	private static final long serialVersionUID = 1L;
	Color color = new Color(200,180,150);
	CustomFont cf = new CustomFont();
	public ArrayList<Usuario> usuarios;
	public Login() {
		//
		this.setTitle("LogIn");
		this.setBounds(440, 160, 485, 430);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//
		JPanel panel = new JPanel();
		JLabel title1 = new JLabel("HISTORY");
		JLabel title2 = new JLabel("FOOTBALL");
		JLabel icon = new JLabel(new ImageIcon("src/images/icono2.png"));
		JLabel usr = new JLabel("USUARIO");
		JLabel password = new JLabel("CONTRASEÑA");
		JTextField usrTxt = new JTextField(20);
		JPasswordField passwordTxt = new JPasswordField(30);
		JButton admin = new JButton("ADMIN");
		JButton accept = new JButton("Entrar");
		JButton delete = new JButton("Borrar");
		JButton register = new JButton("¿Eres nuevo?");
		//
		panel.setLayout(null);
		panel.setBackground(color);
		usr.setBounds(70, 130, 70, 25);
		password.setBounds(70, 190, 100, 25);
		usrTxt.setBounds(200, 125, 160, 35);
		passwordTxt.setBounds(200, 185, 160, 35);
		accept.setBounds(115, 260, 100, 40);
		delete.setBounds(240, 260, 100, 40);
		title1.setBounds(90, 20, 130, 100);
		title2.setBounds(246, 20, 130, 100);
		icon.setBounds(193, 40, 54, 64);
		register.setBounds(160, 330, 140, 40);
		admin.setBounds(365, 340, 100, 50);
		
		icon.setBackground(color);
		title1.setFont(cf.MyFont(1, 24));
		title1.setForeground(Color.BLACK);
		title2.setFont(cf.MyFont(1, 24));
		title2.setForeground(Color.BLACK);
		register.setBorderPainted(false);
		register.setBackground(color);
		admin.setBorderPainted(false);
		admin.setForeground(Color.BLACK);
		admin.setBackground(color);
		accept.setBackground(Color.BLACK);
		accept.setForeground(Color.WHITE);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		usr.setForeground(Color.BLACK);
		password.setForeground(Color.BLACK);
		register.setForeground(Color.BLACK);
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
		panel.add(admin);
		//
		admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new VentanaAdmin();
				dispose();
			}
		});
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
				
				new Registro();
				dispose();
			}
		});
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//if(usrTxt.getText()== usuarios)
				
			}
		});
		//
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Login();
	}
}
