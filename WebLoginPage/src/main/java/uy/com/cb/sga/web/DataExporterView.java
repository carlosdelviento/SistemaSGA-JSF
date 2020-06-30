package uy.com.cb.sga.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import uy.com.cb.sga.domain.Persona;
import uy.com.cb.sga.servicio.PersonaService;

@Named
@SessionScoped
public class DataExporterView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Persona> personas;
     
    private Exporter<DataTable> textExporter;
         
    @Inject
    private PersonaService personaService;
     
    @PostConstruct
    public void init() {
    	this.personas = personaService.listarPersonas();
        textExporter = new TextExporter();
    }
 
    public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Exporter<DataTable> getTextExporter() {
        return textExporter;
    }
 
    public void setTextExporter(Exporter<DataTable> textExporter) {
        this.textExporter = textExporter;
    }
     
     
}