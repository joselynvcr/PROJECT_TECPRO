package saborea.presentation;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;

import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

import javax.swing.JButton;


import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;


public class FormMozo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnSalir;
	private Container contenedor;
	private CredencialesBE Cred;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Mozo frame = new Mozo();
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
	public FormMozo(CredencialesBE cred) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormMozo.class.getResource("/img/Logo_Solitario_opt.png")));
		//JPanel PanelRegistrarProducto = new JPanel();
		
		
		Cred=cred;
		contenedor=getContentPane();
		contenedor.setLayout(null);
		        //Asigna un titulo a la barra de titulo
		 setTitle("SABOREA");
		 //tamaño de la ventana
		 //setSize(788,489);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("MESA 1");
		btnNewButton.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnNewButton.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 105, 30));
		panel_1.setBounds(0, 0, 849, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("BIENVENIDO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 23));
		lblNewLabel_3.setBounds(0, 0, 849, 71);
		panel_1.add(lblNewLabel_3);
		btnNewButton.setBounds(235, 133, 138, 138);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 66, 212, 485);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(FormMozo.class.getResource("/img/icon_mozo.png")));
		lblNewLabel_2.setBounds(0, 22, 212, 166);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(cred.getTipoCargo());
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 257, 212, 21);
		panel.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel(cred.getNombreEmpleado()+" "+ cred.getApellidoEmpleado());
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 197, 212, 49);
		panel.add(lblNewLabel);
		
		btnSalir = new JButton("           SALIR");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(0, 430, 211, 49);
		panel.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon(FormMozo.class.getResource("/img/log-out (1).png")));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.addActionListener(this);
		
		JButton btnMesa5 = new JButton("MESA 5");
		btnMesa5.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa5.setBorder(null);
		btnMesa5.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMesa5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa5.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa5.setContentAreaFilled(false);
		btnMesa5.setBounds(237, 358, 138, 138);
		contentPane.add(btnMesa5);
		
		JButton btnMesa2 = new JButton("MESA 2");
		btnMesa2.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa2.setBorder(null);
		btnMesa2.setContentAreaFilled(false);
		btnMesa2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa2.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa2.setBounds(391, 133, 138, 138);
		contentPane.add(btnMesa2);
		
		JButton btnMesa3 = new JButton("MESA 3");
		btnMesa3.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa3.setBorder(null);
		btnMesa3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa3.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa3.setContentAreaFilled(false);
		btnMesa3.setBounds(539, 133, 138, 138);
		contentPane.add(btnMesa3);
		
		JButton btnMesa4 = new JButton("MESA 4");
		btnMesa4.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa4.setBorder(null);
		btnMesa4.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa4.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa4.setContentAreaFilled(false);
		btnMesa4.setBounds(687, 133, 138, 138);
		contentPane.add(btnMesa4);
		
		JButton btnMesa6 = new JButton("MESA 6");
		btnMesa6.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa6.setBorder(null);
		btnMesa6.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa6.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa6.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa6.setContentAreaFilled(false);
		btnMesa6.setBounds(391, 358, 138, 138);
		contentPane.add(btnMesa6);
		
		JButton btnMesa7 = new JButton("MESA 7");
		btnMesa7.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa7.setBorder(null);
		btnMesa7.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa7.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa7.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa7.setContentAreaFilled(false);
		btnMesa7.setBounds(539, 358, 138, 138);
		contentPane.add(btnMesa7);
		
		JButton btnMesa8 = new JButton("MESA 8");
		btnMesa8.setRolloverIcon(new ImageIcon(FormMozo.class.getResource("/img/cena (1).png")));
		btnMesa8.setBorder(null);
		btnMesa8.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		btnMesa8.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMesa8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMesa8.setIcon(new ImageIcon(FormMozo.class.getResource("/img/cena.png")));
		btnMesa8.setContentAreaFilled(false);
		btnMesa8.setBounds(687, 358, 138, 138);
		contentPane.add(btnMesa8);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setIcon(new ImageIcon(FormMozo.class.getResource("/img/Nuevo proyecto.png")));
		lblNewLabel_4.setBounds(211, 74, 638, 477);
		contentPane.add(lblNewLabel_4);
		
		
//		PanelRegistrarProducto panel = new PanelRegistrarProducto(null);
//		panel.setBounds(0, 0, 772, 416);
//		contentPane.add(panel,BorderLayout.CENTER);
		
		
		 //pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);			
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
		
	
	
	//BUTTON EXIT TO LOGIN
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		FormLogin fl= new FormLogin();
		fl.setVisible(true);
		this.dispose();
		
		
	}	
	//BUTTON MESA 1
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {	
		//TRAER LA DATA DESDE LA BD 		
		int mesa=1;//capturar desde el formulario
		//para rellenar obj se tiene que buscar a las ordenes de la mesa 1 pagado=F enviado=F
		
		RegistroPedidoProductoBussiness RegistroPedidoProducto= new RegistroPedidoProductoBussiness();	
		//traer los cambios desde la BD
		VwRegistroPedidoProductoBE VWOrdenPedidoRegistrado =RegistroPedidoProducto.findPedidos(Cred, mesa);		
		
		
		FormRegistrarPedido frp= new FormRegistrarPedido(VWOrdenPedidoRegistrado,Cred);
		
		
		frp.setVisible(true);
		this.dispose();
		
		
		
		
		
		
		
	}
}
