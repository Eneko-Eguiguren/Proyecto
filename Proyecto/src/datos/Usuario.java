package datos;

import java.util.ArrayList;

public class Usuario {
	

	public String nombre;
	public String contrase�a;
	public int codigo;
	public ArrayList<Equipo> equiposFavoritos = new ArrayList<Equipo>(); 
	public ArrayList<Competicion> competicionesFavoritas =  new ArrayList<Competicion>(); ;
	
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
	public ArrayList<Equipo> getEquiposFavoritos() {
		return equiposFavoritos;
	}
	public void setEquiposFavoritos(ArrayList<Equipo> equiposFavoritos) {
		this.equiposFavoritos = equiposFavoritos;
	}
	public ArrayList<Competicion> getCompeticionesFavoritas() {
		return competicionesFavoritas;
	}
	public void setCompeticionesFavoritas(ArrayList<Competicion> competicionesFavoritas) {
		this.competicionesFavoritas = competicionesFavoritas;
	} 
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Usuario) {
			if (this.nombre == ((Usuario) o).getNombre() && this.codigo== ((Usuario) o).getCodigo()) {
				igual = true; 
		}
			}
		return igual;
	}
}
