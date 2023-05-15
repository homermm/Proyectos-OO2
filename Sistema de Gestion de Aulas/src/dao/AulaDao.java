package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;
import datos.Edificio;

public class AulaDao {
	private static Session session;
	private Transaction tx;
	private static AulaDao instancia = null; // Patrón Singleton

	protected AulaDao() {}

	public static AulaDao getInstance() {
		if (instancia == null)
			instancia = new AulaDao();
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
	
	public Aula traerAulaConEdificio(int id) {
		Aula obj = null;
		try {
			iniciaOperacion();
			String hQL="from Aula a where a.id="+id;
			obj = (Aula)session.createQuery(hQL).uniqueResult();
			Hibernate.initialize(obj.getEdificio());
		}finally {
			session.close();
		}
		return obj;
	}
}
