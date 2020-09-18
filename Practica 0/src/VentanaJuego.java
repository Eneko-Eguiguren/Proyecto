import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		VentanaJuego v = new VentanaJuego();
		//v.setVisible(true);
		coche c = new coche(80.0,90.0,150.0,100.0,"Eneko");
	}
	public VentanaJuego() {
	super();
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocation(300, 100);
	this.setSize(800, 500);
	JPanel panel = new JPanel();
	JPanel sur = new JPanel();
	sur.setLayout(new FlowLayout());
	this.add(sur, BorderLayout.SOUTH);
	this.add(panel,BorderLayout.CENTER);
	JButton acelerar = new JButton("Acelerar");
	JButton frenar = new JButton("Frenar");
	JButton izquierda = new JButton("Gira izq.");
	JButton derecha = new JButton("Gira der.");
	sur.add(acelerar, BorderLayout.SOUTH);
	sur.add(frenar, BorderLayout.SOUTH);
	sur.add(izquierda, BorderLayout.SOUTH);
	sur.add(derecha, BorderLayout.SOUTH);
	}
	//public void creaCoche
	
	
}
