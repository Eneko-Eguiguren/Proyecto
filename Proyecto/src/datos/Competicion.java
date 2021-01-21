package datos;

import java.util.ArrayList;

import BD.ExtraccionBD;

public class Competicion {
	
	public String nombre;  //nombre de la competicion
	public int codigo;  //codigo de la competicion
	public int anyo;  //año en el que se celebra la competicion
	public String pais;  //pais en el que se celebra la competicion
	public Equipo ganador;  //equipo que gano la competicion
	public Equipo subcampeon;  //equipo que quedo en segunda posicion en la competicion
	
	/**
	 * Obtiene el pais en el que se celebra la competicion
	 * @return el pais en el que se celebra la competicion
	 */
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * Obtiene el ganador de la competicion
	 * @return el ganador de la competicion
	 */
	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	/**
	 * Obtiene el segundo clasificado de la competicion
	 * @return el segundo clasificado de la competicion
	 */
	public Equipo getSubcampeon() {
		return subcampeon;
	}

	public void setSubcampeon(Equipo subcampeon) {
		this.subcampeon = subcampeon;
	}
	/**
	 * Obtiene el nombre de la competicion
	 * @return el nombre de la competicion
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Construye una competicion con los datos indicados.
	 * @param nombre nombre de la conpeticion
	 * @param cod_comp codigo de la competicion
	 * @param anyo año de la celebracion de la constelaciÃ³n
	 * @param pais pais donde se celebra la competicion 
	 * @param camp equipo ganador de la competicion
	 * @param subcamp equipo que ha quedado segundo en la competicion
	 */
	public Competicion ( String nombre, int cod_comp, int anyo,String pais, Equipo camp, Equipo subcamp) {
		
		this.nombre = nombre;
		this.codigo = cod_comp;
		this.anyo = anyo;
		this.pais = pais;
		this.ganador = camp;
		this.subcampeon = subcamp;
	}
	/**
	 * Obtiene el codigo que identifica a la competicion
	 * @return el codigo que identifica a la competicion
	 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * Obtiene el año en el que se juega la competicion
	 * @return el año en el que se juega la competicion
	 */
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