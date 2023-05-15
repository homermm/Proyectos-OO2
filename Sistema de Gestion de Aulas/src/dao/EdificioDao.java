package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Edificio;

public class EdificioDao {
	private static Session session;
	private Transaction tx;
	private static EdificioDao instancia = null; // Patrón Singleton

	protected EdificioDao() {}

	public static EdificioDao getInstance() {
		if (instancia == null)
			instancia = new EdificioDao();
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
	public Edificio traerEdificioConAulas(int id) {
		Edificio obj = null;
		try {
			iniciaOperacion();
			String hQL= "from Edificio e where e.id="+id;
			obj = (Edificio)session.createQuery(hQL).uniqueResult();
			Hibernate.initialize(obj.getAulas());

		}finally {
			session.close();
		}
		return obj;
	}

}
