package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@Table(name="transaccion")
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSACCION_IDTRANSACCION_GENERATOR", sequenceName="SEQ_TRANSACCION",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSACCION_IDTRANSACCION_GENERATOR")
	@Column(name="id_transaccion", unique=true, nullable=false)
	private Integer idTransaccion;

	@Column(name="cuenta_destino")
	private Integer cuentaDestino;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_transaccion", nullable=false)
	private Date fechaTransaccion;

	@Column(name="monto_transaccion", precision=10, scale=2)
	private BigDecimal montoTransaccion;

	//bi-directional many-to-one association to CuentaCliente
	@ManyToOne
	@JoinColumn(name="nro_cuenta_cl", nullable=false)
	private CuentaCliente cuentaCliente;

	//bi-directional many-to-one association to TipoTransaccion
	@ManyToOne
	@JoinColumn(name="id_tipo_transaccion", nullable=false)
	private TipoTransaccion tipoTransaccion;

	public Transaccion() {
	}

	public Integer getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Integer getCuentaDestino() {
		return this.cuentaDestino;
	}

	public void setCuentaDestino(Integer cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public Date getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public BigDecimal getMontoTransaccion() {
		return this.montoTransaccion;
	}

	public void setMontoTransaccion(BigDecimal montoTransaccion) {
		this.montoTransaccion = montoTransaccion;
	}

	public CuentaCliente getCuentaCliente() {
		return this.cuentaCliente;
	}

	public void setCuentaCliente(CuentaCliente cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}

	public TipoTransaccion getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

}