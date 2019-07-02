package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the solicitud_p database table.
 * 
 */
@Entity
@Table(name="solicitud_p")
@NamedQuery(name="SolicitudP.findAll", query="SELECT s FROM SolicitudP s")
public class SolicitudP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOLICITUD_P_IDSOLICITUD_GENERATOR", sequenceName="SEQ_SOLICITUD_P",allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOLICITUD_P_IDSOLICITUD_GENERATOR")
	@Column(name="id_solicitud", unique=true, nullable=false)
	private Integer idSolicitud;

	@Column(name="estado_solicitud", length=20)
	private String estadoSolicitud;

	@Column(name="valor_solicitudp", precision=10)
	private BigDecimal valorSolicitudp;

	//bi-directional many-to-one association to CuentaCliente
	@ManyToOne
	@JoinColumn(name="nro_cuenta_cl_cuenta_cliente", nullable=false)
	private CuentaCliente cuentaCliente;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="id_prestamo_prestamos", nullable=false)
	private Prestamo prestamo;

	public SolicitudP() {
	}

	public Integer getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getEstadoSolicitud() {
		return this.estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public BigDecimal getValorSolicitudp() {
		return this.valorSolicitudp;
	}

	public void setValorSolicitudp(BigDecimal valorSolicitudp) {
		this.valorSolicitudp = valorSolicitudp;
	}

	public CuentaCliente getCuentaCliente() {
		return this.cuentaCliente;
	}

	public void setCuentaCliente(CuentaCliente cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}