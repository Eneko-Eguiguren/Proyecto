package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BD.ExtraccionBD;

public class AnyadirEqsAComp2 extends JFrame {

	private static final long serialVersionUID = 1L;

	public AnyadirEqsAComp2(String nomComp, int anyoComp) {

		this.setBounds(440, 160, 485, 290);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(null);

		JLabel ayuda = new JLabel("(Ctrl + Click para seleccionar varios)");
		ayuda.setBounds(130, 10, 300, 30);

		ArrayList<String> eqs = ExtraccionBD.getNomEquipos();

		JList<String> listEqs = new JList<String>();
		listEqs.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listEqs.setCellRenderer(new MiCellRenderer2());

		DefaultListModel<String> modelo = new DefaultListModel<String>();

		ArrayList<String> equiposYaExistentes = new ArrayList<String>();
		for (Integer c : ExtraccionBD.getEquiposDeComp(nomComp, anyoComp)) {
			equiposYaExistentes.add(ExtraccionBD.getNomEquipoPorCod(c));
		}
		for (String eq : eqs) {
			if (equiposYaExistentes.contains(eq)) {

			} else {
				modelo.addElement(eq);
			}
		}

		listEqs.setModel(modelo);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(listEqs);
		scrollPane.setBounds(50, 50, 370, 150);

		JButton b = new JButton("Añadir equipos a " + nomComp + " " + anyoComp);
		b.setBounds(110, 210, 250, 30);

		this.add(p);
		p.add(ayuda);
		p.add(scrollPane);
		p.add(b);

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<String> seleccionados = listEqs.getSelectedValuesList();
					System.out.println(seleccionados);
					for (String string : seleccionados) {
						ExtraccionBD.addEquipoCompeticionBD(string, nomComp, anyoComp);
					}
					JOptionPane.showMessageDialog(null, "Equipos añadidos correctamente.");
					dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error.");
				}
				
			}
		});
		this.setVisible(true);
	}

}
