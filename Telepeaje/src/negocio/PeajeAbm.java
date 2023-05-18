package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PeajeDao;
import datos.Manual;
import datos.Rodado;
import datos.Telepeaje;

public class PeajeAbm {
	private static PeajeAbm instancia = null;// Patrón Singleton

	protected PeajeAbm() {
	}

	public static PeajeAbm getInstance() {
		if (instancia == null)
			instancia = new PeajeAbm();
		return instancia;
	}
	//1) + traerManual() : List<Manual>

	public List<Manual> traerManual(){
		return PeajeDao.getInstance().traerManual();
	}
	public List<Telepeaje> traerTelepeaje(){
		return PeajeDao.getInstance().traerTelepeaje();
	}
	public List<Manual> traerManual(LocalDate fecha){
		return PeajeDao.getInstance().traerManual(fecha);
	}
	public double cerrarCaja(LocalDate fecha) {
		return PeajeDao.getInstance().cerrarCaja(fecha);
	}
	public List<Telepeaje> traerTelepeaje(Rodado rodado){
		return PeajeDao.getInstance().traerTelepeaje(rodado);
	}
}
