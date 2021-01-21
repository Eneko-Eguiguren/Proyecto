package datos;

import java.util.ArrayList;

public class Equipo {
	public int codigo;  //codigo del equipo
	public String nombre;  //codigo del nombre del equipo
//jugadores del equipo
	
	/**
	 * Construye un equipo con los datos indicados.
	 * @param code codigo del equipo
	 * @param name nombre del equipo
	 */
	public Equipo(int code, String name) {
		this.codigo = code;
		this.nombre = name;

	}
	/**
	 * Obtiene el codigo del equipo
	 * @return el codigo del equipo
	 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * Obtiene el nombre del equipo
	 * @return el nombre del equipo
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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