package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cuotas database table.
 * 
 */
@Entity
@Table(name="cuotas")
@NamedQuery(name="Cuota.findAll", query="SELECT c FROM Cuota c")
public class Cuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUOTAS_IDCUOTA_GENERATOR", sequenceName="SEQ_CUOTAS",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUOTAS_IDCUOTA_GENERATOR")
	@Column(name="id_cuota", unique=true, nullable=false)
	private Integer idCuota;

	@Column(name="estado_cuota", length=20)
	private String estadoCuota;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	@Column(name="interes_cuota", precision=10, scale=2)
	private BigDecimal interesCuota;

	@Column(precision=10, scale=2)
	private BigDecimal multa;

	@Column(name="valor_cuota", precision=10, scale=2)
	private BigDecimal valorCuota;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="id_prestamo", nullable=false)
	private Prestamo prestamo;

	public Cuota() {
	}

	public Integer getIdCuota() {
		return this.idCuota;
	}

	public void setIdCuota(Integer idCuota) {
		this.idCuota = idCuota;
	}

	public String getEstadoCuota() {
		return this.estadoCuota;
	}

	public void setEstadoCuota(String estadoCuota) {
		this.estadoCuota = estadoCuota;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getInteresCuota() {
		return this.interesCuota;
	}

	public void setInteresCuota(BigDecimal interesCuota) {
		this.interesCuota = interesCuota;
	}

	public BigDecimal getMulta() {
		return this.multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public BigDecimal getValorCuota() {
		return this.valorCuota;
	}

	public void setValorCuota(BigDecimal valorCuota) {
		this.valorCuota = valorCuota;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

}