package BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import datos.Competicion;
import datos.Equipo;
import datos.Jugador;
import datos.Usuario;
public class ExtraccionBD {
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>() ;
	public static ArrayList<Equipo> equipos ;
	public static ArrayList<Competicion> competiciones ;
	public static ArrayList<Jugador> jugadores ;
	public static void UsuariosBD() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		HashMap<Integer, Usuario > mapaUsuarios = new HashMap<Integer, Usuario>();
		int key= 0;
		usuarios = new ArrayList<Usuario>();
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM usuario");
			
			while(rs1.next()) {
				key = key+1;
				int cod_usuario  = rs1.getInt(1);
				String nom_usuario = rs1.getString(2);
				String clave = rs1.getString(3);
				//int cod_competicion = rs1.getInt(2);
				Usuario u = new Usuario(nom_usuario, clave, cod_usuario);
				usuarios.add(u);
				mapaUsuarios.put(key, u);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public static void JugadoresBD() {
		
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		jugadores = new ArrayList<Jugador>();
		
		int key= 0;
		
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM juagdor");
			
			while(rs1.next()) {
				key = key+1;
				int num_jug  = rs1.getInt(1);
				int cod_equipo = rs1.getInt(2);
				String nombre = rs1.getString(3);
				int edad = rs1.getInt(4);
				//int cod_competicion = rs1.getInt(2);
				Jugador jug = new Jugador(nombre, cod_equipo, num_jug, edad);
				jugadores.add(jug);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public static void CompeticionesBD() {
		
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		jugadores = new ArrayList<Jugador>();
		
		int key= 0;
		
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM competicion");
			
			while(rs1.next()) {
				key = key+1;
				int cod_comp  = rs1.getInt(1);
				String nombre = rs1.getString(2);
				//int cod_competicion = rs1.getInt(2);
				Competicion c = new Competicion(equipos, nombre, cod_comp);
				competiciones.add(c);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
