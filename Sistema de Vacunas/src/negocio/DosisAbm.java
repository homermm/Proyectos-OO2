package negocio;

import java.time.LocalTime;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Vacuna;

public class DosisAbm {
	private static DosisAbm instancia = null;// Patrón Singleton

	protected DosisAbm() {}

	public static DosisAbm getInstance() {
		if (instancia == null)
			instancia = new DosisAbm();
		return instancia;
	}
	public List<Dosis> traerDosis(Vacuna vacuna){
		return DosisDao.getInstance().traerDosis(vacuna);
	}
	
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta){
		return DosisDao.getInstance().traerDosis(horaDesde, horaHasta);
	}
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidades){
		return DosisDao.getInstance().traerDosis(horaDesde, horaHasta, tieneComorbilidades);
	}
}
