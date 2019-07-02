package proyecto.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPRESA_IDEMPRESA_GENERATOR", sequenceName="SEQ_EMPRESA",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPRESA_IDEMPRESA_GENERATOR")
	@Column(name="id_empresa", unique=true, nullable=false)
	private Integer idEmpresa;

	@Column(name="correo_emp", length=50)
	private String correoEmp;

	@Column(name="direccion_emp", length=50)
	private String direccionEmp;

	@Column(name="nombre_emp", length=50)
	private String nombreEmp;

	@Column(name="telefono_emp", length=15)
	private String telefonoEmp;

	//bi-directional many-to-one association to Auditoria
	@OneToMany(mappedBy="empresa")
	private List<Auditoria> auditorias;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="empresa")
	private List<Usuario> usuarios;

	public Empresa() {
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCorreoEmp() {
		return this.correoEmp;
	}

	public void setCorreoEmp(String correoEmp) {
		this.correoEmp = correoEmp;
	}

	public String getDireccionEmp() {
		return this.direccionEmp;
	}

	public void setDireccionEmp(String direccionEmp) {
		this.direccionEmp = direccionEmp;
	}

	public String getNombreEmp() {
		return this.nombreEmp;
	}

	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}

	public String getTelefonoEmp() {
		return this.telefonoEmp;
	}

	public void setTelefonoEmp(String telefonoEmp) {
		this.telefonoEmp = telefonoEmp;
	}

	public List<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
		getAuditorias().add(auditoria);
		auditoria.setEmpresa(this);

		return auditoria;
	}

	public Auditoria removeAuditoria(Auditoria auditoria) {
		getAuditorias().remove(auditoria);
		auditoria.setEmpresa(null);

		return auditoria;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEmpresa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEmpresa(null);

		return usuario;
	}

}