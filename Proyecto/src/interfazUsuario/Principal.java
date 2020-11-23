package interfazUsuario;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JFrame {
	
	public Principal() {
		//
		this.setTitle("History Football");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(180, 30, 1000, 700);
		//
		JPanel p = new JPanel();
		JLabel icon = new JLabel(new ImageIcon("src/images/icono7.png"));
		JComboBox anyos = new JComboBox();
		anyos.add(anyos);
		
		
		
		icon.setBounds(-10, -10, 100, 100);
		p.setLayout(null);
		//
		this.add(p);
		p.add(icon);
		//
		this.setVisible(true);
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Principal();
		ArrayList<String> anyosLista = new ArrayList<String>();
		for (int i = 1950; i < 2020; i++) {
			String numero = String.valueOf(i);
			//anyos.add(numero);
			
		}
	}
}
