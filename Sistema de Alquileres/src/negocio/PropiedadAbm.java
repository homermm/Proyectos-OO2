package negocio;

import java.util.List;

import dao.PropiedadDao;
import datos.Propiedad;

public class PropiedadAbm {
	private static PropiedadAbm instancia = null;// Patrón Singleton

	protected PropiedadAbm() {
	}

	public static PropiedadAbm getInstance() {
		if (instancia == null)
			instancia = new PropiedadAbm();
		return instancia;
	}
	public List<Propiedad> traerPropiedad(){
		return PropiedadDao.getInstance().traerPropiedad();
	}
	public List<Propiedad> traerPropiedad(boolean tieneAscensor){
		return PropiedadDao.getInstance().traerPropiedad(tieneAscensor);
	}
	
}
