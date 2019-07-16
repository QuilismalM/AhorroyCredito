package proyecto.controller.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import poryecto.model.login.LoginDT;
import proyecto.model.entities.Usuario;
import proyecto.model.manager.ManagerLogin;

@Named
@SessionScoped
public class BeanLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String username;
    private String contrasena;
    private int id_rol;
    private boolean acceso;

	@EJB
	private ManagerLogin managerLogin;
	private Usuario usuario;
	private LoginDT loginDT;
	@PostConstruct
	public void inicializar() {
		loginDT=new LoginDT();
	}

	public String send() {
		usuario = managerLogin.getUser(username, contrasena);
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!"));
			return null;
		} else {
			return "indexRol.xhtml";
		}
	}
   
	public String accederSistema(){
		acceso=false;
		try {
			loginDT=managerLogin.accederSistema(username, contrasena);
			//verificamos el acceso del usuario:
			id_rol=loginDT.getId_rol();
			//redireccion dependiendo del tipo de usuario:
			return loginDT.getRutaAcceso()+"?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.crearMensajeError(e.getMessage());
		}
		return "";
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public boolean isAcceso() {
		return acceso;
	}

	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}

	public LoginDT getLoginDT() {
		return loginDT;
	}

	public void setLoginDT(LoginDT loginDT) {
		this.loginDT = loginDT;
	}
	

}
