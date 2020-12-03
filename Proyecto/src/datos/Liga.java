package datos;


import datos.Liga;
import datos.Partido;
import datos.PartidoFutbol;

public class Liga extends Competicion{

	//public static final Liga LIGA_FUTBOL_EJEMPLO;

	private static String equipoFut1[][] = new String[38][10];  // Equipo 1 de cada partido [jornada][partido] (jornada de 0 a 37, partido de 0 a 9)
	private static String equipoFut2[][] = new String[38][10];  // Equipo 2 de cada partido [jornada][partido] (jornada de 0 a 37, partido de 0 a 9)
	private static int golesFut1[][] = new int[38][10];  // Goles de equipo 1 de cada partido [jornada][partido] (jornada de 0 a 37, partido de 0 a 9)
	private static int golesFut2[][] = new int[38][10];  // Goles de equipo 2 de cada partido [jornada][partido] (jornada de 0 a 37, partido de 0 a 9)
	
	static {
		initDesdeTabla();  // Carga los resultados desde una tabla de memoria
		//LIGA_FUTBOL_EJEMPLO = new Liga( "fútbol", equipoFut1, equipoFut2, golesFut1, golesFut2 );
			}
	
	/** Test de jornadas de liga de fútbol
	 * @param args
	 */
	public static void main(String[] args) {
		// Ejemplo de un partido
		int jornada = 0; int partido = 0;
		System.out.println( "Ejemplo de jornada " + jornada + " - partido " + partido );
		Partido p = LIGA_FUTBOL_EJEMPLO.getPartido( jornada, partido );
		System.out.println( p );
		for (int jor = 0; jor < LIGA_FUTBOL_EJEMPLO.getJornadas(); jor++) {
			System.out.println( "Jornada " + (jor+1) );
			for (int par = 0; par < LIGA_FUTBOL_EJEMPLO.getPartidos(); par++) {
				System.out.println( "  " + LIGA_FUTBOL_EJEMPLO.getPartido( jor, par ) );
			}
			System.out.println();
		}
	}

	private static void initDesdeTabla() {
		equipoFut1[0][0] = "Eibar"; equipoFut2[0][0] = "Celta"; golesFut1[0][0] = 0; golesFut2[0][0] = 0;
		equipoFut1[0][1] = "Granada"; equipoFut2[0][1] = "Athletic"; golesFut1[0][1] = 2; golesFut2[0][1] = 0;
		equipoFut1[0][2] = "Cadiz"; equipoFut2[0][2] = "Osasuna"; golesFut1[0][2] = 0; golesFut2[0][2] = 2;
		equipoFut1[0][3] = "Alaves"; equipoFut2[0][3] = "Betis"; golesFut1[0][3] = 0; golesFut2[0][3] = 1;
		equipoFut1[0][4] = "Valladolid"; equipoFut2[0][4] = "R.Sociedad"; golesFut1[0][4] = 1; golesFut2[0][4] = 1;
		equipoFut1[0][5] = "Villareal"; equipoFut2[0][5] = "S.D.Huesca"; golesFut1[0][5] = 1; golesFut2[0][5] = 1;
		equipoFut1[0][6] = "Valencia"; equipoFut2[0][6] = "Levante"; golesFut1[0][6] = 4; golesFut2[0][6] = 2;
		equipoFut1[0][7] = "Atletico"; equipoFut2[0][7] = "Sevilla"; golesFut1[0][7] = 1; golesFut2[0][7] = 0;
		equipoFut1[0][8] = "R.Madrid"; equipoFut2[0][8] = "Getafe"; golesFut1[0][8] = 0; golesFut2[0][8] = 0;
		equipoFut1[0][9] = "Barcelona"; equipoFut2[0][9] = "Elche"; golesFut1[0][9] = 0; golesFut2[0][9] = 0;
		
		equipoFut1[1][0] = "Villareal"; equipoFut2[1][0] = "Eibar"; golesFut1[1][0] = 1; golesFut2[1][0] = 1;
		equipoFut1[1][1] = "Getafe"; equipoFut2[1][1] = "Osasuna"; golesFut1[1][1] = 0; golesFut2[1][1] = 3;
		equipoFut1[1][2] = "Celta"; equipoFut2[1][2] = "Valencia"; golesFut1[1][2] = 1; golesFut2[1][2] = 2;
		equipoFut1[1][3] = "S.D.Huesca"; equipoFut2[1][3] = "Cadiz"; golesFut1[1][3] = 0; golesFut2[1][3] = 0;
		equipoFut1[1][4] = "Granada"; equipoFut2[1][4] = "Alaves"; golesFut1[1][4] = 3; golesFut2[1][4] = 1;
		equipoFut1[1][5] = "Betis"; equipoFut2[1][5] = "Valladolid"; golesFut1[1][5] = 0; golesFut2[1][5] = 0;
		equipoFut1[1][6] = "R.Sociedad"; equipoFut2[1][6] = "R.Madrid"; golesFut1[1][6] = 1; golesFut2[1][6] = 0;
		equipoFut1[1][7] = "R.Madrid"; equipoFut2[1][7] = "Getafe"; golesFut1[1][7] = 3; golesFut2[1][7] = 0;
		equipoFut1[1][8] = "Barcelona"; equipoFut2[1][8] = "Athletic"; golesFut1[1][8] = 5; golesFut2[1][8] = 0;
		equipoFut1[1][9] = "Sevilla"; equipoFut2[1][9] = "Elche"; golesFut1[1][9] = 2; golesFut2[1][9] = 0;
		   
		equipoFut1[2][0] = "Alaves"; equipoFut2[2][0] = "Getafe"; golesFut1[2][0] = 1; golesFut2[2][0] = 3;
		equipoFut1[2][1] = "Valencia"; equipoFut2[2][1] = "S.D.Huesca"; golesFut1[2][1] = 0; golesFut2[2][1] = 0;
		equipoFut1[2][2] = "Elche"; equipoFut2[2][2] = "R.Sociedad"; golesFut1[2][2] = 3; golesFut2[2][2] = 3;
		equipoFut1[2][3] = "Betis"; equipoFut2[2][3] = "R.Madrid"; golesFut1[2][3] = 3; golesFut2[2][3] = 1;
		equipoFut1[2][4] = "Osasuna"; equipoFut2[2][4] = "Levante"; golesFut1[2][4] = 1; golesFut2[2][4] = 3;
		equipoFut1[2][5] = "Eibar"; equipoFut2[2][5] = "Athletic"; golesFut1[2][5] = 1; golesFut2[2][5] = 0;
		equipoFut1[2][6] = "Atletico"; equipoFut2[2][6] = "Granada"; golesFut1[2][6] = 1; golesFut2[2][6] = 2;
		equipoFut1[2][7] = "Valladolid"; equipoFut2[2][7] = "Celta"; golesFut1[2][7] = 0; golesFut2[2][7] = 1;
		equipoFut1[2][8] = "Cadiz"; equipoFut2[2][8] = "Sevilla"; golesFut1[2][8] = 0; golesFut2[2][8] = 6;
		equipoFut1[2][9] = "Barcelona"; equipoFut2[2][9] = "Villareal"; golesFut1[2][9] = 1; golesFut2[2][9] = 1;
		
	}
	
