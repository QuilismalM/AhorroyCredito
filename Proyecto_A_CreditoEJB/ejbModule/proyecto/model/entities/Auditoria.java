package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@Table(name="auditoria")
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUDITORIA_IDAUDITORIA_GENERATOR", sequenceName="SEQ_AUDITORIA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUDITORIA_IDAUDITORIA_GENERATOR")
	@Column(name="id_auditoria", unique=true, nullable=false)
	private Integer idAuditoria;

	@Column(length=100)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

	@Column(length=20)
	private String ip;

	@Column(name="nombre_evento", nullable=false, length=100)
	private String nombreEvento;

	@Column(name="usuario_evento", length=50)
	private String usuarioEvento;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;

	public Auditoria() {
	}

	public Integer getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(Integer idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNombreEvento() {
		return this.nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getUsuarioEvento() {
		return this.usuarioEvento;
	}

	public void setUsuarioEvento(String usuarioEvento) {
		this.usuarioEvento = usuarioEvento;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}