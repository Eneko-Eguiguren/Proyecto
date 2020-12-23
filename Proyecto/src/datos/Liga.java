package datos;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;

import interfazUsuario.*;

public class Liga extends Competicion {
	public ArrayList<Equipo> ordenClasificacin = new ArrayList<Equipo>();
	public Liga(ArrayList<Equipo> equipos, String nombre, Equipo ganador, ArrayList<Equipo> ordenClasificacion) {
		super(equipos, nombre, ganador);
		this.ordenClasificacin = ordenClasificacion;
	}
	public ArrayList<Equipo> getOrdenClasificacin() {
		return ordenClasificacin;
	}
	public void setOrdenClasificacin(ArrayList<Equipo> ordenClasificacin) {
		this.ordenClasificacin = ordenClasificacin;
	}
	public void tablaLiga() {
		MiTableModel datos = new MiTableModel( Equipo.NOMBRES_COLUMNAS, Equipo.COLUMNAS_EDITABLES );
    	for (Equipo eq : ordenClasificacin) {
    		
    	}
    	// Crear la tabla (partiendo del modelo de datos) y el scrollpane
    	final MiJTable tabla = new MiJTable( datos );
    	
        JScrollPane scrollPane = new JScrollPane( tabla );
        
        JPanel panelInf = new JPanel();
        //Crear e inicializar la ventana con la tabla central
        JFrame frame = new JFrame( "Mejores jugadores de futbol" );
        frame.setSize(700, 400);
        frame.setLocation(300, 200);
        frame.add(panelInf, BorderLayout.SOUTH);
        
        frame.add( scrollPane, "Center" );
        // Ajusta el tamaño de la ventana y la muestra
        
        frame.setVisible(true);
   }
	}

