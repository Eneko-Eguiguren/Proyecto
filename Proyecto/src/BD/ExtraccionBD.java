package BD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Competicion;
import datos.Equipo;
import datos.Jugador;
import datos.Usuario;

public class ExtraccionBD {
	private static Logger logger = Logger.getLogger(ExtraccionBD.class.getName());
	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
		try {
			logger.addHandler(
					new FileHandler("src/logs/" + ExtraccionBD.class.getName() + ".log.xml", ANYADIR_A_FIC_LOG));
		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "Error en creacion fichero log");
		}
	}


	

	public static void addJugadoresBD(String n, int codequipo, int num, int edad) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;

		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO JUGADOR VALUES(" + num + ",'" + n + "'," + codequipo + "," + edad + ")");
			logger.log(Level.INFO, "Jugador a�adido a BD correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void addCompeticionBD(String n, int cod, int anyo, String pais, String c, String sc) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;

		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO COMPETICION VALUES(" + cod + ",'" + n + "','" + pais + "'," + anyo + ",'"
					+ c + "','" + sc + "');");

			logger.log(Level.INFO, "Competicion a�adida a BD correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// USUARIOS
	public static void addUsuarioBD(String nom, String contr, int cod) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO USUARIO VALUES(" + cod + ",'" + nom + "','" + contr + "')");
			logger.log(Level.INFO, "Usuario a�adido a BD correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static String getContrUsuariosPorNom(String nombre) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		String contrasenya = "hola";
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT contrase�a FROM usuario WHERE nombre = '" + nombre + "';");
			while (rs1.next()) {
				contrasenya = rs1.getString("contrase�a");
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return contrasenya;
	}

	public static Integer getCodUsuariosPorNom(String nombre) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		int codigo = 0;
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT codigo FROM usuario WHERE nombre = '" + nombre + "';");
			while (rs1.next()) {
				codigo = rs1.getInt("codigo");
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return codigo;
	}

	public static ArrayList<String> getNomUsuarios() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT nombre FROM usuario;");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}

	public static ArrayList<Integer> getCodUsuarios() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> cods = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT codigo FROM usuario;");
			while (rs1.next()) {
				cods.add(rs1.getInt("codigo"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cods;
	}

	public static ArrayList<Integer> getCodEquiposPorCodUsuario(int codusuario) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> cods = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt
					.executeQuery("SELECT cod_equipo FROM usuarioequipo WHERE cod_usuario = " + codusuario + ";");
			while (rs1.next()) {
				cods.add(rs1.getInt("cod_equipo"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cods;
	}

	public static ArrayList<String> getNomCompsPorCodUsuario(int codusuario) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery(
					"SELECT nombre FROM competicion WHERE codigo IN (SELECT cod_competicion FROM usuariocompeticion WHERE COD_USUARIO = "
							+ codusuario + ");");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}
	
	// EQUIPOS
	public static void addEquiposBD(int cod, String nombre) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO EQUIPO VALUES(" + cod + ",'" + nombre + "')");
			logger.log(Level.INFO, "Equipo a�adido a BD correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static ArrayList<String> getNomEquipos() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT nombre FROM equipo;");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}
	
	public static ArrayList<Equipo> getEquipos() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Equipo> eqs = new ArrayList<Equipo>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM equipo;");
			while (rs1.next()) {
				int cod_equipo = rs1.getInt("codigo");
				String nom_equipo = rs1.getString("nombre");
				eqs.add(new Equipo(cod_equipo, nom_equipo));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return eqs;
	}

	public static ArrayList<Integer> getCodEquipos() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> cods = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT codigo FROM equipo;");
			while (rs1.next()) {
				cods.add(rs1.getInt("codigo"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cods;
	}

	public static Equipo getEquipoPorNombre(String nombreEquipo) {

		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Equipo eq = null;
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM equipo WHERE nombre = '" + nombreEquipo + "';");
			while (rs1.next()) {
				int cod_equipo = rs1.getInt("codigo");
				String nom_equipo = rs1.getString("nombre");
				eq = new Equipo(cod_equipo, nom_equipo);
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return eq;
	}
	public static String getNomEquipoPorCod(Integer codEquipo) {

		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		String name = "null";
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT nombre FROM equipo WHERE codigo = " + codEquipo + ";");
			while (rs1.next()) {
				name = rs1.getString("nombre");
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return name;
	}

	public static ArrayList<Integer> getEquiposDeComp(String nombreCompeticion, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> cods = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT cod_equipo FROM equipocompeticion WHERE cod_competicion = (select codigo from competicion where nombre = '"+ nombreCompeticion + "' AND a�o ="+anyo+");");
			while (rs1.next()) {
				cods.add(rs1.getInt("cod_equipo"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cods;
	}
	public static Integer getTitulosEquipo(String nomEquipo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		int titulos = 0;
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT count(*) as titulos FROM program.competicion WHERE campeon ='"+ nomEquipo+"';");
			while (rs1.next()) {
				titulos = rs1.getInt("titulos");
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return titulos;
	}
	public static ArrayList<String> getCompeticionesDisputadasEnAnyo(String nomEq, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> comps = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT nombre FROM competicion WHERE a�o = "+anyo+" AND codigo IN (SELECT cod_competicion FROM equipocompeticion WHERE cod_equipo = (SELECT codigo FROM equipo WHERE nombre = '"+ nomEq+"'));");
			while (rs1.next()) {
				comps.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return comps;
	}

	// COMPETICIONES
	public static Competicion getCompeticion(String nom, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Competicion c = new Competicion(nom, 0, anyo, "", null, null);
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM competicion WHERE nombre = '"+nom+"' AND a�o = "+anyo+";");
			while (rs1.next()) {
				int cod_comp = rs1.getInt("codigo");
				String pais = rs1.getString("pais");
				String campeon = rs1.getString("campeon");
				String subcampeon = rs1.getString("subcampeon");
				Equipo camp = getEquipoPorNombre(campeon);
				Equipo subcamp = getEquipoPorNombre(subcampeon);
				c = new Competicion(nom, cod_comp, anyo, pais, camp, subcamp);
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return c;
	}
	public static ArrayList<String> getNomCompeticiones() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT nombre FROM competicion;");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}
	public static ArrayList<String> getNomCompeticionesSinRepetir() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT DISTINCT nombre FROM competicion;");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}
	public static ArrayList<String> getNomCompeticionesPorAnyo(int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT NOMBRE FROM COMPETICION WHERE A�O ="+anyo+" ;");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}

	public static ArrayList<String> getNomCompeticionesPorAnyoUsuario(String nomUsuario,int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT NOMBRE FROM COMPETICION WHERE A�O ="+anyo+" AND CODIGO IN (SELECT COD_COMPETICION FROM usuariocompeticion WHERE COD_USUARIO = (SELECT CODIGO FROM USUARIO WHERE NOMBRE = '"+nomUsuario+"'))");
			while (rs1.next()) {
				noms.add(rs1.getString("nombre"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return noms;
	}

	public static ArrayList<Integer> getCodCompeticiones() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> cods = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT codigo FROM competicion;");
			while (rs1.next()) {
				cods.add(rs1.getInt("codigo"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cods;
	}
	public static boolean isCompInFavs(String u,Competicion c) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		boolean esta = false;
		ArrayList<Integer> comp = new ArrayList<>();
		int cod_usuario = getCodUsuariosPorNom(u);
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT cod_competicion FROM usuariocompeticion WHERE COD_USUARIO = "+cod_usuario+" AND COD_COMPETICION = "+c.getCodigo()+";");
			while (rs1.next()) {
				comp.add(rs1.getInt("cod_competicion"));
			}
			if(comp.isEmpty()){
				esta = false;
			}else {
				esta = true;
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return esta;
	}
	public static ArrayList<Integer> getAnyoCompeticion(String nomComp) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> anyos = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT a�o FROM competicion WHERE nombre = '" + nomComp + "';");
			while (rs1.next()) {
				anyos.add(rs1.getInt("a�o"));
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return anyos;
	}
	public static String getPaisCompeticion(String nomComp) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		String pais = "";
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT pais FROM competicion WHERE nombre = '" + nomComp + "';");
			while (rs1.next()) {
				pais = rs1.getString("pais");
			}
			rs1.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (cn1 != null) {
					cn1.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pais;
	}

	public static void addUsuarioEquipoBD(Usuario u, Equipo eq) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;

		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO USUARIOEQUIPO VALUES(" + u.getCodigo() + "," + eq.getCodigo() + ")");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void addUsuarioCompeticionBD(String u, String c, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;
		int cod_comp = getCompeticion(c, anyo).getCodigo();
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO usuariocompeticion VALUES(" + getCodUsuariosPorNom(u) + "," + cod_comp + ")");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void addEquipoCompeticionBD(String eq, String c, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;

		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO EQUIPOCOMPETICION VALUES(" + getEquipoPorNombre(eq).getCodigo() + "," + getCompeticion(c, anyo).getCodigo() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "No se ha podido establecer conexion a la BD.");
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
				}
				if (stm1 != null) {
					stm1.close();
				}
				if (cn1 != null) {
					cn1.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
