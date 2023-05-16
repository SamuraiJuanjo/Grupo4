package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.ClientService;
import Service.Conexion;
import models.Cliente;
import models.Fabricante;

public class ListViewClientes extends JFrame{
	private JPanel contentPane;
	private JTable jtableP;
	private final ClientService services = new ClientService();
	private List<Cliente> Clientes;
	private JButton ActivarB,BajaB,btnVolver;

	public ListViewClientes() {
		setTitle("Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 410, 183);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showCliente();
		scrollPane.setViewportView(jtableP);

		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAdmin ca = new ControlAdmin();
				dispose();
			}
		});
		btnVolver.setBounds(167, 236, 97, 25);
		contentPane.add(btnVolver);
		
		ActivarB = new JButton("Activar/Desactivar");
		ActivarB.setBounds(26, 12, 144, 23);
		contentPane.add(ActivarB);
		
		BajaB = new JButton("Dar de baja");
		BajaB.setBounds(180, 12, 124, 23);
		contentPane.add(BajaB);
		
		setVisible(true);
		ManejadorActionB mab= new ManejadorActionB();
		ActivarB.addActionListener(mab);

		
	}
	private class ManejadorActionB implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int filaS = jtableP.getSelectedRow();
			String nombreCliente = jtableP.getValueAt(filaS, 0).toString();
			
	
			Cliente c = Clientes.get(filaS);
			System.out.println(c.getActivar());
			if(b.equals(ActivarB)) {
				if(c.getActivar() == 1){
					String nombre = c.getNombreUsuario();
					try {
						Cliente datos = services.getCliente(Conexion.obtener(),nombre);
						String nom = "Prueba";
						String dir = datos.getDireccion();
						String rol = datos.getRol();
						String user = datos.getNombreUsuario();
						String cont = datos.getContrasena();
						Integer id =datos.getIdClientes();
						int act = 0; 
				
						datos.setIdClientes(id);
						datos.setNombre(nom);
						datos.setDireccion(dir);
						datos.setRol(rol);
						datos.setNombreUsuario(user);
						datos.setContrasena(cont);
						datos.setActivar(act);
						
						
						services.save(Conexion.obtener(), datos);
						
					} catch (ClassNotFoundException | SQLException e1) {
					
						e1.printStackTrace();
					}
		
				
				}
				else {
			
				}
			}
			
		}
		
		
	}

	
	private void showCliente() {
		try {
			this.Clientes = this.services.getAllCliente(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] {"id","Nombre", "Direccion","Rol","Usuario","Contasenya","Activar" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);
			for (int i = 0; i < this.Clientes.size(); i++) {
				dtm.addRow(new Object[] {this.Clientes.get(i).getIdClientes(),this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(),this.Clientes.get(i).getRol(),
						this.Clientes.get(i).getNombreUsuario(),this.Clientes.get(i).getContrasena(),this.Clientes.get(i).getActivar()});
			}
	

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}
}
