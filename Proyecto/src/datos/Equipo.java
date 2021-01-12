package datos;

import java.util.ArrayList;

public class Equipo {
	public int codigo;
	public String nombre;
	public ArrayList<Jugador> jugsDeEquipo;
	
	public Equipo(int code, String name) {
		this.codigo = code;
		this.nombre = name;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getJugsDeEquipo() {
		return jugsDeEquipo;
	}

	public void setJugsDeEquipo(ArrayList<Jugador> jugsDeEquipo) {
		this.jugsDeEquipo = jugsDeEquipo;
	}
	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Equipo) {
			if (this.nombre == ((Equipo) o).getNombre() && this.codigo== ((Equipo) o).getCodigo() ) {
				igual = true; 
		}
			}
		return igual;
	}
}
