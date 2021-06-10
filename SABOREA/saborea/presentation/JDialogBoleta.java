package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class JDialogBoleta extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogBoleta dialog = new JDialogBoleta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogBoleta() {
		setBounds(100, 100, 620, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 372, 105);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("SABOREA");
				lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 50));
				lblNewLabel.setBounds(23, 11, 302, 81);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(370, 0, 234, 105);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("N\u00B0 PEDIDO");
				lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 23));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(49, 28, 119, 24);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("0000000000");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(37, 64, 119, 14);
				panel.add(lblNewLabel_2);
			}
		}
		{
			JLabel lblNewLabel_3 = new JLabel("ID CAJERO :");
			lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_3.setBounds(20, 119, 109, 19);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("ID MESERO :");
			lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_3.setBounds(20, 149, 109, 19);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("HORA :");
			lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_3.setBounds(343, 146, 109, 19);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("FECHA :");
			lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_3.setBounds(343, 116, 109, 19);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("0000000000");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(123, 122, 95, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("0000000000");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(123, 152, 95, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("00/00/0000");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(424, 122, 103, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("00:00");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(424, 152, 74, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("NOMBRES Y APELLIDOS DEL CLIENTE :");
			lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_3.setBounds(20, 184, 314, 19);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("0000000000");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(20, 214, 300, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 251, 584, 181);
			contentPanel.add(scrollPane);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("TOTAL : S/");
			lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
			lblNewLabel_3.setBounds(399, 432, 90, 19);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setBounds(487, 436, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JButton btnNewButton = new JButton("VOLVER");
			btnNewButton.setBounds(10, 467, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("RECIBO PAGADO");
			btnNewButton_1.setBounds(445, 467, 149, 23);
			contentPanel.add(btnNewButton_1);
		}
	}

}
