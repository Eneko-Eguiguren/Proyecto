package clases;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInicial extends JFrame{
	JFrame ventana = new JFrame();
	JLabel fondo = new JLabel(new ImageIcon("Proyecto/src/Fondo Pantalla Inicio Proyecto.jpg"));
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventana.setLocation(400, 250);
		ventana.setSize(500, 300);
		JLabel fondo = new JLabel(new ImageIcon("Fondo Pantalla Inicio Proyecto.jpg"));
		ventana.add(fondo);
		ventana.setVisible(true);
	}
}
