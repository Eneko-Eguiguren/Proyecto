package datos;

import java.util.ArrayList;

public class Usuario {

	public int nombre;
	public String contraseña;
	public ArrayList<String> equiposFavoritos ; // Array de equipos, no de strings
	public ArrayList<String> competicionesFavoritas ;
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
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
