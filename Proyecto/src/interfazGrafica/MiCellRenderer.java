package interfazGrafica;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MiCellRenderer extends JLabel implements ListCellRenderer {

	private static final long serialVersionUID = 1L;
	final  ImageIcon longIcon = new ImageIcon("src/images/copa.png") ;
	
	public Component getListCellRendererComponent(JList list, Object value, // value to display
			int index, // cell index
			boolean isSelected, // is the cell selected
			boolean cellHasFocus) // the list and the cell have the focus
	{
		String s = value.toString();
		setText(s);
		setIcon(longIcon);

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}
}
