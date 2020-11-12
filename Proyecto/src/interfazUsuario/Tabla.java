package interfazUsuario;

import java.awt.Color;
import java.awt.Font;
import datos.*;

public class Tabla {
	private Clasificacion clasificacion;
	private int ALTO_FILA = 25; // Píxels de alto de fila
	private int X_INICIO_TABLA = 20; // Coordenada de inicio de la tabla (esquina superior izquierda)
	private int Y_INICIO_TABLA = 45;
	private Font LETRA_TABLA = new Font( "Arial", Font.PLAIN, 20 );
	
	public Tabla( Clasificacion clasificacion ) {
		this.clasificacion = clasificacion;
	}
	
	public void dibujaCompleta( VentanaGrafica vent ) {
		vent.borra();
		sacaCabecera( vent );
		sacaEquipos( vent );
		dibujaMalla( vent );
	}
	
	private void dibujaMalla( VentanaGrafica vent ) {
		double y = Y_INICIO_TABLA; 
		for (int fila=0; fila<clasificacion.getEquipos().length; fila++) {
			double x = X_INICIO_TABLA;
			for (int col=0; col<clasificacion.getEquipos()[0].getCabs().length; col++) {
				vent.dibujaRect( x, y, clasificacion.getEquipos()[0].getCols()[col], ALTO_FILA, 1.5f, Color.black );
				x += clasificacion.getEquipos()[0].getCols()[col];
			}
			y += ALTO_FILA;
		}
	}
	
	private void sacaCabecera( VentanaGrafica vent ) {
		double y = Y_INICIO_TABLA; 
		double x = X_INICIO_TABLA;
		vent.dibujaTexto(x+10, y-5, "Pos.", LETRA_TABLA, Color.black );
		x += clasificacion.getEquipos()[0].getCols()[0];
		vent.dibujaTexto(x+10, y-5, "Equipo", LETRA_TABLA, Color.black );
		x += clasificacion.getEquipos()[0].getCols()[1];
		vent.dibujaTexto(x+10, y-5, "Ptos.", LETRA_TABLA, Color.black );
		x += clasificacion.getEquipos()[0].getCols()[2];
		if (clasificacion.getLiga().getDeporte().equals("fútbol")) {
			vent.dibujaTexto(x+10, y-5, "GF", LETRA_TABLA, Color.black );
			x += clasificacion.getEquipos()[0].getCols()[3];
			vent.dibujaTexto(x+10, y-5, "GC", LETRA_TABLA, Color.black );
			x += clasificacion.getEquipos()[0].getCols()[4];
			vent.dibujaTexto(x+10, y-5, "Dif.Goles", LETRA_TABLA, Color.black );
			x += clasificacion.getEquipos()[0].getCols()[5];
			vent.dibujaTexto(x+10, y-5, "Part.G/E/P", LETRA_TABLA, Color.black );
		} else if (clasificacion.getLiga().getDeporte().equals("baloncesto")) {
			vent.dibujaTexto(x+10, y-5, "PF", LETRA_TABLA, Color.black );
			x += clasificacion.getEquipos()[0].getCols()[3];
			vent.dibujaTexto(x+10, y-5, "PC", LETRA_TABLA, Color.black );
			x += clasificacion.getEquipos()[0].getCols()[4];
			vent.dibujaTexto(x+10, y-5, "DP", LETRA_TABLA, Color.black );
			x += clasificacion.getEquipos()[0].getCols()[5];
			vent.dibujaTexto(x+10, y-5, "Part.G/P", LETRA_TABLA, Color.black );
		} else if (clasificacion.getLiga().getDeporte().equals("ajedrez")) {
			vent.dibujaTexto(x+10, y-5, "Vics.", LETRA_TABLA, Color.black );
		}
	}
	
	private void sacaEquipos( VentanaGrafica vent ) {
		double y = Y_INICIO_TABLA + ALTO_FILA; 
		for (int fila=0; fila<clasificacion.getEquipos().length; fila++) {
			Equipo equipo = clasificacion.getEquipos()[fila];
			double x = X_INICIO_TABLA;
			vent.dibujaTexto(x+10, y-5, (fila+1)+"", LETRA_TABLA, Color.black );
			x += equipo.getCols()[0];
			vent.dibujaTexto(x+10, y-5, equipo.getNombre(), LETRA_TABLA, Color.black );
			x += equipo.getCols()[1];
			vent.dibujaTexto(x+10, y-5, equipo.getPuntos()+"", LETRA_TABLA, Color.black );
			x += equipo.getCols()[2];
			if (clasificacion.getLiga().getDeporte().equals("fútbol")) {
				EquipoFutbol e = (EquipoFutbol) equipo;
				vent.dibujaTexto(x+10, y-5, e.getGf()+"", LETRA_TABLA, Color.green );
				x += equipo.getCols()[3];
				vent.dibujaTexto(x+10, y-5, e.getGc()+"", LETRA_TABLA, Color.red );
				x += equipo.getCols()[4];
				dibujaDiferenciaGoles( vent, x, y, e.getCols()[5], e );
				x += equipo.getCols()[5];
				dibujaPGPEPP( vent, x, y, e.getCols()[6], e );
			}
			y += ALTO_FILA;
		}
	}
	
	private void dibujaPGPEPP( VentanaGrafica vent, double x, double y, int ancho, EquipoFutbol equipo ) {
		double anchoPartido = ancho * 1.0 / clasificacion.getLiga().getJornadas(); 
		double anchoPG = equipo.getPg() * anchoPartido;
		double anchoPE = equipo.getPe() * anchoPartido;
		double anchoPP = equipo.getPp() * anchoPartido;
		vent.dibujaRect( x, y-ALTO_FILA, anchoPG, ALTO_FILA, 1.0f, Color.green, Color.green );
		x += anchoPG;
		vent.dibujaRect( x, y-ALTO_FILA, anchoPE, ALTO_FILA, 1.0f, Color.yellow, Color.yellow );
		x += anchoPE;
		vent.dibujaRect( x, y-ALTO_FILA, anchoPP, ALTO_FILA, 1.0f, Color.red, Color.red );
	}
	
	private void dibujaDiferenciaGoles( VentanaGrafica vent, double x, double y, int ancho, EquipoFutbol equipo ) {
		int difGoles = equipo.getGf() - equipo.getGc();
		dibujaDif( vent, x, y, ancho, difGoles );
	}
	
		private void dibujaDif( VentanaGrafica vent, double x, double y, int ancho, int dif ) {
			double anchoGrafico = ancho / 2.0 / 50.0 * dif;  // Escala el ancho por 50 goles/puntos
			if (anchoGrafico < -ancho/2) anchoGrafico = -ancho/2;  // Limita el ancho a la casilla disponible
			else if (anchoGrafico > ancho/2) anchoGrafico = ancho/2;
			double xMitad = x + ancho/2.0;
			if (dif < 0) {
				vent.dibujaRect( xMitad+anchoGrafico, y-ALTO_FILA, -anchoGrafico, ALTO_FILA, 1.0f, Color.red, Color.red );
			} else {
				vent.dibujaRect( xMitad, y-ALTO_FILA, anchoGrafico, ALTO_FILA, 1.0f, Color.green, Color.green );
			}
		}
}
