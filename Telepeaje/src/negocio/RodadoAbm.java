package negocio;

import dao.RodadoDao;
import datos.Rodado;

public class RodadoAbm {
	private static RodadoAbm instancia = null;// Patrón Singleton

	protected RodadoAbm() {
	}

	public static RodadoAbm getInstance() {
		if (instancia == null)
			instancia = new RodadoAbm();
		return instancia;
	}
	public Rodado traerRodado(String dominio) {
		return RodadoDao.getInstance().traerRodado(dominio);
	}
}
