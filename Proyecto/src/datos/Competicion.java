package datos;

import java.util.ArrayList;

import BD.ExtraccionBD;

public class Competicion {
	
	public ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	public String nombre;
	public int codigo;
	public int anyo;
	public String pais;
	public Equipo ganador;
	public Equipo subcampeon;
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

	public Competicion (ArrayList<Equipo> equipos, String nombre, int cod_comp, int anyo,String pais, Equipo camp, Equipo subcamp) {
		this.equipos = equipos;
		this.nombre = nombre;
		this.codigo = cod_comp;
		this.anyo = anyo;
		this.pais = pais;
		this.ganador = camp;
		this.subcampeon = subcamp;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Competicion) {
			if (this.nombre == ((Competicion) o).getNombre() && this.codigo== ((Competicion) o).getCodigo()) {
				igual = true; 
		}
			}
		return igual;
	}
}
