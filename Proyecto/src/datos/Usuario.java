package datos;

import java.util.ArrayList;

import BD.ExtraccionBD;

public class Usuario {
	

	public String nombre;  //nombre del usuari@
	public String contraseña;  //contraseña elegida por el/la usuari@
	public int codigo;  //codigo del usuari@
	public ArrayList<Equipo> equiposFavoritos = new ArrayList<Equipo>();   //equipos favoritos elegidos por el/la usuari@
	public ArrayList<Competicion> competicionesFavoritas =  new ArrayList<Competicion>(); ;  //competiciones favoritas elegidas por el/la usuari@
	
	/**
	 * Construye un usuario con los datos indicados.
	 * @param nom nombre del usuari@
	 * @param contr contraseña creada por el/la usuari@
	 * @param cod codigo relaccionado al usuari@
	 */
	public Usuario(String nom, String contr, int cod) {
		this.nombre = nom;
		this.contraseña = contr;
		this.codigo = cod;
	}
	/**
	 * Obtiene el nombre de el/la usuari@
	 * @return el nombre de el/la usuari@
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene la contraseña de el/la usuari@
	 * @return la contraseña de el/la usuari@
	 */
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	/**
	 * Obtiene el equipo favorito de el/la usuari@
	 * @return el equipo favorito de el/la usuari@
	 */
	public ArrayList<Equipo> getEquiposFavoritos() {
		return equiposFavoritos;
	}
	public void setEquiposFavoritos(ArrayList<Equipo> equiposFavoritos) {
		this.equiposFavoritos = equiposFavoritos;
	}
	/**
	 * Obtiene la competicion favorita de el/la usuari@
	 * @return la competicion favorita de el/la usuari@
	 */
	public ArrayList<Competicion> getCompeticionesFavoritas() {
		return competicionesFavoritas;
	}
	public void setCompeticionesFavoritas(ArrayList<Competicion> competicionesFavoritas) {
		this.competicionesFavoritas = competicionesFavoritas;
	}
	//añade las competiciones favoritas de el/la usuari@
	public void anyadirCompeticionesFavoritas(Competicion comp) {
		this.competicionesFavoritas.add(comp);
	}
	//añade los equipos favoritos de el/la usuari@
	public void anyadirEquiposFavoritos(Equipo equipo) {
		this.equiposFavoritos.add(equipo);
	}
	/**
	 * Obtiene el codigo de el/la usuari@
	 * @return el codigo de el/la usuari@
	 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Usuario) {
			if (this.nombre.equals(((Usuario) o).getNombre()) && this.codigo== ((Usuario) o).getCodigo()) {
				igual = true; 
		}
			}
		return igual;
	}
}