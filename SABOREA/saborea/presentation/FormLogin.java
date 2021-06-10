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


public class FormLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField txtUsuario;
	private JLabel lblLogIn;
	private JButton btnIngresar;
	 private Container contenedor;
	 private JPasswordField passwordField;
	 

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
		frameInit();
			
		contenedor=getContentPane();
		contenedor.setLayout(null);
		  //Asigna un titulo a la barra de titulo
		 setTitle("LOGIN");
		 //tama�o de la ventana
		 setSize(400,200);
		 //pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario : ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 87, 70, 14);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setBounds(28, 126, 70, 14);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		//txtUsuario.addKeyListener(this);
		
		lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(52, 11, 126, 38);
		contentPane.add(lblLogIn);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(123, 171, 126, 38);
		contentPane.add(btnIngresar);
		txtUsuario.setFocusTraversalKeysEnabled(false);
		txtUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsuario.setBackground(Color.PINK);
		txtUsuario.setBorder(null);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUsuario.setBounds(94, 85, 144, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.PINK);
		passwordField.setBorder(null);
		passwordField.setBounds(104, 120, 155, 20);
		contentPane.add(passwordField);
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
		CredencialesBE Cred = objEmpleadoB.ValidarCredenciales(new String("ARCADE"),new String("744"));				
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