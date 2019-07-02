package proyecto.controller.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import proyecto.controller.model.JSFUtil;
import proyecto.model.entities.Rol;
import proyecto.model.manager.ManagerRol;



@Named
@SessionScoped
public class BeanRol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerRol mangerRol;
	private List<Rol> listaRol;
	private Rol rol;
	private Rol rolSeleccionada;
	
	@PostConstruct
	public void inicializar() {
		listaRol = mangerRol.findAllRol();
	rol = new Rol();

	}
	public void actionListenerInsertarRol() {
		try {
			mangerRol.insertarRol(rol);
			listaRol= mangerRol.findAllRol();
			rol = new Rol();
			JSFUtil.crearMensajeInfo("Datos insertados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerEliminarRol(int id_rol) {
		mangerRol.eliminarRol(id_rol);
		listaRol = mangerRol.findAllRol();
		JSFUtil.crearMensajeInfo("Eliminado");

	}

	public void actionListenerSeleccionarRol(Rol rol) {
		rolSeleccionada= rol;
	}

	public void actionListenerActualizarRol() {
		try {
			mangerRol.actualizartipoRol(rolSeleccionada);
			listaRol = mangerRol.findAllRol();
			JSFUtil.crearMensajeInfo("Datos Actualizados");

		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}
	public List<Rol> getListaRol() {
		return listaRol;
	}
	public void setListaRol(List<Rol> listaRol) {
		this.listaRol = listaRol;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Rol getRolSeleccionada() {
		return rolSeleccionada;
	}
	public void setRolSeleccionada(Rol rolSeleccionada) {
		this.rolSeleccionada = rolSeleccionada;
	}
	

}
