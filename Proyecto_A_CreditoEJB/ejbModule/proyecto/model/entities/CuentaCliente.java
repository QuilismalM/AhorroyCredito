package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cuenta_cliente database table.
 * 
 */
@Entity
@Table(name="cuenta_cliente")
@NamedQuery(name="CuentaCliente.findAll", query="SELECT c FROM CuentaCliente c")
public class CuentaCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUENTA_CLIENTE_NROCUENTACL_GENERATOR", sequenceName="SEQ_CUENTA_CLIENTE",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUENTA_CLIENTE_NROCUENTACL_GENERATOR")
	@Column(name="nro_cuenta_cl", unique=true, nullable=false)
	private Integer nroCuentaCl;

	@Column(name="interes_cuenta", precision=10, scale=2)
	private BigDecimal interesCuenta;

	@Column(name="saldo_cuenta", precision=10, scale=2)
	private BigDecimal saldoCuenta;

	//bi-directional many-to-one association to EstadoCuenta
	@ManyToOne
	@JoinColumn(name="id_estado_cuenta", nullable=false)
	private EstadoCuenta estadoCuenta;

	//bi-directional many-to-one association to TipoCuenta
	@ManyToOne
	@JoinColumn(name="id_tipo_cuenta", nullable=false)
	private TipoCuenta tipoCuenta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuarios", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-one association to SolicitudP
	@OneToMany(mappedBy="cuentaCliente")
	private List<SolicitudP> solicitudPs;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="cuentaCliente")
	private List<Transaccion> transaccions;

	public CuentaCliente() {
	}

	public Integer getNroCuentaCl() {
		return this.nroCuentaCl;
	}

	public void setNroCuentaCl(Integer nroCuentaCl) {
		this.nroCuentaCl = nroCuentaCl;
	}

	public BigDecimal getInteresCuenta() {
		return this.interesCuenta;
	}

	public void setInteresCuenta(BigDecimal interesCuenta) {
		this.interesCuenta = interesCuenta;
	}

	public BigDecimal getSaldoCuenta() {
		return this.saldoCuenta;
	}

	public void setSaldoCuenta(BigDecimal saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public EstadoCuenta getEstadoCuenta() {
		return this.estadoCuenta;
	}

	public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public TipoCuenta getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<SolicitudP> getSolicitudPs() {
		return this.solicitudPs;
	}

	public void setSolicitudPs(List<SolicitudP> solicitudPs) {
		this.solicitudPs = solicitudPs;
	}

	public SolicitudP addSolicitudP(SolicitudP solicitudP) {
		getSolicitudPs().add(solicitudP);
		solicitudP.setCuentaCliente(this);

		return solicitudP;
	}

	public SolicitudP removeSolicitudP(SolicitudP solicitudP) {
		getSolicitudPs().remove(solicitudP);
		solicitudP.setCuentaCliente(null);

		return solicitudP;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setCuentaCliente(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setCuentaCliente(null);

		return transaccion;
	}

}