	private String deporte;        
	private String equipoL[][];    // Equipo local de cada partido [jornada][partido]
	private String equipoV[][];    // Equipo local de cada partido [jornada][partido]
	private int puntosL[][];       // Goles-tantos-puntos de equipo local de cada partido [jornada][partido]
	private int puntosV[][];       // Goles-tantos-puntos de equipo visitante de cada partido [jornada][partido]
	private double subpuntosL[][]; // Subpuntos de equipo local de cada partido [jornada][partido]
	private double subpuntosV[][]; // Subpuntos de equipo visitante de cada partido [jornada][partido]

//	public Liga( String deporte, String equipoL[][], String equipoV[][], int puntosL[][], int puntosV[][], double subpuntosL[][], double subpuntosV[][] ) {
//		this.deporte = deporte;
//		this.equipoL = equipoL;
//		this.equipoV = equipoV;
//		this.puntosL = puntosL;
//		this.puntosV = puntosV;
//		this.subpuntosL = subpuntosL;
//		this.subpuntosV = subpuntosV;
//	}

//	public Liga( String deporte, String equipoL[][], String equipoV[][], int puntosL[][], int puntosV[][] ) {
//		this.deporte = deporte;
//		this.equipoL = equipoL;
//		this.equipoV = equipoV;
//		this.puntosL = puntosL;
//		this.puntosV = puntosV;
//		this.subpuntosL = null;
//		this.subpuntosV = null;
//	}

	public String getDeporte() {
		return deporte;
	}

	public Partido getPartido( int numJornada, int numPartido ) {
		if (equipoL[numJornada][numPartido]==null) return null;
		if (deporte.equals("fútbol")) {
//			PartidoFutbol ret = new PartidoFutbol( 
//					equipoL[numJornada][numPartido], 
//					equipoV[numJornada][numPartido], 
//					puntosL[numJornada][numPartido],
//					puntosV[numJornada][numPartido] );
			return null;
		}
		return null;
	}
	
	/** Devuelve el número de jornadas disputadas
	 * @return
	 */
	public int getJornadas() {
		int ultJor = 0;
		while (ultJor < equipoL.length && equipoL[ultJor][0]!=null) ultJor++;
		return ultJor;
	}
	
	/** Devuelve el número de equipos de la liga
	 * @return	Número de equipos
	 */
	public int getNumEquipos() {
		return equipoL[0].length * 2;
	}

	public int getPartidos() {
		return equipoL[0].length;
	}
	
}