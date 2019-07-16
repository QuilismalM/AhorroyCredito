package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
	@SequenceGenerator(name="SOLICITUD_P_IDSOLICITUD_GENERATOR", sequenceName="SEQ_SOLICITUD_P")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOLICITUD_P_IDSOLICITUD_GENERATOR")
	@Column(name="id_solicitud", unique=true, nullable=false)
	private Integer idSolicitud;

	@Column(name="estado_solicitud", length=20)
	private String estadoSolicitud;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud", nullable=false)
	private Date fechaSolicitud;

	@Column(name="valor_solicitudp", precision=10)
	private BigDecimal valorSolicitudp;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="solicitudP")
	private List<Prestamo> prestamos;

	//bi-directional many-to-one association to CuentaCliente
	@ManyToOne
	@JoinColumn(name="nro_cuenta_cl_cuenta_cliente", nullable=false)
	private CuentaCliente cuentaCliente;

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

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public BigDecimal getValorSolicitudp() {
		return this.valorSolicitudp;
	}

	public void setValorSolicitudp(BigDecimal valorSolicitudp) {
		this.valorSolicitudp = valorSolicitudp;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setSolicitudP(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setSolicitudP(null);

		return prestamo;
	}

	public CuentaCliente getCuentaCliente() {
		return this.cuentaCliente;
	}

	public void setCuentaCliente(CuentaCliente cuentaCliente) {
		this.cuentaCliente = cuentaCliente;
	}

}