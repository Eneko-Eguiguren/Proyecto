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
	public static HashMap<Usuario, ArrayList<Equipo>> mapaUsEq = new HashMap<Usuario, ArrayList<Equipo>>();
	public static HashMap<Usuario, ArrayList<Competicion>> mapaUsComp = new HashMap<Usuario, ArrayList<Competicion>>();
	public static HashMap<String, ArrayList<Equipo>> mapaEqComp = new HashMap<String, ArrayList<Equipo>>();
	public static void EquiposBD() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM equipo");
			
			while(rs1.next()) {

				int cod_equipo  = rs1.getInt(1);
				String nombre = rs1.getString(2);
				Equipo eq = new Equipo(cod_equipo, nombre);
				equipos.add(eq);
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
	public static void addEquiposBD(int cod, String nombre) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO EQUIPO VALUES("+cod+",'"+nombre+"'");
			
			while(rs1.next()) {
				Equipo eq = new Equipo(cod, nombre);
				equipos.add(eq);
				
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
	public static void addUsuarioBD(String nom,String contr, int cod ) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO USUARIO VALUES("+cod+",'"+nom+"','"+contr+"'");
			
			while(rs1.next()) {
				Usuario usr = new Usuario(nom, contr, cod);
				usuarios.add(usr);
				
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
	public static void UsuariosBD() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		usuarios = new ArrayList<Usuario>();
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM usuario");
			
			while(rs1.next()) {
				
				int cod_usuario  = rs1.getInt(1);
				String nom_usuario = rs1.getString(2);
				String clave = rs1.getString(3);
				Usuario u = new Usuario(nom_usuario, clave, cod_usuario);
				usuarios.add(u);
				
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
	public static void addJugadoresBD(String n, int codequipo, int num, int edad ) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		jugadores = new ArrayList<Jugador>();
		
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO JUGADOR VALUES("+num+",'"+n+"',"+codequipo+","+edad);
			
			while(rs1.next()) {
				Jugador jug = new Jugador(n,codequipo,num,edad);
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
	public static void JugadoresBD() {
		
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM juagdor");
			
			while(rs1.next()) {
				int num_jug  = rs1.getInt(1);
				int cod_equipo = rs1.getInt(3);
				String nombre = rs1.getString(2);
				int edad = rs1.getInt(4);
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
	public static void addCompeticionBD(ArrayList<Equipo> eqs,String n,int cod,int anyo,String pais, Equipo c, Equipo sc) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO COMPETICION VALUES("+cod+",'"+n+"','"+pais+"',"+ anyo+",'" +c.getNombre()+ "','"+sc.getNombre()+"'");
			
			while(rs1.next()) {
				Competicion comp = new Competicion(eqs, n, cod, anyo, pais, c, sc);
				competiciones.add(comp);
				
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
		

		
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM competicion");
			
			while(rs1.next()) {

				int cod_comp  = rs1.getInt(1);
				String nombre = rs1.getString(2);
				String pais = rs1.getString(3);
				int anyo = rs1.getInt(4);
				String campeon = rs1.getString(5);
				String subcampeon = rs1.getString(6);
				Equipo camp = null;
				Equipo subcamp = null;
				for (Equipo e : equipos) {
					if(e.getNombre()==campeon) {
						 camp = e;
					}
					else if (e.getNombre()==subcampeon) {
						 subcamp = e;
					}
				}
				for (Competicion comp : competiciones) {
					if (comp.getCodigo()== cod_comp) {
						
					}
				}
				Competicion c = new Competicion(mapaEqComp.get(nombre), nombre, cod_comp, anyo, pais,camp,subcamp);
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
	public static void UsuarioEquipoBD() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		ArrayList<Equipo> equiposU = new ArrayList<Equipo>();
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM usuarioequipo");
			
			while(rs1.next()) {
				int cod_usuario  = rs1.getInt(1);
				int cod_equipo = rs1.getInt(2);
				Usuario user = null;
				Equipo team = null;
				
				for (Usuario u : usuarios) {
					if(u.getCodigo()==cod_usuario) {
						user = u;
					}
				}
				for (Equipo e : equipos) {
					if(e.getCodigo()==cod_equipo) {
						team = e;
					}
				}
				if (user != null && team != null) {
					equiposU.add(team);
					mapaUsEq.put(user, equiposU);
					
				}
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
	public static void addUsuarioEquipoBD(Usuario u, Equipo eq) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO USUARIOEQUIPO VALUES("+ u.getCodigo()+","+eq.getCodigo());
			
			while(rs1.next()) {
				ArrayList<Equipo> eqs = mapaUsEq.get(u);
				eqs.add(eq);
				mapaUsEq.put(u, eqs);
				
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
	public static void usuarioCompeticionBD() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		ArrayList<Competicion> compsU = new ArrayList<Competicion>();
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM usuariocompeticion");
			
			while(rs1.next()) {
				int cod_usuario  = rs1.getInt(1);
				int cod_comp = rs1.getInt(2);
				Usuario user = null;
				Competicion compe = null;
				
				for (Usuario u : usuarios) {
					if(u.getCodigo()==cod_usuario) {
						user = u;
					}
				}
				for (Competicion c : competiciones) {
					if(c.getCodigo()==cod_comp) {
						compe = c;
					}
				}
				if (user != null && compe != null) {
					compsU.add(compe);
					mapaUsComp.put(user, compsU);
					
				}
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
	public static void addUsuarioCompeticionBD(Usuario u, Competicion c) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO USUARIOEQUIPO VALUES("+ u.getCodigo()+","+c.getCodigo());
			
			while(rs1.next()) {
				ArrayList<Competicion> comps = mapaUsComp.get(u);
				comps.add(c);
				mapaUsComp.put(u, comps);
				
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
	public static void equipoCompeticionBD() {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		ArrayList<Equipo> equiposC = new ArrayList<Equipo>();
		try {

			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM equipocompeticion");
			
			while(rs1.next()) {
				int cod_equipo  = rs1.getInt(1);
				int cod_competicion = rs1.getInt(2);
				Competicion comp = null;
				Equipo team = null;
				
				for (Competicion c : competiciones) {
					if(c.getCodigo()==cod_competicion) {
						comp = c;
					}
				}
				for (Equipo e : equipos) {
					if(e.getCodigo()==cod_equipo) {
						team = e;
					}
				}
				if (comp != null && team != null) {
					equiposC.add(team);
					mapaEqComp.put(comp.getNombre(), equiposC);
					
				}
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
	public static void addEquipoCompeticionBD(Equipo eq, Competicion c) {
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		
		try {
			cn1 = conexion1.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("INSERT INTO USUARIOEQUIPO VALUES("+ eq.getCodigo()+","+c.getCodigo());
			
			while(rs1.next()) {
				ArrayList<Equipo> eqs = mapaEqComp.get(c.getNombre());
				eqs.add(eq);
				mapaEqComp.put(c.getNombre(), eqs);
				
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
	
	

