package datos;

import java.util.ArrayList;

import BD.ExtraccionBD;

public class Competicion {
	
	public String nombre;
	public int codigo;
	public int anyo;
	public String pais;
	public Equipo ganador;
	public Equipo subcampeon;
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public Equipo getSubcampeon() {
		return subcampeon;
	}

	public void setSubcampeon(Equipo subcampeon) {
		this.subcampeon = subcampeon;
	}
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Competicion ( String nombre, int cod_comp, int anyo,String pais, Equipo camp, Equipo subcamp) {
		
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
