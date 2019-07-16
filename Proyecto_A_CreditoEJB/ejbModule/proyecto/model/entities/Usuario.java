package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_IDUSUARIOS_GENERATOR", sequenceName="SEQ_USUARIOS",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_IDUSUARIOS_GENERATOR")
	@Column(name="id_usuarios", unique=true, nullable=false)
	private Integer idUsuarios;

	@Column(name="apellido_usuario", nullable=false, length=50)
	private String apellidoUsuario;

	@Column(name="cedula_usuario", length=10)
	private String cedulaUsuario;

	@Column(length=15)
	private String contrasena;

	@Column(name="correo_usario", length=50)
	private String correoUsario;

	@Column(name="direccion_usuario", length=50)
	private String direccionUsuario;

	@Column(name="nombre_usuario", length=50)
	private String nombreUsuario;

	@Column(name="telefono_usuario", length=10)
	private String telefonoUsuario;

	@Column(length=12)
	private String username;

	//bi-directional many-to-one association to CuentaCliente
	@OneToMany(mappedBy="usuario")
	private List<CuentaCliente> cuentaClientes;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="usuario")
	private List<Prestamo> prestamos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
	private Rol rol;

	public Usuario() {
	}

	public Integer getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(Integer idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getApellidoUsuario() {
		return this.apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCedulaUsuario() {
		return this.cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoUsario() {
		return this.correoUsario;
	}

	public void setCorreoUsario(String correoUsario) {
		this.correoUsario = correoUsario;
	}

	public String getDireccionUsuario() {
		return this.direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefonoUsuario() {
		return this.telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CuentaCliente> getCuentaClientes() {
		return this.cuentaClientes;
	}

	public void setCuentaClientes(List<CuentaCliente> cuentaClientes) {
		this.cuentaClientes = cuentaClientes;
	}

	public CuentaCliente addCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().add(cuentaCliente);
		cuentaCliente.setUsuario(this);

		return cuentaCliente;
	}

	public CuentaCliente removeCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().remove(cuentaCliente);
		cuentaCliente.setUsuario(null);

		return cuentaCliente;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setUsuario(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setUsuario(null);

		return prestamo;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}