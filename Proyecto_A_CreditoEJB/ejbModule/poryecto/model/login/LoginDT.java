package poryecto.model.login;



public class LoginDT {
	private String username;
	private int id_usuarios;
	private String contrasena ;
	private int id_rol;
	private String rutaAcceso;
	
	
	
	public int getId_usuarios() {
		return id_usuarios;
	}
	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
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

	
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getRutaAcceso() {
		return rutaAcceso;
	}
	public void setRutaAcceso(String rutaAcceso) {
		this.rutaAcceso = rutaAcceso;
	}
	
	
	
	
}
