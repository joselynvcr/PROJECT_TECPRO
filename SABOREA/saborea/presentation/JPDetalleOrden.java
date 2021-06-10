package saborea.presentation;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class JPDetalleOrden extends JPanel {
	private JScrollPane scrollPane;
	private JTable TablaDetalleOrden;
	private final JPanel panel = new JPanel();
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public JPDetalleOrden() {
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(240, 248, 255));
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128)));
		scrollPane.setBounds(10, 125, 871, 353);
		add(scrollPane);
		
		TablaDetalleOrden = new JTable();
		scrollPane.setViewportView(TablaDetalleOrden);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 43, 891, 57);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("DETALLE DE ORDEN");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 26));
		lblNewLabel.setBounds(302, 11, 298, 46);
		panel.add(lblNewLabel);

	}
	
	
	
	
}
