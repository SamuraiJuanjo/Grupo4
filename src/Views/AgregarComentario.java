package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Service.ClientService;
import Service.ComentarioService;
import Service.Conexion;
import Service.VehiculoService;
import models.Cliente;
import models.Comentario;
import models.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class AgregarComentario.
 */
public class AgregarComentario extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The text area. */
	private static JTextArea textArea;

	/** The Constant service. */
	private final static ComentarioService service = new ComentarioService();

	/** The serviceveh. */
	private final VehiculoService serviceveh = new VehiculoService();

	/** The servicec. */
	private final ClientService servicec = new ClientService();

	/** The vehiculo. */
	private Vehiculo vehiculo;

	/** The cliente. */
	private Cliente cliente;

	/** The comentarios. */
	private List<Comentario> comentarios = new ArrayList<>();

	/** The btn enviar. */
	private JButton btnCancelar, btnEnviar;

	/**
	 * Instantiates a new agregar comentario.
	 */
	public AgregarComentario() {
		super("Agregar Comentario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 230);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(163, 163, 165));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Agrega un comentario para el vehículo seleccionado.");
		lblTitulo.setBounds(5, 5, 390, 21);
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitulo);

		textArea = new JTextArea();
		textArea.setBounds(31, 36, 343, 104);
		contentPane.add(textArea);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateValoracion();
				updateVehiculo();
				updateCliente();

				JOptionPane.showMessageDialog(null, "El comentario ha sido Enviado con exito!", "Envio completado",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnEnviar.setBounds(61, 150, 98, 33);
		contentPane.add(btnEnviar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "El comentario ha sido Cancelado!", "Cancelar comentario",
						JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(238, 150, 98, 33);
		contentPane.add(btnCancelar);
	}

	/**
	 * Update valoracion.
	 */
	public void updateValoracion() {
		try {
			String comentario = textArea.getText();
			String nomUser = Login.getnombreUser();

			Comentario c = new Comentario();
			c.setIdCliente(Login.getidClienteLogin());
			c.setIdVehiculo(Login.getidVehiculo());
			c.setComentario(nomUser + ": \n" + comentario);

			service.save(Conexion.obtener(), c);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Update vehiculo.
	 */
	public void updateVehiculo() {
		try {
			vehiculo = serviceveh.getVehiculo(Conexion.obtener(), Login.getidVehiculo());

			String mod = vehiculo.getModelo();
			String mar = vehiculo.getMarca();
			int anyo = vehiculo.getAnyo();
			String color = vehiculo.getColor();
			float precio = vehiculo.getPrecio();
			int idF = vehiculo.getIdFabricante();
			String rut = vehiculo.getRuta();
			int comp = vehiculo.getComprado();
			int alqui = vehiculo.getAlquilado();
			int numC = (vehiculo.getNumcomentarios() + 1);
			int numVa = vehiculo.getNumvaloraciones();

			vehiculo.setIdVehiculos(Login.getidVehiculo());
			vehiculo.setModelo(mod);
			vehiculo.setMarca(mar);
			vehiculo.setAnyo(anyo);
			vehiculo.setColor(color);
			vehiculo.setPrecio(precio);
			vehiculo.setIdFabricante(idF);
			vehiculo.setRuta(rut);
			vehiculo.setComprado(comp);
			vehiculo.setAlquilado(alqui);
			vehiculo.setNumcomentarios(numC);
			vehiculo.setNumvaloraciones(numVa);
			serviceveh.save(Conexion.obtener(), vehiculo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Update cliente.
	 */
	public void updateCliente() {
		try {
			cliente = servicec.getClienteId(Conexion.obtener(), Login.getidClienteLogin());
			Integer id = Login.getidClienteLogin();
			String nom = cliente.getNombre();
			String dir = cliente.getDireccion();
			String rol = cliente.getRol();
			String user = cliente.getNombreUsuario();
			String cont = cliente.getContrasena();
			int act = cliente.getActivar();
			int numCP = (cliente.getNumCompras());
			int numA = cliente.getNumAlquileres();
			int numCO = (cliente.getNumComentarios() + 1);

			int numV = cliente.getNumValoraciones();
			cliente.setIdClientes(id);
			cliente.setNombre(nom);
			cliente.setDireccion(dir);
			cliente.setRol(rol);
			cliente.setNombreUsuario(user);
			cliente.setContrasena(cont);
			cliente.setActivar(act);
			cliente.setNumCompras(numCP);
			cliente.setNumAlquileres(numA);
			cliente.setNumComentarios(numCO);
			cliente.setNumValoracion(numV);

			servicec.save(Conexion.obtener(), cliente);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
