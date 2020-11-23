package datos;

import datos.Equipo;
import datos.EquipoFutbol;
import datos.Liga;
import datos.Partido;
import datos.PartidoFutbol;

public class Clasificacion {

	private Liga liga;  // Liga que se clasifica
	private Equipo equipo[];  // Array de equipos de esa liga

	/** Crea una clasificación partiendo de una liga dada. La liga debe tener al menos una jornada disputada
	 * para poder saber sus equipos
	 * @param liga	Liga de referencia de la clasificación
	 */
	public Clasificacion (Liga liga) {
		this.liga = liga;
		creaArrayEquipos();
	}
	
	public Equipo[] getEquipos() { return equipo; }
	
	public Liga getLiga() {
		return liga;
	}

	private void creaArrayEquipos() {
		if (liga.getJornadas()>0) {
			equipo = new Equipo[ liga.getNumEquipos() ];
			for (int par=0; par<liga.getPartidos(); par++) {
				Partido p = liga.getPartido( 0, par );
				if (p instanceof PartidoFutbol) {
					equipo[par*2] = new EquipoFutbol( p.getE1().getNombre() );
					equipo[par*2 + 1] = new EquipoFutbol( p.getE2().getNombre() );
				}
			}
		}
	}

	// Visualiza en consola los equipos del array de equipos con su puntuación actual
	public void visualizaEquipos() {
		for (int eq=0; eq<equipo.length; eq++) {
			System.out.println( "Equipo " + eq + ": " + equipo[eq].toString() );
		}
	}

	private Equipo buscaEnArray(String nomEquipo) {
		Equipo cual = null;
		for (int eq=0; eq<equipo.length; eq++) {
			if (equipo[eq].getNombre().equalsIgnoreCase( nomEquipo )) {
				cual = equipo[eq];
				break;
			}
		}
		return cual;
	}
	
	/** Calcula los puntos, goles y partidos ganados/empatados/perdidos de todos los equipos.
	 * Recorre las jornadas de la 0 a la última indicada y todos sus partidos, sumando
	 * 3 puntos por victoria y 1 por empate y ninguno por derrota.
	 * @param ultJornada	Última jornada a considerar
	 */
	public void calcPuntos( int ultJornada ) {
		for (Equipo eq : equipo) eq.init();  // Inicia todos los puntos a 0
		for (int jor=0; jor < Math.min( ultJornada+1, liga.getJornadas() ); jor++) {
			for (int par=0; par<liga.getPartidos(); par++) {
				Partido p = liga.getPartido( jor, par );
				Equipo equipo1 = buscaEnArray( p.getE1().getNombre());
				Equipo equipo2 = buscaEnArray( p.getE2().getNombre() );
				equipo1.calculaPartido( p );
				equipo2.calculaPartido( p );
			}
		}
	}

	// Reordena el array de equipos de acuerdo a los puntos de cada uno
	public void ordenaEquiposPorPuntos() {
		for (int i=0; i<equipo.length-1; i++) {
			for (int j=0; j<equipo.length-i-1; j++) {
				if (!equipo[j].esMejorQue(equipo[j+1])) { 
					Equipo eqTemp = equipo[j];
					equipo[j] = equipo[j+1];
					equipo[j+1] = eqTemp;
				}
			}
		}
	}

}