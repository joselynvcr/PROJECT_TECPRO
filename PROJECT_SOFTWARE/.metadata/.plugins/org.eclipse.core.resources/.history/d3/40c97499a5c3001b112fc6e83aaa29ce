package saborea.presentation.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.DTO.CredencialesBE;

import java.awt.Color;
import javax.swing.JLabel;

public class FormCajero extends JFrame {

	private JPanel contentPane;
	private JLabel lblCajero;
	private JLabel lblNewLabel;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCajero = new JLabel("CAJERO");
		lblCajero.setBounds(160, 120, 164, 46);
		contentPane.add(lblCajero);
		
		lblNewLabel = new JLabel(cred.getNombreEmpleado());
		lblNewLabel.setBounds(131, 52, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("si se est\u00E0 modificando");
		lblNewLabel_1.setBounds(46, 109, 131, 14);
		contentPane.add(lblNewLabel_1);
	}
	
	
	

}
