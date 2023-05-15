package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Service.Conexion;
import Service.VehiculoService;
import models.Vehiculo;

public class ComprarVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;
	private final VehiculoService services = new VehiculoService();
	private final Vehiculo vehiculo;
	private JButton btnComprar, btnCancelar;
	private JLabel lblImagen;
	private String ruta;

	/**
	 * Create the frame.
	 */
	
	public ComprarVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		initComponents();
		txtModelo.setText(this.vehiculo.getModelo());
		txtMarca.setText(this.vehiculo.getMarca());
		txtAnyo.setText(String.valueOf(this.vehiculo.getAnyo()));
		txtColor.setText(this.vehiculo.getColor());
		txtPrecio.setText(String.valueOf(this.vehiculo.getPrecio()));
		txtIdFabricante.setText(String.valueOf(this.vehiculo.getIdFabricante()));
		ruta = this.vehiculo.getRuta();
		
	}
	public ComprarVehiculo() {
		this.vehiculo=new Vehiculo();
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Coche seleccionado Para la Compra");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 130, 380, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(30, 26, 61, 16);
		contentPane.add(lblModelo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(30, 62, 61, 16);
		contentPane.add(lblMarca);
		
		JLabel lbAnyo = new JLabel("Anyo:");
		lbAnyo.setBounds(30, 98, 61, 16);
		contentPane.add(lbAnyo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(30, 134, 61, 16);
		contentPane.add(lblColor);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(30, 170, 61, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblidFabricante = new JLabel("IdFabricante:");
		lblidFabricante.setBounds(30, 206, 80, 16);
		contentPane.add(lblidFabricante);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(130, 26, 190, 26);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		txtModelo.setEditable(false);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(130, 62, 190, 26);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		txtMarca.setEditable(false);
		
		txtAnyo = new JTextField();
		txtAnyo.setBounds(130, 98, 190, 26);
		contentPane.add(txtAnyo);
		txtAnyo.setColumns(10);
		txtAnyo.setEditable(false);
		
		txtColor = new JTextField();
		txtColor.setBounds(130, 134, 190, 26);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		txtColor.setEditable(false);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(130, 170, 190, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setEditable(false);
		
		txtIdFabricante = new JTextField();
		txtIdFabricante.setBounds(130, 206, 190, 26);
		contentPane.add(txtIdFabricante);
		txtIdFabricante.setColumns(10);
		txtIdFabricante.setEditable(false);
		
		ManejadorJButton manejador = new ManejadorJButton();
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(46, 354, 117, 29);
		btnComprar.addActionListener(manejador);
		contentPane.add(btnComprar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(203, 354, 117, 29);
		btnCancelar.addActionListener(manejador);
		contentPane.add(btnCancelar);
		
		lblImagen = new JLabel("Imagen:");
		lblImagen.setBounds(30, 247, 80, 16);
		contentPane.add(lblImagen);
		
		JPanel panel = new JPanel();
		panel.setBounds(130, 242, 190, 92);
		contentPane.add(panel);
		
		JLabel imagenLabel = new JLabel();
	    ImageIcon imagen = new ImageIcon(ruta); 
	    imagenLabel.setIcon(imagen);
	    panel.add(imagenLabel);
		
	}
	
	private class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if(o == btnComprar) {
				String modelo = txtModelo.getText();
				String marca = txtMarca.getText();
				int anyo = Integer.parseInt(txtAnyo.getText());
				String color = txtColor.getText();
				float precio = Float.parseFloat(txtPrecio.getText());
				int idFabricante = Integer.parseInt(txtIdFabricante.getText());
				String ruta = "";
				
				vehiculo.setModelo(modelo);
				vehiculo.setMarca(marca);
				vehiculo.setAnyo(anyo);
				vehiculo.setColor(color);
				vehiculo.setPrecio(precio);
				vehiculo.setIdFabricante(idFabricante);
				vehiculo.setRuta(ruta);
				
				
				try {
					services.save(Conexion.obtener(), vehiculo);
					ComprarVehiculo.this.dispose();
					ListViewVehiculos vista = new ListViewVehiculos();
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(ComprarVehiculo.this, "Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(ComprarVehiculo.this, "Ha surgido un error y no se ha podido guardar el registro.");
				}
			}else if(o == btnCancelar) {
				JOptionPane.showMessageDialog(null, "La compra ha sido cancelada.", "Cancelacion", JOptionPane.ERROR_MESSAGE);
				dispose();
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
			}			
		}
	}
}
