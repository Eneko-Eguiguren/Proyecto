package ClasificacionLiga;


public class Equipo {
	
	private String nombre;
	private int puntos;

	public Equipo(String nombre){
		
		this.setNombre(nombre);
		this.setPuntos(0);
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public void setPuntos(int puntos){
		this.puntos=puntos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void incPuntos(int incremento) {
		this.puntos+=incremento;
	}

	public String toString() {
		return "Equipo: " + this.nombre + " Puntos: "+ this.puntos;
	}
	
	public static void main(String[] args) {
		Equipo barca = new Equipo("Athletic");
		barca.incPuntos(3);
		System.out.println(barca);;
	}

}
