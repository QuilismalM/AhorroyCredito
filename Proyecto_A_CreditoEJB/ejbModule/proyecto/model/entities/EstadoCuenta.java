package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_cuenta database table.
 * 
 */
@Entity
@Table(name="estado_cuenta")
@NamedQuery(name="EstadoCuenta.findAll", query="SELECT e FROM EstadoCuenta e")
public class EstadoCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADO_CUENTA_IDESTADOCUENTA_GENERATOR", sequenceName="SEQ_ESTADO_CUENTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_CUENTA_IDESTADOCUENTA_GENERATOR")
	@Column(name="id_estado_cuenta", unique=true, nullable=false)
	private Integer idEstadoCuenta;

	@Column(name="nombre_estadoc", length=50)
	private String nombreEstadoc;

	//bi-directional many-to-one association to CuentaCliente
	@OneToMany(mappedBy="estadoCuenta")
	private List<CuentaCliente> cuentaClientes;

	public EstadoCuenta() {
	}

	public Integer getIdEstadoCuenta() {
		return this.idEstadoCuenta;
	}

	public void setIdEstadoCuenta(Integer idEstadoCuenta) {
		this.idEstadoCuenta = idEstadoCuenta;
	}

	public String getNombreEstadoc() {
		return this.nombreEstadoc;
	}

	public void setNombreEstadoc(String nombreEstadoc) {
		this.nombreEstadoc = nombreEstadoc;
	}

	public List<CuentaCliente> getCuentaClientes() {
		return this.cuentaClientes;
	}

	public void setCuentaClientes(List<CuentaCliente> cuentaClientes) {
		this.cuentaClientes = cuentaClientes;
	}

	public CuentaCliente addCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().add(cuentaCliente);
		cuentaCliente.setEstadoCuenta(this);

		return cuentaCliente;
	}

	public CuentaCliente removeCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().remove(cuentaCliente);
		cuentaCliente.setEstadoCuenta(null);

		return cuentaCliente;
	}

}