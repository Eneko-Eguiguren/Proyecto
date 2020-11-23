package datos;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MiJTable extends JTable {
	private static final long serialVersionUID = 1L;

	// Modelo de datos propio
	private static MiTableModel datos;

	// [02] Renderers para alinear distinto que a la izquierda
	private static DefaultTableCellRenderer rendererDerecha = new DefaultTableCellRenderer();
	private static DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
	static {
		rendererDerecha.setHorizontalAlignment( JLabel.RIGHT );
		rendererCentrado.setHorizontalAlignment( JLabel.CENTER );
	}

	public MiJTable( MiTableModel modelo ) {
		super(modelo);
    	// Fijar tamaño preferido de la tabla
        setPreferredScrollableViewportSize(new Dimension(500, 70));
	}
	
	public void setModel( TableModel t ) {
		if (t instanceof MiTableModel)
			super.setModel( t );
		else
			throw new IncompatibleClassChangeError( 
				"No se puede asignar cualquier modelo de datos a una MIJTable" );
	}
	
	public MiTableModel getMiTableModel() {
		return (MiTableModel) getModel();
	}
	
	/**
     * Crear la ventana y mostrarla. Para seguridad de hilos,
     * este método debería invocarse desde el hilo de gestión de eventos
     */
    private static void crearYMostrarGUI() {
    	// Crear datos de prueba
    	

    	// Crear la tabla y el scrollpane
    	final MiJTable tabla = new MiJTable( datos );
    	ajustarColumnas( tabla );
        JScrollPane scrollPane = new JScrollPane( tabla );

        //Crear e inicializar la ventana con la tabla central
        JFrame frame = new JFrame("Demo de JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( scrollPane, "Center" );
        
        // Crear e inicializar la botonera
        JPanel botonera = new JPanel();
        JButton botonInsertar = new JButton( "Insertar nueva fila" );
        JButton botonBorrar = new JButton( "Borrar fila" );
        botonera.add( botonInsertar );
        botonera.add( botonBorrar );
        frame.add(botonera, "South");

        
        // Ajusta el tamaño de la ventana y la muestra
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void ajustarColumnas( MiJTable tabla ) {
        // Asignar renderers de alineación horizontal
        tabla.getColumn("Nombre").setCellRenderer( rendererDerecha );
        tabla.getColumn("Deporte").setCellRenderer( rendererCentrado );
        // Asignar anchuras iniciales
        tabla.getColumn( "Apellidos" ).setMinWidth( 200 );
        tabla.getColumn( "Deporte" ).setPreferredWidth( 100 );
        tabla.getColumn( "Años" ).setPreferredWidth( 50 );
    }

    
}
class MiTableModel extends AbstractTableModel {
    // Lista principal de datos del modelo:
    private ArrayList<DatoParaTabla> datos = new ArrayList<DatoParaTabla>();
    private String[] nombresColumnas;  // Nombres de columnas
    private boolean[] columnasEditables;  // Columnas editables o no
	private static final long serialVersionUID = 7026825539532562011L;
	private boolean DEBUG = true;

    /** Constructor de modelo de tabla
     * @param nombresColumnas	Nombres de las columnas
     * @param colsEditables	Array de valores lógicos si las columnas son editables (true) o no (false)
     */
    public MiTableModel( String[] nombresColumnas, boolean[] colsEditables ) {
    	this.nombresColumnas = nombresColumnas;
    	this.columnasEditables = colsEditables;
    }
    
    /** Añade un dato al final del modelo
     * @param dato	Dato a añadir
     */
    public void insertar( DatoParaTabla dato ) {
    	datos.add( dato );
    }

    /** Elimina un dato del modelo
     * @param dato	Dato a borrar
     */
    public void borrar( DatoParaTabla dato ) {
    	datos.remove( dato );
    }

    /** Elimina un dato del modelo, indicado por su posición
     * @param ind	Posición del dato a borrar
     */
    public void borrar( int ind ) {
    	datos.remove( ind );
    }

    /* [01] MODELO: Devuelve el número de columnas
     */
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    /* [01] MODELO: Devuelve el número de filas
     */
    public int getRowCount() {
        return datos.size();
    }

    /* [01] MODELO: Devuelve el nombre de la columna
     */
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    /* [01] MODELO: Devuelve el valor de la celda indicada
     */
    public Object getValueAt(int row, int col) {
        return datos.get(row).getValor(col);
    }

    /* [01] MODELO: Este método devuelve el renderer/editor por defecto
     * para cada celda, identificado por la columna. Si no cambiáramos
     * este método la última columna se vería como un String en lugar
     * de un checkbox (renderer/editor por defecto para Boolean)
     */
    public Class<?> getColumnClass(int c) {
    	if (datos.size()==0) return String.class;  // por defecto String
        return datos.get(0).getValor(c).getClass();  // Si hay datos, la clase correspondiente
    }

    /* [01] MODELO: Si la tabla es editable, este método identifica
     * qué celdas pueden editarse
     */
    public boolean isCellEditable(int row, int col) {
    	if (col >= 0 && col < columnasEditables.length)
    		return columnasEditables[col];
    	else return false;
    }

    /* [01] MODELO: Método que sólo hay que implementar si la tabla
     * puede cambiar (editar) valores de sus celdas
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Poniendo valor en (" + row + "," + col
                               + ") = " + value + " (instancia de "
                               + value.getClass() + ")");
        }
        datos.get(row).setValor( value, col );
        fireTableCellUpdated(row, col);  // Notifica a escuchadores de cambio de celda
    }

}