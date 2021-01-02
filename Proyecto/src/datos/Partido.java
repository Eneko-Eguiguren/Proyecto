package datos;

public abstract class Partido {
	protected Equipo e1;
	protected Equipo e2;
	public int cod_equipo;
	public int anyo;
	public Partido(Equipo eq1,Equipo eq2 ) {
		this.e1 = eq1;
		this.e2 = eq2;
	}

	public Equipo getE1() {
		return e1;
	}

	public void setE1(Equipo e1) {
		this.e1 = e1;
	}

	public Equipo getE2() {
		return e2;
	}

	public void setE2(Equipo e2) {
		this.e2 = e2;
	}

}
