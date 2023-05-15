package dao;

import java.time.LocalDate;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;
import datos.Espacio;

public class EspacioDao {
	private static Session session;
	private Transaction tx;
	private static EspacioDao instancia = null; // Patrón Singleton

	protected EspacioDao() {}

	public static EspacioDao getInstance() {
		if (instancia == null)
			instancia = new EspacioDao();
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
	
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		Espacio obj = null;
		try {
			iniciaOperacion();
			String hQL ="from Espacio e inner join fetch e.aula a where a.id="+aula.getId()+" and e.fecha='"+fecha+"' and e.turno='"+turno+"'";
			obj = (Espacio)session.createQuery(hQL).uniqueResult();
		}finally {
			session.close();
		}
		return obj;
	}
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {	
		int id= 0;
		try {
			iniciaOperacion();
			Espacio obj = new Espacio(fecha, turno, aula, libre);
			id= Integer.parseInt(session.save(obj).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}

	
}
