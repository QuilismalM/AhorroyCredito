package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_transaccion database table.
 * 
 */
@Entity
@Table(name="tipo_transaccion")
@NamedQuery(name="TipoTransaccion.findAll", query="SELECT t FROM TipoTransaccion t")
public class TipoTransaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_TRANSACCION_IDTIPOTRANSACCION_GENERATOR", sequenceName="SEQ_TIPO_TRANSACCION",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_TRANSACCION_IDTIPOTRANSACCION_GENERATOR")
	@Column(name="id_tipo_transaccion", unique=true, nullable=false)
	private Integer idTipoTransaccion;

	@Column(name="nombre_tipo_transaccion", nullable=false, length=100)
	private String nombreTipoTransaccion;

	@Column(name="tipo_operacion", nullable=false, length=10)
	private String tipoOperacion;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="tipoTransaccion")
	private List<Transaccion> transaccions;

	public TipoTransaccion() {
	}

	public Integer getIdTipoTransaccion() {
		return this.idTipoTransaccion;
	}

	public void setIdTipoTransaccion(Integer idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}

	public String getNombreTipoTransaccion() {
		return this.nombreTipoTransaccion;
	}

	public void setNombreTipoTransaccion(String nombreTipoTransaccion) {
		this.nombreTipoTransaccion = nombreTipoTransaccion;
	}

	public String getTipoOperacion() {
		return this.tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setTipoTransaccion(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setTipoTransaccion(null);

		return transaccion;
	}

}