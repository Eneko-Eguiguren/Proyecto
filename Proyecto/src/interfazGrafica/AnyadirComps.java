package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BD.ExtraccionBD;

public class AnyadirComps extends JFrame {
	private static final long serialVersionUID = 1L;

	public AnyadirComps() {
		this.setTitle("Añadir Equipos Nuevos");
		this.setBounds(440, 160, 600, 560);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//
		JPanel panel = new JPanel();
		JTextField nombreTxt = new JTextField();
		JFormattedTextField codigoTxt = new JFormattedTextField();
		JTextField paisTxt = new JTextField();
		JTextField anyoTxt = new JTextField();
		JComboBox<String> campeonCombo = new JComboBox<String>();
		JComboBox<String> subcampeonCombo = new JComboBox<String>();
		JLabel title = new JLabel("AÑADIR COMPETICIONES");
		JLabel nombre = new JLabel("Nombre");
		JLabel codigo = new JLabel("Codigo");
		JLabel pais = new JLabel("Pais");
		JLabel anyo = new JLabel("Año");
		JLabel campeon = new JLabel("Campeon");
		JLabel subcampeon = new JLabel("Subcampeon");
		JButton accept = new JButton("Aceptar");
		JButton delete = new JButton("Eliminar");
		JButton atras = new JButton("Atras");
		//
		for (String eq : ExtraccionBD.getNomEquipos()) {
			campeonCombo.addItem(eq);
			subcampeonCombo.addItem(eq);
		}
		panel.setBackground(Login.color);
		panel.setLayout(null);
		nombre.setBounds(70, 100, 70, 25);
		codigo.setBounds(70, 150, 100, 25);
		nombreTxt.setBounds(200, 100, 160, 35);
		codigoTxt.setBounds(200, 150, 160, 35);
		pais.setBounds(70, 200, 100, 25);
		paisTxt.setBounds(200, 200, 160, 35);
		anyo.setBounds(70, 250, 100, 25);
		anyoTxt.setBounds(200, 250, 160, 35);
		campeon.setBounds(70, 300, 100, 25);
		campeonCombo.setBounds(200, 300, 160, 35);
		subcampeon.setBounds(70, 350, 100, 25);
		subcampeonCombo.setBounds(200, 350, 160, 35);
		accept.setBounds(115, 400, 100, 40);
		delete.setBounds(240, 400, 100, 40);
		title.setBounds(220, 20, 170, 100);
		atras.setBounds(180, 460, 100, 30);
		//
		this.add(panel);
		panel.add(nombreTxt);
		panel.add(codigoTxt);
		panel.add(codigo);
		panel.add(nombre);
		panel.add(delete);
		panel.add(accept);
		panel.add(title);
		panel.add(atras);
		panel.add(pais);
		panel.add(anyo);
		panel.add(campeon);
		panel.add(subcampeon);
		panel.add(anyoTxt);
		panel.add(paisTxt);
		panel.add(campeonCombo);
		panel.add(subcampeonCombo);
		//
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.valueOf(codigoTxt.getText());
				int anyo2 = Integer.valueOf(anyoTxt.getText());
				if (ExtraccionBD.getNomCompeticiones().contains(nombreTxt.getText())|| ExtraccionBD.getCodCompeticiones().contains(codigo) || 1950 < anyo2 || anyo2 >2021) {
					JOptionPane.showMessageDialog(null, "Datos no validos.");
				}else {
					System.out.println("nuevo ");
				}
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new AnyadirComps();
	}
}
