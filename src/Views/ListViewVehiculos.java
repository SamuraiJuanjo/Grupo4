package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ListViewVehiculos.
 */
public class ListViewVehiculos extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The jtable P. */
	private JTable jtableP;

	/** The services. */
	private final VehiculoService services = new VehiculoService();

	/** The vehiculo. */
	private List<Vehiculo> vehiculo;

	/**
	 * Instantiates a new list view vehiculos.
	 */
	public ListViewVehiculos() {
		setTitle("Vehiculos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon("images/crear.png"));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListViewVehiculos.this.dispose();
				SaveViewVehiculos vista = new SaveViewVehiculos();
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
			}
		});
		btnCreate.setBounds(80, 11, 50, 50);
		contentPane.add(btnCreate);

		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon("images/update.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila_seleccionada = jtableP.getSelectedRow();
				if (fila_seleccionada >= 0) {
					ListViewVehiculos.this.dispose();
					SaveViewVehiculos vista = new SaveViewVehiculos(vehiculo.get(fila_seleccionada));
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(ListViewVehiculos.this, "Por favor seleccione una fila.");
				}
			}
		});
		btnUpdate.setBounds(196, 11, 50, 50);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("images/eliminar.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila_seleccionada = jtableP.getSelectedRow();
				if (fila_seleccionada >= 0) {
					int decision = JOptionPane.showConfirmDialog(null,
							"¿Está seguro/a que desea eliminar este producto?", "Advertencia",
							JOptionPane.YES_NO_OPTION);
					if (decision == 0) {
						try {
							services.remove(Conexion.obtener(), vehiculo.get(fila_seleccionada));
							showVehiculos();
						} catch (SQLException ex) {
							System.out.println(ex.getMessage());
							JOptionPane.showMessageDialog(ListViewVehiculos.this,
									"Ha surgido un error y no se ha podido eliminar el registro.");
						} catch (ClassNotFoundException ex) {
							System.out.println(ex);
							JOptionPane.showMessageDialog(ListViewVehiculos.this,
									"Ha surgido un error y no se ha podido eliminar el registro.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(ListViewVehiculos.this, "Por favor seleccione una fila.");
				}
			}
		});
		btnDelete.setBounds(335, 11, 50, 50);
		contentPane.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 74, 392, 152);
		contentPane.add(scrollPane);

		jtableP = new JTable();
		showVehiculos();
		scrollPane.setViewportView(jtableP);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAdmin ca = new ControlAdmin();
				dispose();
			}
		});
		btnVolver.setBounds(0, 244, 434, 27);
		contentPane.add(btnVolver);

	}

	/**
	 * Show vehiculos.
	 */
	public void showVehiculos() {
		try {
			this.vehiculo = this.services.getAllVehiculos(Conexion.obtener());
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
