package interfazGrafica;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import BD.ExtraccionBD;
import datos.Usuario;

public class UsuariosActuales extends JFrame {

	private static final long serialVersionUID = 1L;
	public UsuariosActuales() {
		this.setTitle("Lista de usuarios registrados.");
		this.setBounds(235, 160, 200, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for (String u : ExtraccionBD.getNomUsuarios()) {
			modelo.addElement(u);
		}
		JList<String> lista = new JList<String>();
		lista.setModel(modelo);
		lista.setBackground(Login.color);
		this.add(lista);
		this.setVisible(true);
	 }
}
