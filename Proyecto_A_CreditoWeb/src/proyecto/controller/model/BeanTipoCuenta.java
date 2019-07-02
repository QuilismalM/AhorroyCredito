package proyecto.controller.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import proyecto.controller.model.JSFUtil;
import proyecto.model.entities.TipoCuenta;
import proyecto.model.manager.ManagerTipoCuenta;


@Named
@SessionScoped
public class BeanTipoCuenta implements Serializable {

	private static final long serialVersionUID = 1L;
    @EJB
	private ManagerTipoCuenta mangerTipoCuenta;
	private List<TipoCuenta> listaTipoCuenta;
	private TipoCuenta tipoCuenta;
	private TipoCuenta tipoCuentaSeleccionada;
	
	@PostConstruct
	public void inicializar() {
		listaTipoCuenta = mangerTipoCuenta.findAllTipoCuenta();
		tipoCuenta = new TipoCuenta();

	}
	public void actionListenerInsertarTipoCuenta() {
		try {
			mangerTipoCuenta.insertarTipoCuenta(tipoCuenta);
			listaTipoCuenta = mangerTipoCuenta.findAllTipoCuenta();
			tipoCuenta = new TipoCuenta();
			JSFUtil.crearMensajeInfo("Datos insertados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerEliminarTipoCuenta(int id_tipo_cuenta) {
		mangerTipoCuenta.eliminarTipoCuenta(id_tipo_cuenta);
		listaTipoCuenta = mangerTipoCuenta.findAllTipoCuenta();
		JSFUtil.crearMensajeInfo("Eliminado");

	}

	public void actionListenerSeleccionarTipoCuenta(TipoCuenta tipoCuenta) {
		tipoCuentaSeleccionada = tipoCuenta;
	}

	public void actionListenerActualizarTipoCuenta() {
		try {
			mangerTipoCuenta.actualizartipoCuenta(tipoCuentaSeleccionada);
			listaTipoCuenta = mangerTipoCuenta.findAllTipoCuenta();
			JSFUtil.crearMensajeInfo("Datos Actualizados");

		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}

	
	public List<TipoCuenta> getListaTipoCuenta() {
		return listaTipoCuenta;
	}
	public void setListaTipoCuenta(List<TipoCuenta> listaTipoCuenta) {
		this.listaTipoCuenta = listaTipoCuenta;
	}
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public TipoCuenta getTipoCuentaSeleccionada() {
		return tipoCuentaSeleccionada;
	}
	public void setTipoCuentaSeleccionada(TipoCuenta tipoCuentaSeleccionada) {
		this.tipoCuentaSeleccionada = tipoCuentaSeleccionada;
	}
	
	
	
	
}
