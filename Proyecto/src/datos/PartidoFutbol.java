package datos;

import datos.Partido;

public class PartidoFutbol extends Partido {

	private int golesEquipoL;
	private int golesEquipoV;
	
	public PartidoFutbol(String nomEquipoL, String nomEquipoV, int golesEquipoL, int golesEquipoV) {
		super( nomEquipoL, nomEquipoV );
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

	public void setGolesEquipoV(int golesEquipoV) {
		this.golesEquipoV = golesEquipoV;
	}
	
	@Override
	public String toString() {
		return nomEquipoL + " - " + nomEquipoV + ": " + golesEquipoL + "-" + golesEquipoV;
	}
	
}