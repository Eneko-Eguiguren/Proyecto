import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BD.ExtraccionBD;

class ExtraccionBDtest {

	@Test
	void AddRelacionesTest() {
		try {
			ExtraccionBD.addUsuarioCompeticionBD(ExtraccionBD.getNomUsuarios().get(4), ExtraccionBD.getNomCompeticiones().get(7), ExtraccionBD.getAnyoCompeticion(ExtraccionBD.getNomCompeticiones().get(7)).get(1));
		} catch (Exception e) {
			fail("Hay excepciones.");
		} 
		try {
			ExtraccionBD.addEquipoCompeticionBD(ExtraccionBD.getEquipos().get(2).getNombre(), ExtraccionBD.getNomCompeticiones().get(4), ExtraccionBD.getAnyoCompeticion(ExtraccionBD.getNomCompeticiones().get(4)).get(1));
		} catch (Exception e) {
			fail("Hay excepciones.");
		}
	}
	@Test
	void AddUsuariosTest() {
		int numeroUsuarios = ExtraccionBD.getNomUsuarios().size();
		try {
			ExtraccionBD.addUsuarioBD("Prueba2", "1234", numeroUsuarios+1);
		} catch (Exception e) {
			
		}
		if(numeroUsuarios == ExtraccionBD.getNomUsuarios().size()) {
			System.out.println(numeroUsuarios);
			System.out.println(ExtraccionBD.getNomUsuarios().size());
			fail("El usuario no se ha añadido");
		}
	}
	@Test
	void AddEquiposTest() {
		int numeroEquipos = ExtraccionBD.getNomEquipos().size();
		try {
			ExtraccionBD.addEquiposBD(numeroEquipos+1, "Prueba");
		} catch (Exception e) {
			fail("Hay excepciones.");
		}
		if(numeroEquipos== ExtraccionBD.getNomUsuarios().size()) {
			fail("El usuario no se ha añadido");
		}
	}
}
