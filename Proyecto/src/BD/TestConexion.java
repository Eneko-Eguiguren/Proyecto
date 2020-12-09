package BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import datos.Usuario;
public class TestConexion {
	public static ArrayList<Usuario> usuarios ;
	public TestConexion() {
		
		Conexion conexion1 = new Conexion();
		Connection cn1 = null;
		Statement stm1= null;
		ResultSet rs1 = null;
		usuarios = new ArrayList<Usuario>();
		HashMap<Integer, Usuario > mapaUsuarios = new HashMap<Integer, Usuario>();
		int key= 0;
		
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
	public String getNombreU(int num) {
		return usuarios.get(num).getNombre();
		
	}
	public static void main(String[] args) {
		 System.out.println(usuarios);
		 System.out.println(usuarios.get(0).getNombre());
		// PRUEBA GITHUB
	}
}
