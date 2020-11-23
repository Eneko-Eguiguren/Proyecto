package datos;

import datos.Partido;

public class PartidoFutbol extends Partido {

	private int golesEquipoL;
	private int golesEquipoV;
	private Equipo e1;
	private Equipo e2;
	
	public PartidoFutbol(Equipo eq1, Equipo eq2, int golesEquipoL, int golesEquipoV) {
		super( eq1, eq2 );
		this.e1 = eq1;
		this.e2 = eq2;
		this.golesEquipoL = golesEquipoL;
		this.golesEquipoV = golesEquipoV;
	}

	public int getGolesEquipoL() {
		return golesEquipoL;
		
	}

	public void setGolesEquipoL(int golesEquipoL) {
		this.golesEquipoL = golesEquipoL;
	}

	public int getGolesEquipoV() {
		return golesEquipoV;
	}

	public Equipo getE1() {
		return e1;
	}

	public void setE1(Equipo e1) {
		this.e1 = e1;
	}

	public Equipo getE2() {
		return e2;
	}

	public void setE2(Equipo e2) {
		this.e2 = e2;
	}

	public void setGolesEquipoV(int golesEquipoV) {
		this.golesEquipoV = golesEquipoV;
	}
	
	@Override
	public String toString() {
		return e1.getNombre() + " - " + e2.getNombre() + ": " + golesEquipoL + "-" + golesEquipoV;
	}
	
}