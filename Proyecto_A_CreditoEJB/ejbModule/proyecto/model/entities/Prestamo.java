package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prestamos database table.
 * 
 */
@Entity
@Table(name="prestamos")
@NamedQuery(name="Prestamo.findAll", query="SELECT p FROM Prestamo p")
public class Prestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESTAMOS_IDPRESTAMO_GENERATOR", sequenceName="SEQ_PRESTAMOS",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESTAMOS_IDPRESTAMO_GENERATOR")
	@Column(name="id_prestamo", unique=true, nullable=false)
	private Integer idPrestamo;

	@Column(name="cuota_mensual", precision=10, scale=2)
	private BigDecimal cuotaMensual;

	@Column(name="estado_prestamo", length=20)
	private String estadoPrestamo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicial")
	private Date fechaInicial;

	@Column(name="valor_deuda", precision=10, scale=2)
	private BigDecimal valorDeuda;

	@Column(name="valor_prestamo", precision=10, scale=2)
	private BigDecimal valorPrestamo;

	//bi-directional many-to-one association to Cuota
	@OneToMany(mappedBy="prestamo")
	private List<Cuota> cuotas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuarios", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-one association to SolicitudP
	@OneToMany(mappedBy="prestamo")
	private List<SolicitudP> solicitudPs;

	public Prestamo() {
	}

	public Integer getIdPrestamo() {
		return this.idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public BigDecimal getCuotaMensual() {
		return this.cuotaMensual;
	}

	public void setCuotaMensual(BigDecimal cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public String getEstadoPrestamo() {
		return this.estadoPrestamo;
	}

	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public BigDecimal getValorDeuda() {
		return this.valorDeuda;
	}

	public void setValorDeuda(BigDecimal valorDeuda) {
		this.valorDeuda = valorDeuda;
	}

	public BigDecimal getValorPrestamo() {
		return this.valorPrestamo;
	}

	public void setValorPrestamo(BigDecimal valorPrestamo) {
		this.valorPrestamo = valorPrestamo;
	}

	public List<Cuota> getCuotas() {
		return this.cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public Cuota addCuota(Cuota cuota) {
		getCuotas().add(cuota);
		cuota.setPrestamo(this);

		return cuota;
	}

	public Cuota removeCuota(Cuota cuota) {
		getCuotas().remove(cuota);
		cuota.setPrestamo(null);

		return cuota;
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
		solicitudP.setPrestamo(this);

		return solicitudP;
	}

	public SolicitudP removeSolicitudP(SolicitudP solicitudP) {
		getSolicitudPs().remove(solicitudP);
		solicitudP.setPrestamo(null);

		return solicitudP;
	}

}