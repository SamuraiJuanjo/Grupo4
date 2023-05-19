package Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Service.ClientService;
import Service.Conexion;
import models.Cliente;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CreacionUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField NombreT;
	private JTextField ApellidoT;
	private JTextField DireccionT;
	private JTextField UsuarioT;
	private JPasswordField ContraseñaP;
	private JPasswordField CContraseñaP;
	private JTextField txtDebil;
	private JTextField txtFuerte;
	private JTextField txtModerado;
	private JButton ConfrimarB, CancelarB;
	private final ClientService services = new ClientService();
	private List<Cliente> user;
	private JLabel lblNewLabel;

	public CreacionUsuario() {

		setTitle("Creacion de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel NombreL = new JLabel("Nombre");
		NombreL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		NombreL.setBounds(52, 59, 46, 14);
		contentPane.add(NombreL);

		JLabel ApellidosL = new JLabel("Apellidos");
		ApellidosL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		ApellidosL.setBounds(52, 83, 93, 14);
		contentPane.add(ApellidosL);

		JLabel DireccionL = new JLabel("Direccion");
		DireccionL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		DireccionL.setBounds(52, 108, 93, 14);
		contentPane.add(DireccionL);

		JLabel Usuario = new JLabel("Usuario");
		Usuario.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		Usuario.setBounds(52, 133, 93, 14);
		contentPane.add(Usuario);

		JLabel ContraseñaL = new JLabel("Contraseña");
		ContraseñaL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		ContraseñaL.setBounds(52, 158, 93, 14);
		contentPane.add(ContraseñaL);

		JLabel CContraseñaL = new JLabel("Confirmar Contraseña");
		CContraseñaL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		CContraseñaL.setBounds(52, 183, 135, 14);
		contentPane.add(CContraseñaL);

		NombreT = new JTextField();
		NombreT.setBounds(197, 56, 141, 20);
		contentPane.add(NombreT);
		NombreT.setColumns(10);

		ApellidoT = new JTextField();
		ApellidoT.setColumns(10);
		ApellidoT.setBounds(197, 80, 141, 20);
		contentPane.add(ApellidoT);

		DireccionT = new JTextField();
		DireccionT.setText("C/");
		DireccionT.setColumns(10);
		DireccionT.setBounds(197, 105, 141, 20);
		contentPane.add(DireccionT);

		UsuarioT = new JTextField();
		UsuarioT.setColumns(10);
		UsuarioT.setBounds(197, 130, 141, 20);
		contentPane.add(UsuarioT);

		ContraseñaP = new JPasswordField();
		ContraseñaP.setBounds(197, 155, 141, 20);
		contentPane.add(ContraseñaP);

		CContraseñaP = new JPasswordField();
		CContraseñaP.setBounds(197, 180, 141, 20);
		contentPane.add(CContraseñaP);

		ConfrimarB = new JButton("Guardar");
		ConfrimarB.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		ConfrimarB.setBounds(97, 227, 113, 34);
		contentPane.add(ConfrimarB);

		txtDebil = new JTextField();
		txtDebil.setHorizontalAlignment(SwingConstants.CENTER);
		txtDebil.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		txtDebil.setEditable(false);
		txtDebil.setVisible(false);
		txtDebil.setText("Debil");
		txtDebil.setBackground(new Color(128, 255, 255));
		txtDebil.setBounds(355, 155, 69, 20);
		contentPane.add(txtDebil);
		txtDebil.setColumns(10);

		txtFuerte = new JTextField();
		txtFuerte.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuerte.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		txtFuerte.setBackground(new Color(255, 0, 0));
		txtFuerte.setText("Fuerte");
		txtFuerte.setVisible(false);
		txtFuerte.setEditable(false);
		txtFuerte.setBounds(355, 155, 69, 20);
		contentPane.add(txtFuerte);
		txtFuerte.setColumns(10);

		txtModerado = new JTextField();
		txtModerado.setHorizontalAlignment(SwingConstants.CENTER);
		txtModerado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		txtModerado.setEditable(false);
		txtModerado.setBackground(new Color(255, 128, 64));
		txtModerado.setText("Moderado");
		txtModerado.setVisible(false);
		txtModerado.setBounds(355, 155, 69, 20);
		contentPane.add(txtModerado);
		txtModerado.setColumns(10);

		CancelarB = new JButton("Cancelar");
		CancelarB.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		CancelarB.setBounds(251, 227, 113, 34);
		contentPane.add(CancelarB);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images/iconoUser.png"));
		lblNewLabel.setBounds(10, 0, 414, 45);
		contentPane.add(lblNewLabel);

		manejadorAction ma = new manejadorAction();
		ContraseñaP.addActionListener(ma);
		CContraseñaP.addActionListener(ma);
		manejadorActionBoton mab = new manejadorActionBoton();
		CancelarB.addActionListener(mab);
		ConfrimarB.addActionListener(mab);

		setVisible(true);
	}

	private class manejadorAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField j = (JTextField) e.getSource();
			if (j.equals(ContraseñaP)) {
				Contraseña();
			} else if (j.equals(CContraseñaP)) {
				confrimarContraseña();
			}
		}
	}

	private class manejadorActionBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.equals(CancelarB)) {
				Login l = new Login();
				dispose();
			} else if (b.equals(ConfrimarB)) {
				String nombre = NombreT.getText();
				String apellido = ApellidoT.getText();
				String nombreC = nombre + " " + apellido;
				String direccion = DireccionT.getText();
				String rol = "Cliente";
				String usuario = UsuarioT.getText();
				char[] contra = ContraseñaP.getPassword();
				String contrasenya = new String(contra);
				char[] ccontra = CContraseñaP.getPassword();
				String ccontrasenya = new String(ccontra);
				int act = 1;

				if (NombreT.getText().isEmpty() || ApellidoT.getText().isEmpty() || DireccionT.getText().isEmpty()
						|| UsuarioT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(CreacionUsuario.this, "Formulario erroneo", "Aviso",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!comprabarCliente()) {
						JOptionPane.showMessageDialog(CreacionUsuario.this, "El usuario ya existe", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (!contrasenya.matches("[A-Z].*[0-9].*"))
						JOptionPane.showMessageDialog(CreacionUsuario.this,
								"La contraseña debe empezar por Mayuscula y contener un numero", "Aviso",
								JOptionPane.ERROR_MESSAGE);
					else if (!contrasenya.equals(ccontrasenya))
						JOptionPane.showMessageDialog(CreacionUsuario.this, "Las contraseñas no coinciden", "Aviso",
								JOptionPane.ERROR_MESSAGE);
					else {
						Cliente c = new Cliente(nombreC, direccion, rol, usuario, contrasenya, act);

						try {
							services.save(Conexion.obtener(), c);
							JOptionPane.showMessageDialog(CreacionUsuario.this, "Usuario creado", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							Login l = new Login();
							dispose();
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

			}
		}
	}
	// }

	public void Contraseña() {
		char[] user = ContraseñaP.getPassword();
		String userS = new String(user);
		System.out.println(userS);
		if (userS.matches("[A-Z].*[0-9].*")) {
			if (userS.length() <= 5) {
				txtFuerte.setVisible(false);
				txtModerado.setVisible(false);
				txtDebil.setVisible(true);

			} else if (userS.length() > 5 && userS.length() < 8) {
				txtDebil.setVisible(false);
				txtFuerte.setVisible(false);
				txtModerado.setVisible(true);
			} else {
				txtDebil.setVisible(false);
				txtModerado.setVisible(false);
				txtFuerte.setVisible(true);

			}

		} else
			JOptionPane.showMessageDialog(CreacionUsuario.this,
					"La contraseña debe empezar por Mayuscula y contener un numero");

	}

	public void confrimarContraseña() {
		char[] user = ContraseñaP.getPassword();
		String userS = new String(user);

		char[] cont = CContraseñaP.getPassword();
		String contS = new String(cont);

		if (contS.equals(userS)) {

		} else
			JOptionPane.showMessageDialog(CreacionUsuario.this, "Las contraseñas no coinciden", contS,
					JOptionPane.ERROR_MESSAGE, null);

	}

	public boolean comprabarCliente() {

		try {
			user = services.getAllCliente(Conexion.obtener());
			String usuario = UsuarioT.getText();
			for (Cliente c : user) {
				if (c.getNombreUsuario().equals(usuario)) {
					return false;
				}

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
