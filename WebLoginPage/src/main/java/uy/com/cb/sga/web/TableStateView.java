package uy.com.cb.sga.web;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import uy.com.cb.sga.domain.Persona;
import uy.com.cb.sga.servicio.PersonaService;

@Named("dtTableStateView")
@SessionScoped
public class TableStateView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Persona> personas;

	private List<Persona> filteredPersons;
	
	private Persona personaSeleccionada;

	@Inject
	private PersonaService personaService;

	@PostConstruct
	public void inicializar() {
		// Iniciamos las variables
		personas = personaService.listarPersonas();
	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}
		int filterInt = getInteger(filterText);

		Persona persona = (Persona) value;
		return persona.getIdPersona().toString().contains(filterText)
				|| persona.getNombre().toLowerCase().contains(filterText) 
				|| persona.getApellido().toLowerCase().contains(filterText) 
				|| persona.getEmail().toLowerCase().contains(filterText)
				|| persona.getTelefono().toLowerCase().contains(filterText)
				|| persona.getFecha().toString().contains(filterText)
				|| persona.getIdPersona() < filterInt;
	}

	private int getInteger(String string) {
		try {
			return Integer.valueOf(string);
		}
		catch (NumberFormatException ex) {
			return 0;
		}
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Persona> getFilteredPersons() {
		return filteredPersons;
	}

	public void setFilteredPersons(List<Persona> filteredPersons) {
		this.filteredPersons = filteredPersons;
	}
	
	public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	public void clearTableState() {
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
			showMessage(clientId);
		});
	}

	private void showMessage(String clientId) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
	}

}
