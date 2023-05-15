package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaAbm {
	private static AulaAbm instancia = null;// Patrón Singleton

	protected AulaAbm() {}

	public static AulaAbm getInstance() {
		if (instancia == null)
			instancia = new AulaAbm();
		return instancia;
	}
	public Aula traerAulaConEdificio(int id) {
		return AulaDao.getInstance().traerAulaConEdificio(id);
	}
}
