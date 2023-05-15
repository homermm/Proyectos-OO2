package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioAbm {
	private static EspacioAbm instancia = null;// Patrón Singleton

	protected EspacioAbm() {}

	public static EspacioAbm getInstance() {
		if (instancia == null)
			instancia = new EspacioAbm();
		return instancia;
	}
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		return EspacioDao.getInstance().traer(fecha, turno, aula);
	}
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception{
		if (EspacioDao.getInstance().traer(fecha,turno,aula)!=null) throw new Exception("Ya existe en la BD");
		return EspacioDao.getInstance().agregar(fecha, turno, aula, libre);
	}
	
}
