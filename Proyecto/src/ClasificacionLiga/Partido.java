package ClasificacionLiga;

public abstract class Partido {
	protected String nomEquipoL;
	protected String nomEquipoV;
	
	public Partido(String nomEquipoL, String nomEquipoV ) {
		this.nomEquipoL = nomEquipoL;
		this.nomEquipoV = nomEquipoV;
	}

	public String getNomEquipoL() {
		return nomEquipoL;
	}

	public void setNomEquipoL(String nomEquipoL) {
		this.nomEquipoL = nomEquipoL;
	}

	public String getNomEquipoV() {
		return nomEquipoV;
	}

	public void setNomEquipoV(String nomEquipoV) {
		this.nomEquipoV = nomEquipoV;
	}

}
