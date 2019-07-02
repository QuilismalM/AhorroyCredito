package proyecto.controller.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import proyecto.controller.model.JSFUtil;
import proyecto.model.entities.EstadoCuenta;
import proyecto.model.manager.ManagerEstadoCuenta;

@Named
@SessionScoped
public class BeanEstadoCuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerEstadoCuenta managerEstadoCuenta;
	private List<EstadoCuenta> listaEstadoCuenta;
	private EstadoCuenta estado_cuenta;
	private boolean panelColapsado;
	private EstadoCuenta estado_cuentaSeleccionado;
	private int id_estado_cuenta;
	private String nombre_estadoc;
	
	@PostConstruct
	public void inicializar() {
		listaEstadoCuenta=managerEstadoCuenta.findAllEstadoCuentas();
		estado_cuenta= new EstadoCuenta();
		panelColapsado = true;
	}
	public void actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}



	public void actionListenerInsertarEstadoCuenta() {
		try {
			managerEstadoCuenta.insertarEstadoCuenta(estado_cuenta);;
			listaEstadoCuenta=managerEstadoCuenta.findAllEstadoCuentas();
			estado_cuenta=new EstadoCuenta();
		JSFUtil.crearMensajeInfo("Datos insertados");
		} catch (Exception e) {
		JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}


	public void actionListenerEliminarEstadoCuenta(int id_estado_cuenta) {
		managerEstadoCuenta.eliminarEstadoCuenta(id_estado_cuenta);
		listaEstadoCuenta=managerEstadoCuenta.findAllEstadoCuentas();
		JSFUtil.crearMensajeInfo("Estudiante Eliminado");
	}

	public void actionListenerSeleccionarEstadoCuenta(EstadoCuenta estado_cuenta) {
		estado_cuentaSeleccionado=estado_cuenta;
	}

	public void actionListenerActualizarEstadoCuenta() {
		try {
			managerEstadoCuenta.actualizarEstadoCuenta(estado_cuentaSeleccionado);
			listaEstadoCuenta=managerEstadoCuenta.findAllEstadoCuentas();
			JSFUtil.crearMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public List<EstadoCuenta> getListaEstadoCuenta() {
		return listaEstadoCuenta;
	}
	public void setListaEstadoCuenta(List<EstadoCuenta> listaEstadoCuenta) {
		this.listaEstadoCuenta = listaEstadoCuenta;
	}
	public EstadoCuenta getEstado_cuenta() {
		return estado_cuenta;
	}
	public void setEstado_cuenta(EstadoCuenta estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public EstadoCuenta getEstado_cuentaSeleccionado() {
		return estado_cuentaSeleccionado;
	}
	public void setEstado_cuentaSeleccionado(EstadoCuenta estado_cuentaSeleccionado) {
		this.estado_cuentaSeleccionado = estado_cuentaSeleccionado;
	}
	public int getId_estado_cuenta() {
		return id_estado_cuenta;
	}
	public void setId_estado_cuenta(int id_estado_cuenta) {
		this.id_estado_cuenta = id_estado_cuenta;
	}
	public String getNombre_estadoc() {
		return nombre_estadoc;
	}
	public void setNombre_estadoc(String nombre_estadoc) {
		this.nombre_estadoc = nombre_estadoc;
	}
	
	
	
	

}
