package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import saborea.model.bussiness.EmpleadoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;
//import saborea.model.bussiness.DTO.PersonaDataBE;
import saborea.model.bussiness.DTO.VentanaTipoCargoBE;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;


public class FormLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField txtUsuario;
	private JLabel lblLogIn;
	private JButton btnIngresar;
	 private Container contenedor;
	 private JPasswordField passwordField;
	 private JLabel lblNewLabel_1;
	 private JLabel lblUsuarioSombra;
	 private JLabel lblPasswordSombra;
	 

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
	public void addPlaceHolderStyle(JTextField textField){
		Font font= textField.getFont();
		font=font.deriveFont(Font.ITALIC);
		textField.setFont(font);
		textField.setForeground(Color.gray);
		
	}
	public void removePlaceholderStyle(JTextField textField){
		Font font= textField.getFont();
		font=font.deriveFont(Font.PLAIN|Font.BOLD);
		textField.setFont(font);
		textField.setForeground(Color.black);
	}
	public FormLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormLogin.class.getResource("/img/Logo_Solitario_opt (3).png")));
		frameInit();
			
		contenedor=getContentPane();
		contenedor.setLayout(null);
		  //Asigna un titulo a la barra de titulo
		 setTitle("SABOREA");
		 //pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 242, 361);
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblUsuarioSombra = new JLabel("Ingrese usuario");
		lblUsuarioSombra.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		lblUsuarioSombra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblUsuarioSombra.setVisible(false);
				txtUsuario.setVisible(true);
				//Para que el cursor vaya hacia el lugar que se desea
				txtUsuario.requestFocus();
			}
		});
		lblUsuarioSombra.setForeground(new Color(211, 211, 211));
		lblUsuarioSombra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuarioSombra.setBounds(20, 156, 197, 19);
		panel.add(lblUsuarioSombra);
		
		lblPasswordSombra = new JLabel("Ingrese contrase\u00F1a");
		lblPasswordSombra.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		lblPasswordSombra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPasswordSombra.setVisible(false);
				passwordField.setVisible(true);
				passwordField.requestFocus();
			}
		});
		lblPasswordSombra.setForeground(new Color(211, 211, 211));
		lblPasswordSombra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasswordSombra.setBounds(20, 216, 197, 18);
		panel.add(lblPasswordSombra);
		
		passwordField = new JPasswordField();
		passwordField.setVisible(false);
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(20, 214, 197, 20);
		panel.add(passwordField);
		passwordField.setBackground(new Color(0, 139, 139));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(20, 197, 126, 14);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtUsuario = new JTextField();
		txtUsuario.setVisible(false);
		txtUsuario.setForeground(new Color(255, 255, 255));
		txtUsuario.setBounds(20, 155, 197, 20);
		panel.add(txtUsuario);
		txtUsuario.setFocusTraversalKeysEnabled(false);
		txtUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsuario.setBackground(new Color(0, 139, 139));
		txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtUsuario.setColumns(10);
		
		lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(20, 136, 96, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		//txtUsuario.addKeyListener(this);
		
		lblLogIn = new JLabel("LOGIN");
		lblLogIn.setForeground(new Color(255, 255, 255));
		lblLogIn.setBounds(39, 51, 126, 38);
		panel.add(lblLogIn);
		lblLogIn.setFont(new Font("Goudy Old Style", Font.BOLD, 34));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIngresar.setIcon(new ImageIcon(FormLogin.class.getResource("/img/_Path_.png")));
		btnIngresar.setBounds(20, 263, 197, 28);
		panel.add(btnIngresar);
		btnIngresar.addActionListener(this);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FormLogin.class.getResource("/img/Logo_Completo_usuario.png")));
		lblNewLabel_1.setBounds(241, 0, 392, 351);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {			
			do_btnIngresar_actionPerformed(arg0);
			
		}
	}
	
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
//		JTextField txtUsuario = new JTextField();
//		txtUsuario.setBounds(200, 73, 134, 20);
//		contentPane.add(txtUsuario);
//		contentPane.revalidate();
//		contentPane.repaint();
		
		//para los campos que vamos a ingresar los datos vamos a crear un array de caracteres 
		//vamos a traer al campo de la contrase�a 
		//char [] clave = jpassClave.getPassword();		
		
//		String user= txtUsuario.getText();
//		String clave=String.valueOf(passwordField.getPassword());				
		EmpleadoBussiness objEmpleadoB=new EmpleadoBussiness();		
		CredencialesBE Cred = objEmpleadoB.ValidarCredenciales(new String("WASHI"),new String("321"));				
		//new String("WASHI"),new String("321") mozo
		//new String("ARCADE"),new String("744") admin
		//new String("WASHI"),new String("321") cajero
		if(Cred==null) {					
			JOptionPane.showMessageDialog(null, "USUARIO O CONTRASE�A INCORRECTOS ","ERROR",JOptionPane.ERROR_MESSAGE);			
			txtUsuario.setText("");
			passwordField.setText("");
			//txtUsuario.grabFocus();
		}else{			
			VentanaTipoCargoBE vtc=new VentanaTipoCargoBE();			
			vtc.TipoVentana(Cred);	
			System.out.println(Cred.getEmpleadoId()+" "+Cred.getNombreEmpleado());
			//para que se cierre la ventana cuando abre otra ventana 
			this.dispose();
		}
		
		
		
	}
}