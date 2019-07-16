package proyecto.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import poryecto.model.login.LoginDT;
import proyecto.model.entities.Usuario;

/**
 * Session Bean implementation class ManagerLogin
 */
@Stateless
@LocalBean
public class ManagerLogin {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerLogin() {
		// TODO Auto-generated constructor stub
	}

	public Usuario getUser(String username, String contrasena) {
		try {
			Usuario user = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.username =:name and u.contrasena =:password")
					.setParameter("name", username).setParameter("password", contrasena).getSingleResult();
			System.out.println("aqui el usuauri"+user);
			return user;
		} catch (Exception e) {
			System.out.println("errororororo");
			return null;
			
		}
	}
	
	public LoginDT accederSistema(String username,String contrasena) throws Exception{
		Usuario usuario = (Usuario) em
				.createQuery("SELECT u from Usuario u where u.username =:name and u.contrasena =:password")
				.setParameter("name", username).setParameter("password", contrasena).getSingleResult();
		
		
		if(usuario==null)
			throw new Exception("Error en usuario y/o clave.");
		
		if(!usuario.getContrasena().equals(contrasena))
			throw new Exception("Error en usuario y/o clave.");
		
		LoginDT loginDTO=new LoginDT();
		
		loginDTO.setUsername(usuario.getUsername());
		loginDTO.setId_rol(usuario.getRol().getIdRol());
		loginDTO.setContrasena(usuario.getContrasena());
		
		//dependiendo del tipo de usuario, configuramos la ruta de acceso a las pags web:
		if(usuario.getRol().getIdRol().equals(1))
			loginDTO.setRutaAcceso("indexRol.xhtml");
		else if(usuario.getRol().getIdRol().equals(2))
			loginDTO.setRutaAcceso("/supervisor/index.xhtml");
		return loginDTO;
	}
	
	

	
}
