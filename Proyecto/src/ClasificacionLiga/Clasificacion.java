package ClasificacionLiga;

public class Clasificacion {
	private Equipo equipos[] = new Equipo[20];

	public void creaArrayEquipos() {
		if (Liga.getJornadas()>0) {
			for (int i=0;i<=9;i++) {
				String nombre1=Liga.getEquipo1(0, i);
				String nombre2=Liga.getEquipo2(0, i);
				Equipo eq1 = new Equipo(nombre1);
				Equipo eq2 = new Equipo(nombre2);
				equipos[2*i]=eq1;
				equipos[2*i+1]=eq2;
			}
		}
		else {
			System.out.println("No se ha jugado ninguna jornada");
			}
	}
	public void visualizaEquipos() {
		for (Equipo i:equipos) {
			System.out.println(i);
		}
	}
	public Equipo buscaEnArray(String nomEquipo) {
		Equipo result=null;
		for (Equipo i:equipos) {
			if (nomEquipo==i.getNombre()) {
				result=i;
				break;
			}
		}
		return result;
	}
	public void calcPuntos() {
		for (int i=0;i<Liga.getJornadas();i++) {
			for (int j=0;j<=9;j++) {
				if (Liga.getGoles1(i,j)>Liga.getGoles2(i, j)) {
					Equipo eqGanador=buscaEnArray(Liga.getEquipo1(i, j));
					eqGanador.incPuntos(3);
				}
				else if (Liga.getGoles2(i,j)>Liga.getGoles1(i, j)) {
					Equipo eqGanador=buscaEnArray(Liga.getEquipo2(i, j));
					eqGanador.incPuntos(3);
				}
				else {
					Equipo eq1=buscaEnArray(Liga.getEquipo1(i, j));
					eq1.incPuntos(1);
					Equipo eq2=buscaEnArray(Liga.getEquipo2(i, j));
					eq2.incPuntos(1);
					
				}
			}
		}
	}

	public void ordenaEquiposPorPuntos() {
		int n= equipos.length;
		for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (equipos[j].getPuntos() < equipos[j+1].getPuntos()) 
                { 
                    Equipo temp = equipos[j]; 
                    equipos[j] = equipos[j+1]; 
                    equipos[j+1] = temp; 
                } 
	}
	
	public static void main(String[] args) {
		Clasificacion clasif = new Clasificacion();
		clasif.creaArrayEquipos();
		clasif.calcPuntos();
		System.out.println( "Equipos:" );
		clasif.visualizaEquipos();
		clasif.ordenaEquiposPorPuntos();
		System.out.println( "Clasificación:" );
		clasif.visualizaEquipos();

	}

}
