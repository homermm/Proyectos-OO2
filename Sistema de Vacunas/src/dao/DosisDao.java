package dao;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Vacuna;

public class DosisDao {
	private static Session session;
	private Transaction tx;
	private static DosisDao instancia = null; // Patrón Singleton

	protected DosisDao() {
	}

	public static DosisDao getInstance() {
		if (instancia == null)
			instancia = new DosisDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	// traerDosis(Vacuna vacuna): List<Dosis>
	public List<Dosis> traerDosis(Vacuna vacuna) {
		List<Dosis> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Dosis d inner join fetch d.vacuna v where v.idVacuna="+vacuna.getIdVacuna();
			lista = session.createQuery(hQL).list();
			for (Dosis d: lista) {
				Hibernate.initialize(d.getPersona());
				Hibernate.initialize(d.getVacuna());
			}
		} finally {
			session.close();
		}
		return lista;
	}
	//+ traerDosis(LocalTime horaDesde, LocalTime horaHasta): List<Dosis>
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta){
		List<Dosis> lista = null;
		try {
			iniciaOperacion();
			String hQL="from Dosis d where d.hora between '"+horaDesde+"' and '"+horaHasta+"'";
			lista = session.createQuery(hQL).list();
			for(Dosis d: lista) {				
				Hibernate.initialize(d.getVacuna());
				Hibernate.initialize(d.getPersona());
			}
		}finally {
			session.close();
		}
		return lista;
	}
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidades){
		List<Dosis> lista = new ArrayList<Dosis>();
		for (Dosis d: traerDosis(horaDesde,horaHasta)){
			if (d.getPersona().isTieneComorbilidad()==tieneComorbilidades) {
				lista.add(d);
			}
		}
		return lista;	
	}

}
