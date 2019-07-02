package proyecto.controller.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto.controller.model.JSFUtil;
import proyecto.model.entities.TipoTransaccion;
import proyecto.model.manager.ManagerTipoTransaccion;



@Named
@SessionScoped
public class BeanTipoTransaccion implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerTipoTransaccion mangerTipoTransaccion;
	private List<TipoTransaccion> listaTipoTransaccion;
	private TipoTransaccion tipoTransaccion;
	private TipoTransaccion tipoTrasaccionSeleccionado;
	
	@PostConstruct
	public void inicializar() {
		listaTipoTransaccion = mangerTipoTransaccion.findAllTipoTransacciones();
		tipoTransaccion = new TipoTransaccion();

	}
	public void actionListenerInsertarTipoTransaccion() {
		try {
			mangerTipoTransaccion.insertarTipoTransaccion(tipoTransaccion);
			listaTipoTransaccion = mangerTipoTransaccion.findAllTipoTransacciones();
			tipoTransaccion = new TipoTransaccion();
			JSFUtil.crearMensajeInfo("Datos insertados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerEliminarTipoTransaccion(int id_tipo_transaccion) {
		mangerTipoTransaccion.eliminarTipoTransaccion(id_tipo_transaccion);
		listaTipoTransaccion = mangerTipoTransaccion.findAllTipoTransacciones();
		JSFUtil.crearMensajeInfo("Eliminado");

	}

	public void actionListenerSeleccionarTipoTransaccion(TipoTransaccion tipoTransaccion) {
		tipoTrasaccionSeleccionado = tipoTransaccion;
	}

	public void actionListenerActualizarTipoTransaccion() {
		try {
			mangerTipoTransaccion.actualizartipoTransaccion(tipoTrasaccionSeleccionado);
			listaTipoTransaccion = mangerTipoTransaccion.findAllTipoTransacciones();
			JSFUtil.crearMensajeInfo("Datos Actualizados");

		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	
	public List<TipoTransaccion> getListaTipoTransaccion() {
		return listaTipoTransaccion;
	}
	public void setListaTipoTransaccion(List<TipoTransaccion> listaTipoTransaccion) {
		this.listaTipoTransaccion = listaTipoTransaccion;
	}
	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public TipoTransaccion getTipoTrasaccionSeleccionado() {
		return tipoTrasaccionSeleccionado;
	}
	public void setTipoTrasaccionSeleccionado(TipoTransaccion tipoTrasaccionSeleccionado) {
		this.tipoTrasaccionSeleccionado = tipoTrasaccionSeleccionado;
	}
	
	

}
