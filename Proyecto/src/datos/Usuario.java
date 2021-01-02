package datos;

import java.util.ArrayList;

public class Usuario {
	

	public String nombre;
	public String contrase�a;
	public int codigo;
	public ArrayList<String> equiposFavoritos ; // Array de equipos, no de strings
	public ArrayList<String> competicionesFavoritas ;
	
	public Usuario(String nom, String contr, int cod) {
		this.nombre = nom;
		this.contrase�a = contr;
		this.codigo = cod;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
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
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
