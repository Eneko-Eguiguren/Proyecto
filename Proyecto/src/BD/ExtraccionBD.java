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


	
	//Añadimos jugadores de la base de datos con sus correspondientes datos
	public static void addJugadoresBD(String n, int codequipo, int num, int edad) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;

		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO JUGADOR VALUES(" + num + ",'" + n + "'," + codequipo + "," + edad + ")");
			logger.log(Level.INFO, "Jugador añadido a BD correctamente.");

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
	//Añadimos competiciones de la base de datos con sus correspondientes datos
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

			logger.log(Level.INFO, "Competicion añadida a BD correctamente.");

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

	//Añadimos usuarios de la base de datos con sus correspondientes datos
	public static void addUsuarioBD(String nom, String contr, int cod) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO USUARIO VALUES(" + cod + ",'" + nom + "','" + contr + "')");
			logger.log(Level.INFO, "Usuario añadido a BD correctamente.");

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
	//Obtienes la contraseña en funcion del nombre del usuario
	public static String getContrUsuariosPorNom(String nombre) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		String contrasenya = "hola";
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT contraseña FROM usuario WHERE nombre = '" + nombre + "';");
			while (rs1.next()) {
				contrasenya = rs1.getString("contraseña");
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
	//Obtienes el usuario en funcion de su nombre
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

	//Obtiene el nombre con el que se identifica al usuari@
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
	
	//Obtiene el codigo con el que se identifica al usuari@
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
	
	// Relacionas a un usuario por su codigo con un equipo por su codigo
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

	// Relacionas a un usuario por su codigo con una competicion por su nombre
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
	
	//Añadimos equipos de la base de datos con sus correspondientes datos
	public static void addEquiposBD(int cod, String nombre) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			stm1.executeUpdate("INSERT INTO EQUIPO VALUES(" + cod + ",'" + nombre + "')");
			logger.log(Level.INFO, "Equipo añadido a BD correctamente.");

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
	
	//Obtiene el nombre de los equipos
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
	
	//Obtiene los equipos
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

	//Obtienes el equipo en funcion de su codigo
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

	//Obtienes el equipo en funcion de su nombre
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
	
	//Relaciona nombre de un equipo a un codigo concreto
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

	//Obtienes los equipos de una competicion
	public static ArrayList<Integer> getEquiposDeComp(String nombreCompeticion, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> cods = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT cod_equipo FROM equipocompeticion WHERE cod_competicion = (select codigo from competicion where nombre = '"+ nombreCompeticion + "' AND año ="+anyo+");");
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
	
	//Obtienes los titulos que tenga cierto equipo
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
	
	//Obtienes cuantas competiciones ha disputado un equipo en un año concreto
	public static ArrayList<String> getCompeticionesDisputadasEnAnyo(String nomEq, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> comps = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT nombre FROM competicion WHERE año = "+anyo+" AND codigo IN (SELECT cod_competicion FROM equipocompeticion WHERE cod_equipo = (SELECT codigo FROM equipo WHERE nombre = '"+ nomEq+"'));");
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

	// Obtiene las competiciones
	public static Competicion getCompeticion(String nom, int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Competicion c = new Competicion(nom, 0, anyo, "", null, null);
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM competicion WHERE nombre = '"+nom+"' AND año = "+anyo+";");
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
	
	//Obtiene el nombre con el que se identifica la competicion
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
	
	//Obtiene el nombre de las competiciones sin que se repitan
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
	
	//Obtiene el nombre de la competicion en el año seleccionado
	public static ArrayList<String> getNomCompeticionesPorAnyo(int anyo) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<String> noms = new ArrayList<String>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT NOMBRE FROM COMPETICION WHERE AÑO ="+anyo+" ;");
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
			ResultSet rs1 = stmt.executeQuery("SELECT NOMBRE FROM COMPETICION WHERE AÑO ="+anyo+" AND CODIGO IN (SELECT COD_COMPETICION FROM usuariocompeticion WHERE COD_USUARIO = (SELECT CODIGO FROM USUARIO WHERE NOMBRE = '"+nomUsuario+"'))");
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

	//Obtiene el codigo con el que se identifica la competicion
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
	
	//Se pregunta si la competicion esta entra las favoritas del usuario
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
	
	//Obtiene el año en el que se disputo la competicion
	public static ArrayList<Integer> getAnyoCompeticion(String nomComp) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		ArrayList<Integer> anyos = new ArrayList<Integer>();
		try {

			cn1 = conexion1.conectar();
			Statement stmt = cn1.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT año FROM competicion WHERE nombre = '" + nomComp + "';");
			while (rs1.next()) {
				anyos.add(rs1.getInt("año"));
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
	
	//Obtiene el pais en el que se disputo la competicion
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

	//Añade un usuario a un equipo
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

	//Añade un usuario a una competicion
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

	//Añade un equipo a una competicion 
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