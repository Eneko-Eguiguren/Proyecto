package datos;

import java.util.ArrayList;

public class Usuario {

	public String nombre;
	public char[] contraseña;
	public ArrayList<String> equiposFavoritos ; // Array de equipos, no de strings
	public ArrayList<String> competicionesFavoritas ;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char[] getContraseña() {
		return contraseña;
	}
	public void setContraseña(char[] contraseña) {
		this.contraseña = contraseña;
	}
	public ArrayList<String> getEquiposFavoritos() {
		return equiposFavoritos;
	}
	public void setEquiposFavoritos(ArrayList<String> equiposFavoritos) {
		this.equiposFavoritos = equiposFavoritos;
	}
	public ArrayList<String> getCompeticionesFavoritas() {
		return competicionesFavoritas;
	}
	public void setCompeticionesFavoritas(ArrayList<String> competicionesFavoritas) {
		this.competicionesFavoritas = competicionesFavoritas;
	} 
	
	
}
