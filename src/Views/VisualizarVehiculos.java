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

import Service.Conexion;
import Service.VehiculoService;
import models.Vehiculo;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarVehiculos.
 */
public class VisualizarVehiculos extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The jtable P. */
	private JTable jtableP;

	/** The services. */
	private final VehiculoService services = new VehiculoService();

	/** The vehiculo. */
	private List<Vehiculo> vehiculo;

	/**
	 * Instantiates a new visualizar vehiculos.
	 */
	public VisualizarVehiculos() {
		setTitle("Vehiculos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 396);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 77, 408, 225);
		contentPane.add(scrollPane);

		jtableP = new JTable();
		showVehiculosIdFabricante();
		scrollPane.setViewportView(jtableP);

		JButton VolverB = new JButton("Volver");
		VolverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		VolverB.setBounds(52, 321, 414, 25);
		contentPane.add(VolverB);

		JLabel lblNewLabel = new JLabel("Visualizacion de los Vehiculos Creados");
		lblNewLabel.setBounds(145, 53, 242, 13);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}

	/**
	 * Show vehiculos.
	 */
	public void showVehiculos() {
		try {
			this.vehiculo = this.services.getAllVehiculos(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "idVenta", "Fecha", "Modelo", "Marca", "Anyo", "Color", "Precio" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			jtableP = new JTable(dtm) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			for (int i = 0; i < this.vehiculo.size(); i++) {
				dtm.addRow(new Object[] { this.vehiculo.get(i).getIdVehiculos(), this.vehiculo.get(i).getModelo(),
						this.vehiculo.get(i).getMarca(), this.vehiculo.get(i).getAnyo(),
						this.vehiculo.get(i).getColor(), this.vehiculo.get(i).getPrecio(),
						this.vehiculo.get(i).getIdFabricante() });
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * Show vehiculos id fabricante.
	 */
	public void showVehiculosIdFabricante() {
		try {
			this.vehiculo = this.services.getAllVehiculosFabric(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "idVehiculos", "Modelo", "Marca", "Anyo", "Color", "Precio", "idFabricante" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			jtableP = new JTable(dtm) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			for (int i = 0; i < this.vehiculo.size(); i++) {
				dtm.addRow(new Object[] { this.vehiculo.get(i).getIdVehiculos(), this.vehiculo.get(i).getModelo(),
						this.vehiculo.get(i).getMarca(), this.vehiculo.get(i).getAnyo(),
						this.vehiculo.get(i).getColor(), this.vehiculo.get(i).getPrecio(),
						this.vehiculo.get(i).getIdFabricante() });
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
