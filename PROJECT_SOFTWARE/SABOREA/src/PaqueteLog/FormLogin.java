package PaqueteLog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class FormLogin extends JFrame {
																															//width height hints	
	private Image img_logo =new ImageIcon(FormLogin.class.getResource("images/sabore_login.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_password =new ImageIcon(FormLogin.class.getResource("images/padlock.1.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_user =new ImageIcon(FormLogin.class.getResource("images/username.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_log_in =new ImageIcon(FormLogin.class.getResource("images/key.2.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	//public Image img_logo = new ImageIcon(FormLogin.class.getResource("images/sabore_login.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	
		
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel pnlBtnLogin;
	private JLabel lblLogIn;
	private JLabel lblX;
	private JLabel lblIConLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	public FormLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new LineBorder(new Color(255, 140, 0), 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(202, 214, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 181, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(202, 282, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 180, 20);
		panel_1.add(txtPassword);
		
		pnlBtnLogin = new JPanel();
		pnlBtnLogin.setBackground(new Color(222, 184, 135));
		pnlBtnLogin.setBounds(202, 349, 256, 58);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		lblLogIn = new JLabel("LOG IN");
		lblLogIn.setForeground(new Color(47, 79, 79));
		lblLogIn.setFont(new Font("Arial", Font.BOLD, 16));
		lblLogIn.setBounds(110, 11, 121, 36);
		pnlBtnLogin.add(lblLogIn);
		
		lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(660, 0, 30, 40);
		contentPane.add(lblX);
		
		lblIConLogo = new JLabel("");
		lblIConLogo.setBounds(166, 22, 350, 181);
		contentPane.add(lblIConLogo);
		lblIConLogo.setIcon(new ImageIcon(img_logo));
		getContentPane().add(lblIConLogo);
		setLocationRelativeTo(null);//si asignamos null es para colocar a la ventana en el centro de la pantalla
	}
}
