package negocio;

import dao.VacunaDao;
import datos.Vacuna;

public class VacunaAbm {
	private static VacunaAbm instancia = null;// Patrón Singleton

	protected VacunaAbm() {}

	public static VacunaAbm getInstance() {
		if (instancia == null)
			instancia = new VacunaAbm();
		return instancia;
	}
	
	public Vacuna traerVacuna(int codigo) {
		return VacunaDao.getInstance().traerVacuna(codigo);
	}

}
