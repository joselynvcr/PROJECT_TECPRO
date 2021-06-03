package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.DTO.CredencialesBE;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class FormAdministrador extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Administrador frame = new Administrador();
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
	public FormAdministrador(CredencialesBE cred) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Administrador");
		lblNewLabel.setBounds(84, 48, 169, 45);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(cred.getNombreEmpleado());
		lblNewLabel_1.setBounds(81, 113, 46, 14);
		contentPane.add(lblNewLabel_1);
	}

}
