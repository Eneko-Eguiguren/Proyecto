package datos;

import java.util.ArrayList;

public class Usuario {

	public int nombre;
	public String contrase�a;
	public ArrayList<String> equiposFavoritos ; // Array de equipos, no de strings
	public ArrayList<String> competicionesFavoritas ;
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
