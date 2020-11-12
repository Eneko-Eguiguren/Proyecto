package datos;

import datos.*;
import interfazUsuario.Tabla;
import interfazUsuario.VentanaGrafica;

public class Main {

	// Método principal. Calcula las clasificaciones y las muestra
	public static void main(String[] args) {
	
		Clasificacion clasif3 = new Clasificacion( Liga.LIGA_FUTBOL_EJEMPLO );
		Tabla tabla3 = new Tabla( clasif3 );
		VentanaGrafica vent3 = new VentanaGrafica( 840, 580, "Clasificación de liga de fútbol" );
		for (int jornada=0; jornada<Liga.LIGA_FUTBOL_EJEMPLO.getJornadas(); jornada++) {
			clasif3.calcPuntos( jornada );
			clasif3.ordenaEquiposPorPuntos();
			vent3.setMensaje( "Clasificación de jornada " + (jornada + 1));
			tabla3.dibujaCompleta( vent3 );
			vent3.espera( 1000 );
		}
	}
	

}
