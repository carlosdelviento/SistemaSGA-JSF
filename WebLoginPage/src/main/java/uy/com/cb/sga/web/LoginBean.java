package uy.com.cb.sga.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import uy.com.cb.sga.datos.UsuarioDao;
import uy.com.cb.sga.domain.Usuario;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;

	private String password;

	@EJB
	private UsuarioDao usuDao;

	private Usuario usuarioAutenticado;

	public Usuario getUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBean(){
	}
	
	public String autenticar() {
        boolean loggedIn = false;

		usuarioAutenticado = usuDao.findUsuarioByUsername(username);

		if (usuarioAutenticado != null) {
			if (usuarioAutenticado.getPassword().equals(password)) {
				loggedIn = true;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido", username));
				return "ingresar";
			}
			loggedIn = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La clave no corresponde", password));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
			return null;
		}
		loggedIn = false;
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "El usuario no existe", "El usuario no existe"));
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		return null;
		
	}
	
	public String logout(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		return "logout";
	}
}