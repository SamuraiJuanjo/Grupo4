package models;


public class Cliente {

	private Integer idClientes;
    private String nombre,direccion;
    private String rol;
    private String nombreUsuario,contrasena;
	public int activar, numCompras, numAlquileres,numComentarios,numValoracion;

	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar, int numCompras) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
		this.numCompras = numCompras;
	}
	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar, int numCompras, int numAlquileres) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
		this.numCompras = numCompras;
		this.numAlquileres = numAlquileres;

	}

	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar, int numCompras, int numAlquileres, int numComentarios,int numValoracion) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
		this.numCompras = numCompras;
		this.numAlquileres = numAlquileres;
		this.numComentarios = numComentarios;
		this.numValoracion = numValoracion;
	}

	public int getNumCompras() {
		return numCompras;
	}

	public void setNumCompras(int numCompras) {
		this.numCompras = numCompras;
	}

	public int getNumAlquileres() {
		return numAlquileres;
	}

	public void setNumAlquileres(int numAlquileres) {
		this.numAlquileres = numAlquileres;
	}

	public Integer getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	public int getActivar() {
		return activar;
	}

	public void setActivar(int activar) {
		this.activar = activar;
	}
	

	public int getNumComentarios() {
		return numComentarios;
	}
	public void setNumComentarios(int numComentarios) {
		this.numComentarios = numComentarios;
	}
	public int getNumValoracion() {
		return numValoracion;
	}
	public void setNumValoracion(int numValoracion) {
		this.numValoracion = numValoracion;
	}
	public Cliente(String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena,int activar) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar=activar;
	}
	
	
	
	

	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena,int activar) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar=activar;
		
	}

	public Cliente() {
		super();
	}
	@Override
	public String toString() {
		return "Cliente [idClientes=" + idClientes + ", nombre=" + nombre + ", direccion=" + direccion + ", rol=" + rol
				+ ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + "]";
	}
    
	

    
}
