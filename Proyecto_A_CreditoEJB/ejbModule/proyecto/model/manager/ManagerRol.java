package proyecto.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto.model.entities.Rol;

/**
 * Session Bean implementation class ManagerRol
 */
@Stateless
@LocalBean
public class ManagerRol {
	@PersistenceContext
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerRol() {
        // TODO Auto-generated constructor stub
    }
    public Rol findRolByIdRol(int id_rol) {
		return em.find(Rol.class, id_rol);
	}
	public List<Rol> findAllRol() {
		String consulta = "SELECT t FROM Rol t";
		Query q = em.createQuery(consulta, Rol.class);
		return q.getResultList();

	}
	public void insertarRol(Rol rol) {
		em.persist(rol);

	}

	public void eliminarRol(int id_rol) {
		Rol rol = findRolByIdRol(id_rol);
		if (rol != null)
			em.remove(rol);
	}

	public void actualizartipoRol(Rol rol) throws Exception {
		Rol t = findRolByIdRol(rol.getIdRol());
		if (t == null)
			throw new Exception("No  existe rol");
		t.setTipoRol(rol.getTipoRol());
	em.merge(t);
	}
    
    

}
