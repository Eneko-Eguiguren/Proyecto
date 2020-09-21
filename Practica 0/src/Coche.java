
public class Coche {
	private double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	public double getMiVelocidad() {
		return miVelocidad;
	}
	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}
	public double getMiDireccionActual() {
		return miDireccionActual;
	}
	public void setMiDireccionActual(double dir) {
		if (dir < 0.0D) {
	         dir += 360.0D;
	      }

	      if (dir > 360.0D) {
	         dir -= 360.0D;
	      }

	      this.miDireccionActual = dir;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {

		this.piloto = piloto;
	}
	public void setPosicion(double posX, double posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}
	private String piloto; // Nombre de piloto
	public String toString() {
	      return this.piloto + " (" + this.posX + "," + this.posY + ") - " + "Velocidad: " + this.miVelocidad + " ## Dirección: " + this.miDireccionActual;
	   }
	/** Cambia la velocidad actual de el coche 
	 * @param aceleracion Incremento de la velocidad, en pixels/segundo
	 */
	public void acelera(double aceleracion) {
		this.miVelocidad = this.miVelocidad + aceleracion;
	}
	/** Cambia la direccion actual de el coche
	 * @param giro Angulo de giro a sumar o restar al actual, en grados (-180 a +180)
	 */
	public void gira(double giro) {
		this.miDireccionActual = this.miDireccionActual + giro ;
	}
	/** Cambia la posición del coche dependiendo de su velocidad y dirección 
	 * @param tiempoMovimiento Tiempo transcurrido, en segundos
	 */
	public void mueve(double tiempoMovimiento) {
		this.setPosX(this.posX + (this.miVelocidad * Math.cos(this.miDireccionActual / 180.0D * 3.141592653589793D) * tiempoMovimiento));
		this.setPosY(this.posY + (this.miVelocidad * Math.sin(this.miDireccionActual / 180.0D * 3.141592653589793D) * tiempoMovimiento));
	}
}
