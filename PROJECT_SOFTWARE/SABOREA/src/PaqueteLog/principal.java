package PaqueteLog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import saborea.model.bussiness.DTO.CredencialesBE;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class principal extends JFrame {

	
	private JPanel contentPane;
	private JLabel lblBienvenida;	
	private CredencialesBE cred;	
	private JTextArea txtS;
	public CredencialesBE getCred() {
		return cred;
	}
	public void setCred(CredencialesBE cred) {
		this.cred = cred;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					principal frame = new principal();
					
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public principal(){};
	
	public principal(CredencialesBE cred) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new LineBorder(Color.GREEN, 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblBienvenida = new JLabel("BIENVENIDO AL SISTEMA SABOREA"+ cred.getNombreEmpleado());
		lblBienvenida.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBienvenida.setBounds(46, 52, 387, 31);
		contentPane.add(lblBienvenida);		
		
		txtS = new JTextArea();
		txtS.setBounds(28, 139, 310, 235);
		contentPane.add(txtS);
		
		
		
		
		
	}

	
	
	
}
