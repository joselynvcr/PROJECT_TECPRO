package PaqueteLog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblBienvenidoAdministrador;

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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new LineBorder(Color.GREEN, 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBienvenidoAdministrador = new JLabel("");
		lblBienvenidoAdministrador.setForeground(new Color(47, 79, 79));
		lblBienvenidoAdministrador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBienvenidoAdministrador.setIcon(new ImageIcon("D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\T\u00C9CNICAS DE PROGRAM.ORIE. OBJ\\key.png"));
		lblBienvenidoAdministrador.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblBienvenidoAdministrador.setBounds(26, 27, 800, 399);
		contentPane.add(lblBienvenidoAdministrador);
	}
}