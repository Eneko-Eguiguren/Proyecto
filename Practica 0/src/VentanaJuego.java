import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel principal;
	CocheJuego miCoche;
	VentanaJuego.MiRunnable miHilo = null;
	public static void main(String[] args) {
		VentanaJuego v = new VentanaJuego();
		v.creaCoche(150, 100);
		v.setVisible(true);
		v.miCoche.setPiloto("Vettel");
		v.miHilo = v.new MiRunnable();
		Thread nuevoHilo = new Thread(v.miHilo);
		nuevoHilo.start();
		
		//Coche c = new Coche(80.0,90.0,150.0,100.0,"Eneko");
	}
	public VentanaJuego() {
	super();
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocation(300, 100);
	this.setSize(800, 500);
	JPanel panel = new JPanel();
	JPanel sur = new JPanel();
	JLabelCoche c = new JLabelCoche();
	panel.add(c);
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
	
	acelerar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(VentanaJuego.this.miCoche.getMiVelocidad() == 0.0D) {
				VentanaJuego.this.miCoche.acelera(5.0D);
			}  else {
				VentanaJuego.this.miCoche.acelera(5.0D);
			}
		}
	});
	
	frenar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaJuego.this.miCoche.acelera(-5.0D);
		}
	});
	
	izquierda.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaJuego.this.miCoche.gira(10);
			}
	});
	derecha.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaJuego.this.miCoche.gira(-10);
			}
	});
	
	}
	public void creaCoche(int posX, int posY) {
		this.miCoche = new CocheJuego();
		this.miCoche.setPosicion(posX, posY);
		this.principal.add(this.miCoche.getGrafico());
	}
	
	class MiRunnable implements Runnable {
	      boolean sigo = true;

	      public void run() {
	         while(this.sigo) {
	            VentanaJuego.this.miCoche.mueve(0.04D);
	         }
	         try {
	               Thread.sleep(40L);
	            } catch (Exception var3) {
	           }
	         }
	      }
	            
	
}
