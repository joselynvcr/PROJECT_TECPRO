package saborea.presentation;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RedimensionarListarPedido extends DefaultTableCellRenderer  {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		//nos servirá para mostrar bototnes en la tabla, puede ser un jlabel o jcombo
		if(value instanceof JButton){
			JButton btn=(JButton) value;
			return btn;
		}
		
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		
		
		
		
	}
	
	
	
}
