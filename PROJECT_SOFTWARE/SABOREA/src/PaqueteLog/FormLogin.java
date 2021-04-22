package PaqueteLog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FormLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField txtUsuario;
	private JLabel lblLogIn;
	private JButton btnIngresar;
	private JPasswordField jpassClave;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario : ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 76, 70, 14);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setBounds(28, 122, 70, 14);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(115, 73, 134, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(84, 11, 126, 38);
		contentPane.add(lblLogIn);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(84, 172, 109, 36);
		contentPane.add(btnIngresar);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(119, 120, 130, 20);
		contentPane.add(jpassClave);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		//para los campos que vamos a ingresar los datos vamos a crear un array de caracteres 
		//vamos a traer al campo de la contrase�a 
		char [] clave = jpassClave.getPassword();
		//creamos unva variable de tipo cadena 
		String claveFinal= new String (clave);
		if((txtUsuario.getText().equals("Diego")) && (claveFinal.equals("123"))){
			dispose();
			JOptionPane.showMessageDialog(null,"Bienvenidos al sistema "," INGRESASTE ", JOptionPane.INFORMATION_MESSAGE);			
			//llamo a mi ventana principal
			principal p= new principal();
			p.setVisible(true);
		}else{			
			JOptionPane.showMessageDialog(null,"USUARIO O CONTRASE�A INCORRECTOS ","ERROR ", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			jpassClave.setText("");
			txtUsuario.grabFocus();
		}
		
		
		
	}
	
	
}