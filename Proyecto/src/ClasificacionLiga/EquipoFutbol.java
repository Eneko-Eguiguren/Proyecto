package ClasificacionLiga;

import ClasificacionLiga.Equipo;
import ClasificacionLiga.EquipoFutbol;
import ClasificacionLiga.Partido;
import ClasificacionLiga.PartidoFutbol;

public class EquipoFutbol extends Equipo {

	private static String[] CABS_CLASIF = { "Puesto", "Equipo", "Ptos.", "GF", "GC", "DG", "PG/PE/PP" };      
	private static int[] COLS_CLASIF =    { 80,        180,     80,      80,   80,   100,  200 };  

	public String[] getCabs() { return CABS_CLASIF; }
	public int[] getCols() { return COLS_CLASIF; }
	
	private int gf; 
	private int gc; 
	private int pg; 
	private int pe; 
	private int pp; 
	
	/** Construye un equipo nuevo
	 * @param nombre	Nombre del equipo
	 */
	public EquipoFutbol( String nombre ) {
		super( nombre );
	}

	public void init() {
		super.init();
		gf = 0;
		gc = 0;
		pg = 0;
		pe = 0;
		pp = 0;
	}
	
	public int getGf() {
		return gf;
	}

	public void setGf(int gf) {
		this.gf = gf;
	}

	public void incGf(int gf) {
		this.gf += gf;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public void incGc(int gc) {
		this.gc += gc;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public void incPg(int pg) {
		this.pg += pg;
	}

	public int getPe() {
		return pe;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}

	public void incPe(int pe) {
		this.pe += pe;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public void incPp(int pp) {
		this.pp += pp;
	}

	@Override
	public void calculaPartido( Partido p ) {
		if (!(p instanceof PartidoFutbol)) return; 
		PartidoFutbol pf = (PartidoFutbol) p;
		if (nombre.equals(p.getNomEquipoL())) { 
			incGf( pf.getGolesEquipoL() );
			incGc( pf.getGolesEquipoV() );
			if (pf.getGolesEquipoL() > pf.getGolesEquipoV()) { 
				incPuntos(3);
				incPg(1);
			} else if (pf.getGolesEquipoL() < pf.getGolesEquipoV()) {  
				incPp(1);
			} else { 
				incPuntos(1);
				incPe(1);
			}
		} else { 
			incGf( pf.getGolesEquipoV() );
			incGc( pf.getGolesEquipoL() );
			if (pf.getGolesEquipoL() > pf.getGolesEquipoV()) {  
				incPp(1);
			} else if (pf.getGolesEquipoL() < pf.getGolesEquipoV()) {  
				incPuntos(3);
				incPg(1);
			} else { 
				incPuntos(1);
				incPe(1);
			}
		}
	}
	
	@Override
	public boolean esMejorQue( Equipo e2 ) {
		if (!(e2 instanceof EquipoFutbol)) return false;  
		EquipoFutbol ef = (EquipoFutbol) e2;
		if (puntos > e2.puntos) return true;
		if (puntos < e2.puntos) return false; 
		return gf-gc > ef.gf-ef.gc;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + gf + " GF y " + gc + " GC. PG/E/P = " + pg + "/" + pe + "/" + pp;
	}
	
}
