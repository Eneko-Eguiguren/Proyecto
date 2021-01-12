package datos;

public class Jugador {

	public String nombre;
	public int cod_equipo;
	public int numero;
	public int edad;
	public Jugador(String nom,int cEquipo, int num, int edad) {
		this.nombre = nom;
		this.cod_equipo = cEquipo;
		this.numero = num;
		this.edad = edad;
		
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEquipo() {
		return cod_equipo;
	}
	public void setEquipo(int cequipo) {
		this.cod_equipo = cequipo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
		//
	}
	public boolean equals(Object o) {
		boolean igual = false;
		if (o instanceof Jugador) {
			if (this.nombre == ((Jugador) o).getNombre() && this.cod_equipo== ((Jugador) o).getEdad()) {
				igual = true; 
		}
			}
		return igual;
	}
}
