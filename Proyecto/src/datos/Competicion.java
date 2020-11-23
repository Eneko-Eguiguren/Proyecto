package datos;

import java.util.ArrayList;

public class Competicion {
	
	public ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	public String nombre;
	public Equipo ganador;
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Competicion (ArrayList<Equipo> equipos, String nombre, Equipo ganador ) {
		this.equipos = equipos;
		this.nombre = nombre;
		this.ganador = ganador;
	}

}
