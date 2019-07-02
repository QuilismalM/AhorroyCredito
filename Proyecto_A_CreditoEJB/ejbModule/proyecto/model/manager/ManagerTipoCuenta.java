package proyecto.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import proyecto.model.entities.TipoCuenta;



/**
 * Session Bean implementation class ManagerTipoCuenta
 */
@Stateless
@LocalBean
public class ManagerTipoCuenta {
    @PersistenceContext
    private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerTipoCuenta() {
        // TODO Auto-generated constructor stub
    }
    public TipoCuenta findTipoCuentaByIdTipoCuenta(int id_tipo_cuenta) {
		return em.find(TipoCuenta.class, id_tipo_cuenta);
	}
	public List<TipoCuenta> findAllTipoCuenta() {
		String consulta = "SELECT t FROM TipoCuenta t";
		Query q = em.createQuery(consulta, TipoCuenta.class);
		return q.getResultList();

	}
	public void insertarTipoCuenta(TipoCuenta tipoCuenta) {
		em.persist(tipoCuenta);

	}

	public void eliminarTipoCuenta(int id_tipo_cuenta) {
		TipoCuenta tipocuenta = findTipoCuentaByIdTipoCuenta(id_tipo_cuenta);
		if (tipocuenta != null)
			em.remove(tipocuenta);
	}

	public void actualizartipoCuenta(TipoCuenta tipoCuenta) throws Exception {
		TipoCuenta t = findTipoCuentaByIdTipoCuenta(tipoCuenta.getIdTipoCuenta());
		if (t == null)
			throw new Exception("No  existe tipo Cuenta");
		t.setNombreTipoCuenta(tipoCuenta.getNombreTipoCuenta());
		em.merge(t);
	}

}
