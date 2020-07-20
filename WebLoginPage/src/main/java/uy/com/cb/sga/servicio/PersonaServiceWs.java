package uy.com.cb.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import uy.com.cb.sga.domain.Persona;

@WebService
public interface PersonaServiceWs {
	
	@WebMethod
	public List<Persona> listarPersonas();
}
