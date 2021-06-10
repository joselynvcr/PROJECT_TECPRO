package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.DTO.CredencialesBE;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class FormCajero extends JFrame {

	private JPanel contentPane;
	private JLabel lblCajero;
	private JLabel lblNombreApellido;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cajero frame = new Cajero();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormCajero(CredencialesBE cred) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 671);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 74, 241, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIcon_Cajero = new JLabel("");
		lblIcon_Cajero.setBounds(-3, 11, 241, 166);
		lblIcon_Cajero.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblIcon_Cajero);
		lblIcon_Cajero.setIcon(new ImageIcon(FormCajero.class.getResource("/img/icon_Cajero.png")));
		
		lblNombreApellido = new JLabel(cred.getNombreEmpleado()+" "+ cred.getApellidoEmpleado());
		lblNombreApellido.setBounds(-3, 188, 241, 29);
		lblNombreApellido.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombreApellido);
		
		lblNewLabel_1 = new JLabel(cred.getTipoCargo());
		lblNewLabel_1.setBounds(-3, 219, 241, 29);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		lblCajero = new JLabel("CAJERO");
		lblCajero.setBounds(64, 259, 164, 46);
		panel.add(lblCajero);
		
		JButton btnNewButton = new JButton("      CERRAR SESI\u00D3N");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setIcon(new ImageIcon(FormCajero.class.getResource("/img/log-out (1).png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 502, 238, 54);
		panel.add(btnNewButton);
		
		JButton btnListaDePedidos = new JButton("LISTA DE PEDIDOS");
		btnListaDePedidos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnListaDePedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListaDePedidos.setBounds(0, 448, 238, 54);
		panel.add(btnListaDePedidos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(211, 211, 211));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FormCajero.class.getResource("/img/Nuevo proyecto.png")));
		lblNewLabel.setBounds(245, 74, 611, 556);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(240, 74, 616, 556);
		contentPane.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(50, 205, 50));
		panel_1.setBounds(0, 0, 856, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BIENVENIDO");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 26));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 846, 74);
		panel_1.add(lblNewLabel_2);
	}
}
