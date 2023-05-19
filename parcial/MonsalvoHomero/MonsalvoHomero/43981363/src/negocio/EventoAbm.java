package negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.EventoDao;
import datos.Dispositivo;
import datos.Evento;

public class EventoAbm {
	private static EventoAbm instancia = null;// Patrón Singleton

	protected EventoAbm() {
	}

	public static EventoAbm getInstance() {
		if (instancia == null)
			instancia = new EventoAbm();
		return instancia;
	}

	// CU3
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		return EventoDao.getInstance().traer(dispositivo, fechaHora);
	}

	// CU4
	public boolean agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception {
		if (EventoDao.getInstance().traer(dispositivo, fechaHora) != null)
			throw new Exception("Ya existe en la DB");
		return EventoDao.getInstance().agregar(descripcion, dispositivo, fechaHora);
	}

	// CU5
	public List<Evento> traer() {
		return EventoDao.getInstance().traer();
	}

	// CU6
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta) {
		return EventoDao.getInstance().traer(fechaHoraDesde, fechaHoraHasta);
	}
//	//CU7
	public List<Evento> traer(LocalDateTime fechaHoraDesde,LocalDateTime fechaHoraHasta,Dispositivo dispositivo){
		List<Evento> obj = new ArrayList<Evento>();
		for (Evento e: traer()) {
			if (e.getDispositivo().equals(dispositivo)) {
				obj.add(e);
			}
		}
		return obj;
	}

}
