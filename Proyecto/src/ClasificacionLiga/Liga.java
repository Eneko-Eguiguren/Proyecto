package ClasificacionLiga;

public class Liga {

	private static String equipo1[][] = new String[38][10];  
	private static String equipo2[][] = new String[38][10]; 
	private static int goles1[][] = new int[38][10];  
	private static int goles2[][] = new int[38][10];  

	static {  
		equipo1[0][0] = "Granada"; equipo2[0][0] = "Athletic"; goles1[0][0] = 2; goles2[0][0] = 0;
		equipo1[0][1] = "Eibar"; equipo2[0][1] = "Celta"; goles1[0][1] = 0; goles2[0][1] = 0;
		equipo1[0][2] = "Cadiz"; equipo2[0][2] = "Osasuna"; goles1[0][2] = 0; goles2[0][2] = 2;
		equipo1[0][3] = "Alaves"; equipo2[0][3] = "Betis"; goles1[0][3] = 0; goles2[0][3] = 1;
		equipo1[0][4] = "Villareal"; equipo2[0][4] = "Huesca"; goles1[0][4] = 1; goles2[0][4] = 1;
		equipo1[0][5] = "Valladolid"; equipo2[0][5] = "Real Sociedad"; goles1[0][5] = 1; goles2[0][5] = 1;
		equipo1[0][6] = "Valencia"; equipo2[0][6] = "Levante"; goles1[0][6] = 4; goles2[0][6] = 2;
		equipo1[0][7] = "Real Madrid"; equipo2[0][7] = "Getafe"; goles1[0][7] = 1; goles2[0][7] = 0;
		equipo1[0][8] = "Atletico de Madrid"; equipo2[0][8] = "Sevilla"; goles1[0][8] = 0; goles2[0][8] = 0;
		equipo1[0][9] = "Barcelona"; equipo2[0][9] = "Elche"; goles1[0][9] = 0; goles2[0][9] = 0;

	}

	public static String getEquipo1(int numJornada, int numPartido ) {
		return equipo1[numJornada][numPartido];
	}

	public static String getEquipo2(int numJornada, int numPartido ) {
		return equipo2[numJornada][numPartido];
	}

	public static int getGoles1( int numJornada, int numPartido ) {
		return goles1[numJornada][numPartido];
	}

	public static int getGoles2( int numJornada, int numPartido ) {
		return goles2[numJornada][numPartido];
	}

	public static int getJornadas() {
		int jornadasJugadas=0;
		for (int i=0;i<equipo1.length;i++) {
			if (equipo1[i][0]==null) {
				break;
			}
			jornadasJugadas++;
		}
		return jornadasJugadas;
	}
}