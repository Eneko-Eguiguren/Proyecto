package datos;

import java.util.ArrayList;

public class Torneo extends Competicion{

	public Equipo semifinalista;
	public Torneo(ArrayList<Equipo> equipos, String nombre, Equipo ganador, Equipo semifinalista) {
		super(equipos, nombre, ganador);
		this.semifinalista = semifinalista;
		
	}
	public Equipo getSemifinalista() {
		return semifinalista;
	}
	public void setSemifinalista(Equipo semifinalista) {
		this.semifinalista = semifinalista;
	}
	
}
