package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_cuenta database table.
 * 
 */
@Entity
@Table(name="tipo_cuenta")
@NamedQuery(name="TipoCuenta.findAll", query="SELECT t FROM TipoCuenta t")
public class TipoCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_CUENTA_IDTIPOCUENTA_GENERATOR", sequenceName="SEQ_TIPO_CUENTA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_CUENTA_IDTIPOCUENTA_GENERATOR")
	@Column(name="id_tipo_cuenta", unique=true, nullable=false)
	private Integer idTipoCuenta;

	@Column(name="nombre_tipo_cuenta", length=50)
	private String nombreTipoCuenta;

	//bi-directional many-to-one association to CuentaCliente
	@OneToMany(mappedBy="tipoCuenta")
	private List<CuentaCliente> cuentaClientes;

	public TipoCuenta() {
	}

	public Integer getIdTipoCuenta() {
		return this.idTipoCuenta;
	}

	public void setIdTipoCuenta(Integer idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}

	public String getNombreTipoCuenta() {
		return this.nombreTipoCuenta;
	}

	public void setNombreTipoCuenta(String nombreTipoCuenta) {
		this.nombreTipoCuenta = nombreTipoCuenta;
	}

	public List<CuentaCliente> getCuentaClientes() {
		return this.cuentaClientes;
	}

	public void setCuentaClientes(List<CuentaCliente> cuentaClientes) {
		this.cuentaClientes = cuentaClientes;
	}

	public CuentaCliente addCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().add(cuentaCliente);
		cuentaCliente.setTipoCuenta(this);

		return cuentaCliente;
	}

	public CuentaCliente removeCuentaCliente(CuentaCliente cuentaCliente) {
		getCuentaClientes().remove(cuentaCliente);
		cuentaCliente.setTipoCuenta(null);

		return cuentaCliente;
	}

}