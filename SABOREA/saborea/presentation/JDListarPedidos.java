package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.GetDataJTableORDENPEDIDO;
import saborea.model.bussiness.DTO.ListaPedidosBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.entities.Detalle_Pedido;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Window.Type;

public class JDListarPedidos extends JDialog implements MouseListener, ActionListener {

	ArrayList<ListaPedidosBE> _listaPedidos;
	private JScrollPane scrollPane;
	private JTable TABLA_LISTAPEDIDOS;
	TableRowSorter<DefaultTableModel> sorter;
	DefaultTableModel model =new DefaultTableModel();
	private JButton cancelButton;
	CredencialesBE _cred;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JDListarPedidos dialog = new JDListarPedidos();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public JDListarPedidos(java.awt.Frame parent, boolean modal,ArrayList<ListaPedidosBE> listaPedidos ) {
		super(parent,modal);
		setUndecorated(true);
		getContentPane().setBackground(new Color(240, 248, 255));
		_listaPedidos=listaPedidos;
	//	_cred=CRED;
		setBounds(100, 100, 1322, 748);
		getContentPane().setLayout(null);
		setTitle("LISTA DE PEDIDOS");
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(JDListarPedidos.class.getResource("/img/databasesearch_basededato_12920.png")));
			lblNewLabel_2.setBounds(10, 11, 65, 84);
			getContentPane().add(lblNewLabel_2);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(JDListarPedidos.class.getResource("/img/thi3s-69bny.png")));
			lblNewLabel_1.setBounds(1170, 0, 107, 126);
			getContentPane().add(lblNewLabel_1);
		}
		{
			JPanel TopPane = new JPanel();
			TopPane.setBackground(new Color(0, 128, 128));
			TopPane.setBounds(0, 32, 1273, 57);
			getContentPane().add(TopPane);
			TopPane.setLayout(null);
			{
				lblNewLabel = new JLabel("LISTA DE PEDIDOS ");
				lblNewLabel.setBounds(483, 11, 254, 35);
				TopPane.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
			}
			
			separator = new JSeparator();
			separator.setBounds(103, 25, 341, 2);
			TopPane.add(separator);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(764, 25, 388, 2);
			TopPane.add(separator_1);
		}
		{
			cancelButton = new JButton();
			cancelButton.setBackground(new Color(240, 248, 255));
			cancelButton.setBorder(null);
			cancelButton.setIcon(new ImageIcon(JDListarPedidos.class.getResource("/img/1486485553-ago-arrow-arrow-left-back-previous-direction-left_81160 (1).png")));
			cancelButton.addActionListener(this);
			cancelButton.setBounds(20, 637, 103, 74);
			getContentPane().add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 1290, 389);
		getContentPane().add(scrollPane);
		
		TABLA_LISTAPEDIDOS = new JTable();
		TABLA_LISTAPEDIDOS.setForeground(new Color(0, 0, 0));
		TABLA_LISTAPEDIDOS.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		TABLA_LISTAPEDIDOS.setBackground(new Color(240, 248, 255));
		TABLA_LISTAPEDIDOS.addMouseListener(this);
		TABLA_LISTAPEDIDOS.setBorder(new LineBorder(new Color(0, 128, 128)));
		scrollPane.setViewportView(TABLA_LISTAPEDIDOS);
		
		model= TablaPedidos.seeTable(TABLA_LISTAPEDIDOS, listaPedidos, sorter);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(JDListarPedidos.class.getResource("/img/1491254410-searchfinddetailzoom_82949.png")));
		lblNewLabel_3.setBounds(82, 105, 62, 57);
		getContentPane().add(lblNewLabel_3);
	
	
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == TABLA_LISTAPEDIDOS) {
			do_TABLA_LISTAPEDIDOS_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_TABLA_LISTAPEDIDOS_mouseClicked(MouseEvent e) {
		
		System.out.println("ENTRO A MOUSE CLICK");
		
		int fsel = TABLA_LISTAPEDIDOS.getSelectedRow();
		int column=TABLA_LISTAPEDIDOS.getColumnModel().getColumnIndexAtX(e.getX());
		int row= e.getY()/TABLA_LISTAPEDIDOS.getRowHeight();
		if(row<TABLA_LISTAPEDIDOS.getRowCount() && row>=0 && column<TABLA_LISTAPEDIDOS.getColumnCount() && column>=0){
			
			Object value = TABLA_LISTAPEDIDOS.getValueAt(row, column);
			
			if(value instanceof JButton){
				//si doy click al button
				((JButton) value).doClick();
				//devolvemos la acción
				JButton b= (JButton) value;
				
				System.out.println("Click en el button");
				//if(b.getName().equals("m")){	
					
//					System.out.println("ENTRO A MOUSE CLICK  BOTON MODIFICAR");
//					System.out.println("Click en el button MODIFICAR");						
					
					 model=(DefaultTableModel) TABLA_LISTAPEDIDOS.getModel();
						//System.out.println(TableProductos.getValueAt(fsel, 3));
					 
					String idPedido;
					 
					idPedido=TABLA_LISTAPEDIDOS.getValueAt(fsel, 0).toString();
				//	nombre= TABLA_LISTAPEDIDOS.getValueAt(fsel, 1).toString();
					//precio=TABLA_LISTAPEDIDOS.getValueAt(fsel, 2).toString();
						//stock=TableProductos.getValueAt(fsel, 3).toString();
					//cantidadSeleccionada=TABLA_LISTAPEDIDOS.getValueAt(fsel, 3).toString();
					 
					//data seleccionada para modificar
//					GetDataJTableORDENPEDIDO ObjData= new GetDataJTableORDENPEDIDO(
//							Integer.parseInt(id), 
//							nombre,
//							Double.parseDouble(precio),
//							Integer.parseInt(cantidadSeleccionada)
//							
//							);		
						
						
						//cantidad= txtCant.getText();
						

//					System.out.println("id : "+id);
//					System.out.println("cantidadSeleccionada :"+cantidadSeleccionada);
					
					ArrayList<VwDetallePedidoBE> listaDetalle_= new ArrayList<>();	
					
					for(int i=0; i<_listaPedidos.size();i++) {
						if(_listaPedidos.get(i).getIdpedido()==Integer.parseInt(idPedido)) {						
							for(int x=0;x<_listaPedidos.get(i).getListaDetalle().size();x++) {
								System.out.println(_listaPedidos.get(i).getListaDetalle().get(x).getNombreProducto());
								listaDetalle_.add(new VwDetallePedidoBE(
									_listaPedidos.get(i).getListaDetalle().get(x).getCodProducto(),
									_listaPedidos.get(i).getListaDetalle().get(x).getNombreProducto(), 
									_listaPedidos.get(i).getListaDetalle().get(x).getCantidad(),
									_listaPedidos.get(i).getListaDetalle().get(x).getPrecio(),
									_listaPedidos.get(i).getListaDetalle().get(x).getSubtotal()
									)
									
								);
							}
						}
					}
					
					
					
					JDDetalleOrdenListar DO= new JDDetalleOrdenListar(this,true,listaDetalle_);
					DO.setVisible(true);
					//VENTANA_MODIFICAR JDIALOG_CANT= new VENTANA_MODIFICAR(this,true, TABLA_LISTAPEDIDOS,objeto,ObjData);
					
					//JDIALOG_CANT.setVisible(true);						
					//lblTotalPagar.setText(objeto.getTotal()+ "");
					
				//}
					
//					JDDetalleOrdenListar jd= new JDDetalleOrdenListar ();
//					jd.setVisible(true);
							
			}
		
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
//		FormAdministrador frm= new FormAdministrador(_cred);
//		frm.setVisible(true);
		
	}
}
