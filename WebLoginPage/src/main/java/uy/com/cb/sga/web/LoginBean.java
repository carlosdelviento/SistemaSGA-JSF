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
	    FacesMessage message = null;
	    boolean loggedIn = false;

	    try {
		usuarioAutenticado = usuDao.findUsuarioByUsername(username);
		if (usuarioAutenticado != null) {
		    if (usuarioAutenticado.getPassword().equals(password)) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido", username);
			return "ingresar";
		    }
		    loggedIn = false;
		    message = new FacesMessage(FacesMessage.SEVERITY_WARN,"La clave no corresponde", password);
		    return null;
		}
		loggedIn = false;
		message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "El usuario no existe", "El usuario no existe");
		return null;
	    } catch (Exception e) {
		message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al ingresar al sistema", "No se puede ingresar en este momento");
	    }
	    FacesContext.getCurrentInstance().addMessage(null, message);
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