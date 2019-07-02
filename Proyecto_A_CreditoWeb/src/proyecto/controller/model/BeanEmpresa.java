package proyecto.controller.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import proyecto.model.entities.Empresa;
import proyecto.model.manager.ManagerEmpresa;

@Named
@SessionScoped
public class BeanEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	@EJB
	private ManagerEmpresa managerEmpresa;
	private List<Empresa> listaEmpresa;
	private Empresa empresa;
	private boolean panelColapsado;
	private Empresa empresaSelecionada;

	@PostConstruct
	public void inicializar  () {
		listaEmpresa=managerEmpresa.findAllEmpresa();
		empresa= new Empresa();
		panelColapsado=true;
	}
	public void actionListenerColapsarPanel() {
		panelColapsado=!panelColapsado;
	}
	public void actionListenerInsertarEmpresa() {
		try {
			managerEmpresa.insertarEmpresa(empresa);
			listaEmpresa = managerEmpresa.findAllEmpresa();
			empresa = new Empresa();
			JSFUtil.crearMensajeInfo("Datos Insertados");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerEliminarEmpresa(int id_empresa) {
	managerEmpresa.eliminarEmpresa(id_empresa);
	listaEmpresa = managerEmpresa.findAllEmpresa();
	JSFUtil.crearMensajeInfo("Datos Eliminados");
	}
	public void actionListenerSeleccionarEmpresa(Empresa empresa) {
		empresaSelecionada = empresa;
	}
	public void actionListenerActualizarEmpresa() {
		try {
			managerEmpresa.actualizarEmpresa(empresaSelecionada);
			listaEmpresa = managerEmpresa.findAllEmpresa();
			JSFUtil.crearMensajeInfo("Datos Actualizados");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public String actionRedireccionEmpresa() {
		return "indexEmpresa";
	}
	
	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}
	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public boolean isPanelColapsado() {
		return panelColapsado;
	}
	public void setPanelColapsado(boolean panelColapsado) {
		this.panelColapsado = panelColapsado;
	}
	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}
	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}
	
	
	
}
