package iu;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class VentanaGrafica {
	private JFrame ventana;       
	private boolean cerrada;      
	private JPanel panel;         
	private JLabel lMens;         
	private BufferedImage buffer; 
	private Graphics2D graphics;  	
	private Point pointPressed;   
	private Point pointMoved;     
	private Point pointMovedPrev; 
	private boolean dibujadoInmediato = true; 

		private Object lock = new Object();  
	
	public VentanaGrafica( int anchura, int altura, String titulo ) {
		cerrada = false;
		ventana = new JFrame( titulo );
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// ventana.setSize( anchura, altura ); -- se hace en funcion del tamaÒo preferido del panel de dibujo
		buffer = new BufferedImage( 2000, 1500, BufferedImage.TYPE_INT_ARGB );
		graphics = buffer.createGraphics();
		graphics.setPaint ( Color.white );
		graphics.fillRect ( 0, 0, 2000, 1500 );
		panel = new JPanel() {
			{
				setLayout( new BorderLayout() );
			}
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				((Graphics2D)g).drawImage( buffer, null, 0, 0 );
			}
		};
		panel.setPreferredSize( new Dimension( anchura, altura ));
		lMens = new JLabel( " " );
		ventana.getContentPane().add( panel, BorderLayout.CENTER );
		ventana.getContentPane().add( lMens, BorderLayout.SOUTH );
		ventana.pack();
		ventana.setLocationRelativeTo( null );
		ventana.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrada = true;
			}
		});
		panel.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				synchronized (lock) {
					pointPressed = null;
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				synchronized (lock) {
					pointPressed = e.getPoint();
				}
			}
		});
		panel.addMouseMotionListener( new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				synchronized (lock) {
					pointMoved = e.getPoint();
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				synchronized (lock) {
					pointPressed = e.getPoint();
				}
			}
		});
		try {
			SwingUtilities.invokeAndWait( new Runnable() {
				@Override
				public void run() {
					ventana.setVisible( true );
				}
			});
		} catch (InvocationTargetException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	public void espera( long milis ) {
		try {
			Thread.sleep( milis );
		} catch (InterruptedException e) {
		}
	}
	public void acaba() {
		ventana.dispose();
		cerrada = true;
	}
	
	/** Devuelve el objeto ventana (JFrame) correspondiente a la ventana grafica
	 */
	public JFrame getJFrame() {
		return ventana;
	}

	public boolean estaCerrada() {
		return cerrada;
	}
	
	/** Devuelve el punto donde esta° el raton pulsado en este momento
	 * @return	Punto relativo de la ventana, null si el raton no esta° siendo pulsado en ese instante 
	 */
	public Point getRatonPulsado() {
		synchronized (lock) {
			return pointPressed;
		}
	}
	
	/** Devuelve el punto donde esta° el raton en este momento
	 * @return	Punto relativo a la ventana, null si el rat√≥n no se ha movido nunca
	 */
	public Point getRatonMovido() {
		synchronized (lock) {
			return pointMoved;
		}
	}
	
	/** Devuelve el √∫ltimo vector de movimiento del rat√≥n (desde la √∫ltima vez que se llam√≥ a este mismo m√©todo)
	 * @return	Punto relativo a la ventana, null si el rat√≥n no se ha movido nunca
	 */
	public Point getVectorRatonMovido() {
		synchronized (lock) {
			Point ret = new Point( 0, 0 );
			if (pointMovedPrev!=null) {
				ret.setLocation( pointMoved.getX()-pointMovedPrev.getX(), pointMoved.getY()- pointMovedPrev.getY() );
			}
			pointMovedPrev = pointMoved;
			return ret;
		}
	}	

	public void setMensaje( String mensaje ) {
		if (mensaje==null || mensaje.isEmpty())
			lMens.setText( " " );
		else
			lMens.setText( mensaje );
	}

	public int getAltura() {
		return panel.getHeight()-1;
	}

	public int getAnchura() {
		return panel.getWidth()-1;
	}
	
	/** Borra toda la ventana (pinta de color blanco)
	 */
	public void borra() {
		graphics.setColor( Color.white );
		graphics.fillRect( 0, 0, panel.getWidth()+2, panel.getHeight()+2 );
		if (dibujadoInmediato) panel.repaint();
	}

	public void dibujaRect( Rectangle rectangulo, float grosor, Color color ) {
		dibujaRect( rectangulo.getX(), rectangulo.getY(), rectangulo.getX()+rectangulo.getWidth(), rectangulo.getY()+rectangulo.getHeight(), grosor, color );
	}

	public void dibujaRect( double x, double y, double anchura, double altura, float grosor, Color color ) {
		graphics.setColor( color );
		graphics.setStroke( new BasicStroke( grosor ));
		graphics.drawRect( (int)Math.round(x), (int)Math.round(y), (int)Math.round(anchura), (int)Math.round(altura) );
		if (dibujadoInmediato) panel.repaint();
	}

	public void dibujaRect( double x, double y, double anchura, double altura, float grosor, Color color, Color colorRell ) {
		graphics.setColor( colorRell );
		graphics.setStroke( new BasicStroke( grosor ));
		graphics.fillRect( (int)Math.round(x), (int)Math.round(y), (int)Math.round(anchura), (int)Math.round(altura) );
		graphics.setColor( color );
		graphics.drawRect( (int)Math.round(x), (int)Math.round(y), (int)Math.round(anchura), (int)Math.round(altura) );
		if (dibujadoInmediato) panel.repaint();
	}

	public void dibujaRect( double x, double y, double anchura, double altura, float grosor ) {
		dibujaRect( x, y, anchura, altura, grosor, Color.blue );
	}

	public void borraRect( double x, double y, double anchura, double altura, float grosor ) {
		dibujaRect( x, y, anchura, altura, grosor, Color.white );
	}

	public void dibujaCirculo( double x, double y, double radio, float grosor, Color color ) {
		graphics.setColor( color );
		graphics.setStroke( new BasicStroke( grosor ));
		graphics.drawOval( (int)Math.round(x-radio), (int)Math.round(y-radio), (int)Math.round(radio*2), (int)Math.round(radio*2) );
		if (dibujadoInmediato) panel.repaint();
	}

	public void dibujaCirculo( double x, double y, double radio, float grosor ) {
		dibujaCirculo( x, y, radio, grosor, Color.blue );
	}

	public void borraCirculo( double x, double y, double radio, float grosor ) {
		dibujaCirculo( x, y, radio, grosor, Color.white );
	}

	public void dibujaLinea( Line2D linea, float grosor, Color color ) {
		dibujaLinea( linea.getX1(), linea.getY1(), linea.getX2(), linea.getY2(), grosor, color );
	}

	public void dibujaLinea( double x, double y, double x2, double y2, float grosor, Color color ) {
		graphics.setColor( color );
		graphics.setStroke( new BasicStroke( grosor ));
		graphics.drawLine( (int)Math.round(x), (int)Math.round(y), (int)Math.round(x2), (int)Math.round(y2) );
		if (dibujadoInmediato) panel.repaint();
	}

	public void dibujaLinea( double x, double y, double x2, double y2, float grosor ) {
		dibujaLinea( x, y, x2, y2, grosor, Color.blue );
	}

	public void borraLinea( double x, double y, double x2, double y2, float grosor ) {
		dibujaLinea( x, y, x2, y2, grosor, Color.white );
	}

	public void dibujaFlecha( Line2D linea, float grosor, Color color ) {
		dibujaFlecha( linea.getX1(), linea.getY1(), linea.getX2(), linea.getY2(), grosor, color );
	}

	public void dibujaFlecha( double x, double y, double x2, double y2, float grosor, Color color ) {
		dibujaFlecha( x, y, x2, y2, grosor, color, 10 );
	}
	
	public void dibujaFlecha( double x, double y, double x2, double y2, float grosor, Color color, int largoFl ) {
		graphics.setColor( color );
		graphics.setStroke( new BasicStroke( grosor ));
		graphics.drawLine( (int)Math.round(x), (int)Math.round(y), (int)Math.round(x2), (int)Math.round(y2) );
		double angulo = Math.atan2( y2-y, x2-x ) + Math.PI;
		double angulo1 = angulo - Math.PI / 10;  // La flecha se forma rotando 1/10 de Pi hacia los dos lados
		double angulo2 = angulo + Math.PI / 10;
		graphics.drawLine( (int)Math.round(x2), (int)Math.round(y2), 
				(int)Math.round(x2+largoFl*Math.cos(angulo1)), (int)Math.round(y2+largoFl*Math.sin(angulo1)) );
		graphics.drawLine( (int)Math.round(x2), (int)Math.round(y2), 
				(int)Math.round(x2+largoFl*Math.cos(angulo2)), (int)Math.round(y2+largoFl*Math.sin(angulo2)) );
		if (dibujadoInmediato) panel.repaint();
	}

	public void dibujaFlecha( double x, double y, double x2, double y2, float grosor ) {
		dibujaFlecha( x, y, x2, y2, grosor, Color.blue );
	}

	public void borraFlecha( double x, double y, double x2, double y2, float grosor ) {
		dibujaFlecha( x, y, x2, y2, grosor, Color.white );
	}

	public void dibujaPoligono( float grosor, Color color, boolean cerrado, Point2D... punto ) {
		graphics.setColor( color );
		graphics.setStroke( new BasicStroke( grosor ));
		if (punto.length<2) return;
		Point2D puntoIni = punto[0];
		Point2D puntoAnt = punto[0];
		Point2D pto = null;
		int numPto = 1;
		do {
			pto = punto[numPto];
			graphics.drawLine( (int)Math.round(puntoAnt.getX()), (int)Math.round(puntoAnt.getY()), (int)Math.round(pto.getX()), (int)Math.round(pto.getY()) );
			puntoAnt = pto;
			numPto++;
		} while (numPto<punto.length);
		if (cerrado) {
			graphics.drawLine( (int)Math.round(pto.getX()), (int)Math.round(pto.getY()), (int)Math.round(puntoIni.getX()), (int)Math.round(puntoIni.getY()) );
		}
		if (dibujadoInmediato) panel.repaint();
	}

	public void borraPoligono( float grosor, boolean cerrado, Point2D... punto ) {
		dibujaPoligono( grosor, Color.white, cerrado, punto );
	}

	public void dibujaTexto( double x, double y, String texto, Font font, Color color ) {
		graphics.setColor( color );
		graphics.setFont( font );
		graphics.drawString( texto, (int)Math.round(x), (int)Math.round(y) );
		if (dibujadoInmediato) panel.repaint();
	}
	
	public Graphics2D getGraphics() {
		return graphics;
	}

	public void repaint() {
		panel.paintImmediately( 0, 0, panel.getWidth(), panel.getHeight() );
	}
}
	