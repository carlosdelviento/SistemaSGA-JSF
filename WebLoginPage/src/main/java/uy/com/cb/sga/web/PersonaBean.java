package uy.com.cb.sga.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import uy.com.cb.sga.domain.Persona;
import uy.com.cb.sga.servicio.PersonaService;

@Named("personaBean")
@SessionScoped
public class PersonaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger log = LogManager.getRootLogger();

	@Inject
	private PersonaService personaService;

	private Persona personaSeleccionada;

	List<Persona> personas;

	private MenuModel model;

	public PersonaBean() {
		log.debug("Iniciando el objeto PersonaBean");
	}

	@PostConstruct
	public void inicializar() {
		// Iniciamos las variables
		this.personas = personaService.listarPersonas();
		log.debug("personas recuperadas en ManagedBean:" + this.personas);
		this.personaSeleccionada = new Persona();

		model = new DefaultMenuModel();
		//First submenu
		DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
				.label("Dynamic Submenu")
				.build();

		DefaultMenuItem item = DefaultMenuItem.builder()
				.value("External")
				.url("http://www.primefaces.org")
				.icon("pi pi-home")
				.build();
		firstSubmenu.getElements().add(item);

		model.getElements().add(firstSubmenu);

		//Second submenu
		DefaultSubMenu secondSubmenu = DefaultSubMenu.builder()
				.label("Dynamic Actions")
				.build();

		item = DefaultMenuItem.builder()
				.value("Guardar")
				.icon("pi pi-save")
				.command("#{personaBean.agregarPersona()}")
				.update("messages")
				.build();
		secondSubmenu.getElements().add(item);

		item = DefaultMenuItem.builder()
				.value("Borrar")
				.icon("pi pi-times")
				.command("#{personaBean.eliminarPersona()}")
				.ajax(false)
				.build();
		secondSubmenu.getElements().add(item);
	}

	public MenuModel getModel() {
		return model;
	}


	@SuppressWarnings("rawtypes")
	public void editListener(RowEditEvent event) {
		Persona persona = (Persona) event.getObject();
		personaService.modificarPersona(persona);
	}

	public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
		addMessage("Hecho", "Dato actualizado");
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public void agregarPersona() {
		this.personaService.registrarPersona(personaSeleccionada);
		this.personas.add(personaSeleccionada);
		this.personaSeleccionada = null;
		addMessage("Hecho", "Persona agregada con éxito");
	}

	public void eliminarPersona() {
		this.personaService.eliminarPersona(personaSeleccionada);
		this.personas.remove(this.personaSeleccionada);
		this.personaSeleccionada = null;
		addMessage("Hecho", "Persona eliminada");
	}

	public void reiniciarPersonaSeleccionada() {
		this.personaSeleccionada = new Persona();
		addMessage("Hecho", "Dato actualizado");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}