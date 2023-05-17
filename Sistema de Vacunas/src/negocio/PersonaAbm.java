package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaAbm {
	private static PersonaAbm instancia = null;// Patrón Singleton

	protected PersonaAbm() {}

	public static PersonaAbm getInstance() {
		if (instancia == null)
			instancia = new PersonaAbm();
		return instancia;
	}
	
	public List<Persona> traerPersona(int edadDesde, int edadHasta){
		return PersonaDao.getInstance().traerPersona(edadDesde, edadHasta);
	}
	
}
