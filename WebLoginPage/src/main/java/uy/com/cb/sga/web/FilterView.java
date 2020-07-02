package uy.com.cb.sga.web;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import uy.com.cb.sga.domain.Persona;
import uy.com.cb.sga.servicio.PersonaService;

@Named("dtFilterView")
@ViewScoped
public class FilterView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Persona> personas;

	private List<Persona> filteredPersons1;

	@Inject
	private PersonaService personaService;

	@PostConstruct
	public void inicializar() {
		// Iniciamos las variables
		personaService.listarPersonas();
	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}
		int filterInt = getInteger(filterText);

		Persona persona = (Persona) value;
		return persona.getIdPersona() < filterInt
				|| persona.getNombre().toLowerCase().contains(filterText) 
				|| persona.getApellido().toLowerCase().contains(filterText) 
				|| persona.getEmail().toLowerCase().contains(filterText)
				|| persona.getTelefono().toLowerCase().contains(filterText)
				|| persona.getFecha().toString().contains(filterText);
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

	public List<Persona> getFilteredPersons1() {
		return filteredPersons1;
	}

	public void setFilteredPersons1(List<Persona> filteredPersons1) {
		this.filteredPersons1 = filteredPersons1;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}


}
