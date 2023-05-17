package negocio;

import java.time.LocalDate;

import dao.AlquilerDao;
import dao.PropiedadDao;
import datos.Alquiler;

public class AlquilerAbm {
	private static AlquilerAbm instancia = null;// Patrón Singleton

	protected AlquilerAbm() {
	}

	public static AlquilerAbm getInstance() {
		if (instancia == null)
			instancia = new AlquilerAbm();
		return instancia;
	}

	public Alquiler traerAlquiler(int id) {
		return AlquilerDao.getInstance().traerAlquiler(id);
	}
	
//	+calcularPrecioFinal(Alquiler alquiler): double
	public double calcularPrecioFinal(Alquiler alquiler) {
		return AlquilerDao.getInstance().calcularPrecioFinal(alquiler);
	}
	
	public double calcularPrecioFinal(LocalDate desde, LocalDate hasta) {
		return AlquilerDao.getInstance().calcularPrecioFinal(desde, hasta);
	}

}
