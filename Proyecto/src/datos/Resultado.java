package datos;

public class Resultado {
	public EquipoFutbol e1 ;
	public EquipoFutbol e2 ;
	public Liga competicion;
	public int jornada;
	
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
	public EquipoFutbol getE1() {
		return e1;
	}
	public void setE1(EquipoFutbol e1) {
		this.e1 = e1;
	}
	public EquipoFutbol getE2() {
		return e2;
	}
	public void setE2(EquipoFutbol e2) {
		this.e2 = e2;
	}
	public Liga getCompeticion() {
		return competicion;
	}
	public void setCompeticion(Liga competicion) {
		this.competicion = competicion;
	} 
}
