package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.DTO.VwDetallePedidoBE;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class JDDetalleOrdenListar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JTable TABLA_DETALLEORDEN;
	ArrayList<VwDetallePedidoBE> listaDetalle= new ArrayList<>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JDDetalleOrdenListar dialog = new JDDetalleOrdenListar();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public JDDetalleOrdenListar(javax.swing.JDialog parent, boolean modal,ArrayList<VwDetallePedidoBE> listaDetalle_) {
		super(parent,modal);
		setUndecorated(true);
		listaDetalle=listaDetalle_;
		setBounds(100, 100, 1113, 620);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(JDDetalleOrdenListar.class.getResource("/img/1492790922-20list_84170.png")));
			lblNewLabel_1.setBounds(10, 47, 75, 49);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 128, 128));
			panel.setBounds(0, 47, 1113, 49);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("DETALLE DE ORDEN ");
				lblNewLabel.setForeground(new Color(240, 248, 255));
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
				lblNewLabel.setBackground(new Color(240, 248, 255));
				lblNewLabel.setBounds(405, -14, 252, 72);
				panel.add(lblNewLabel);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(101, 21, 261, 2);
				panel.add(separator);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(678, 21, 299, 2);
				panel.add(separator);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(JDDetalleOrdenListar.class.getResource("/img/1492790922-20list_84170.png")));
				lblNewLabel_1.setBounds(1028, 0, 75, 49);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(240, 248, 255));
			scrollPane.setBounds(10, 134, 1046, 344);
			contentPanel.add(scrollPane);
			{
				TABLA_DETALLEORDEN = new JTable();
				TABLA_DETALLEORDEN.setForeground(new Color(0, 0, 0));
				TABLA_DETALLEORDEN.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
				TABLA_DETALLEORDEN.setBorder(new LineBorder(new Color(0, 0, 139), 2));
				TABLA_DETALLEORDEN.setBackground(new Color(240, 248, 255));
				scrollPane.setViewportView(TABLA_DETALLEORDEN);
			}
			TablaDetalleOrdenListar.seeTable(TABLA_DETALLEORDEN, listaDetalle);
			
		}
		{
			cancelButton = new JButton("");
			cancelButton.setBackground(new Color(240, 248, 255));
			cancelButton.setBorder(null);
			cancelButton.setIcon(new ImageIcon(JDDetalleOrdenListar.class.getResource("/img/1486485553-ago-arrow-arrow-left-back-previous-direction-left_81160 (1).png")));
			cancelButton.setBounds(10, 489, 92, 81);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(this);
			cancelButton.setActionCommand("Cancel");
		}
	
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
