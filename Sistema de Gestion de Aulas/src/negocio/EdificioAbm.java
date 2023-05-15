package negocio;

import java.time.LocalDate;

import dao.EdificioDao;
import datos.Aula;
import datos.Edificio;

public class EdificioAbm {
	private static EdificioAbm instancia = null;// Patrón Singleton

	protected EdificioAbm() {}

	public static EdificioAbm getInstance() {
		if (instancia == null)
			instancia = new EdificioAbm();
		return instancia;
	}
	
	public Edificio traerEdificioConAulas(int id) {
		return EdificioDao.getInstance().traerEdificioConAulas(id);
	}


}
