package proyecto.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto.model.entities.EstadoCuenta;

/**
 * Session Bean implementation class ManagerEstadoCuenta
 */
@Stateless
@LocalBean
public class ManagerEstadoCuenta {
  @PersistenceContext
  private EntityManager em;
  
    /**
     * Default constructor. 
     */
    public ManagerEstadoCuenta() {
        // TODO Auto-generated constructor stub
    }
    public List<EstadoCuenta> findAllEstadoCuentas(){
    	String consulta="select e from EstadoCuenta e";
    	Query q= em.createQuery(consulta, EstadoCuenta.class);
    	return q.getResultList();
    }
    public EstadoCuenta findEstadoCuentaByidEstadoCuenta(int id_estado_cuenta) {
    	return em.find(EstadoCuenta.class, id_estado_cuenta);
    }
    public void insertarEstadoCuenta(EstadoCuenta estado_cuenta){	
    	em.persist(estado_cuenta);
    	
    }
    public void eliminarEstadoCuenta(int id_estado_cuenta) {
    	EstadoCuenta estado_cuenta = findEstadoCuentaByidEstadoCuenta(id_estado_cuenta);
    	if(estado_cuenta!=null)
    		em.remove(estado_cuenta);
    }
    
    public void actualizarEstadoCuenta(EstadoCuenta estado_cuenta) throws Exception {
    	EstadoCuenta e = findEstadoCuentaByidEstadoCuenta(estado_cuenta.getIdEstadoCuenta());
    	if(e==null)
    		throw new Exception("No existe ");
    	e.setNombreEstadoc(estado_cuenta.getNombreEstadoc());
    	em.merge(e);
    	
    }

}
