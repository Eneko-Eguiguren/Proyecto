package datos;

import java.util.ArrayList;

public class Año {

	public ArrayList<String> competicionesAnyo ; // Cambiar String por competicion.
	public int anyo ;
	public ArrayList<String> getCompeticionesAnyo() {
		return competicionesAnyo;
	}
	public void setCompeticionesAnyo(ArrayList<String> competicionesAnyo) {
		this.competicionesAnyo = competicionesAnyo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
}
