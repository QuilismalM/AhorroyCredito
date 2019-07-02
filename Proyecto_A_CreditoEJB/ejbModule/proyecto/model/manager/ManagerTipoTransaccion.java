package proyecto.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto.model.entities.TipoTransaccion;


/**
 * Session Bean implementation class ManagerTipoTransaccion
 */
@Stateless
@LocalBean
public class ManagerTipoTransaccion {
    @PersistenceContext
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerTipoTransaccion() {
        // TODO Auto-generated constructor stub
    }
    public TipoTransaccion findTipoTransaccionByIdTipoTransaccion(int id_tipo_transaccion) {
		return em.find(TipoTransaccion.class, id_tipo_transaccion);
	}
	public List<TipoTransaccion> findAllTipoTransacciones() {
		String consulta = "SELECT t FROM TipoTransaccion t";
		Query q = em.createQuery(consulta, TipoTransaccion.class);
		return q.getResultList();

	}
	public void insertarTipoTransaccion(TipoTransaccion tipoTransaccion) {
		em.persist(tipoTransaccion);

	}

	public void eliminarTipoTransaccion(int id_tipo_transaccion) {
		TipoTransaccion tipoTransaccion = findTipoTransaccionByIdTipoTransaccion(id_tipo_transaccion);
		if (tipoTransaccion != null)
			em.remove(tipoTransaccion);
	}

	public void actualizartipoTransaccion(TipoTransaccion tipoTransaccion) throws Exception {
		TipoTransaccion t = findTipoTransaccionByIdTipoTransaccion(tipoTransaccion.getIdTipoTransaccion());
		if (t == null)
			throw new Exception("No  existe tipo transaccion");
		t.setNombreTipoTransaccion(tipoTransaccion.getNombreTipoTransaccion());
		t.setTipoOperacion(tipoTransaccion.getTipoOperacion());

		em.merge(t);
	}
    
    
}
