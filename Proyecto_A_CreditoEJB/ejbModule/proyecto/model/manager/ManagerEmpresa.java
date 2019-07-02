package proyecto.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto.model.entities.Empresa;

/**
 * Session Bean implementation class ManagerEmpresa
 */
@Stateless
@LocalBean
public class ManagerEmpresa {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerEmpresa() {
		// TODO Auto-generated constructor stub
	}
	public Empresa findEmpresabyIdEmpresa(int id_empresa) {
		return em.find(Empresa.class, id_empresa);
	}

	public List<Empresa> findAllEmpresa() {
		String consulta = "SELECT e FROM Empresa e";
		Query q = em.createQuery(consulta, Empresa.class);
		return q.getResultList();
	}

	public void insertarEmpresa(Empresa empresa){
     em.persist(empresa);	
	}
	public void eliminarEmpresa(int id_empresa) {
		Empresa empresa = findEmpresabyIdEmpresa(id_empresa);
		if (empresa!=null)
		em.remove(empresa);
	}
	public void actualizarEmpresa(Empresa empresa) throws Exception {
		Empresa e= findEmpresabyIdEmpresa(empresa.getIdEmpresa());
		if (e == null) 
			throw new Exception("No Existe la empresa");
		e.setNombreEmp(empresa.getNombreEmp());
		e.setCorreoEmp(empresa.getCorreoEmp());
		e.setDireccionEmp(empresa.getDireccionEmp());
		e.setTelefonoEmp(empresa.getTelefonoEmp());
		em.merge(e);

	}
}
