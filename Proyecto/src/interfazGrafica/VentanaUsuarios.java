package interfazGrafica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import BD.Conexion;
import datos.Equipo;
public class VentanaUsuarios extends JFrame {
	
	
	public static void getDatoDeBD1() {
		Conexion conexion = new Conexion();
		Connection cn1 = null;
		Statement stm1 = null;
		ResultSet rs1 = null;
		
		
		try {
			cn1 = conexion.conectar();
			stm1 = cn1.createStatement();
			rs1 = stm1.executeQuery("SELECT * FROM usuario");
			while(rs1.next()) {
				int cod_usuario  = rs1.getInt(1);
				String nom_usuario = rs1.getString(2);
				String clave_usuario = rs1.getString(3);
				System.out.println(cod_usuario + " - " + nom_usuario + " - " + clave_usuario );
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public VentanaUsuarios () {
		
	}
}
