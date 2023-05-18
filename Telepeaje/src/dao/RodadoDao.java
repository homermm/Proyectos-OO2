package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Rodado;

public class RodadoDao {
	private static Session session;
	private Transaction tx;
	private static RodadoDao instancia = null; // Patrón Singleton

	protected RodadoDao() {}

	public static RodadoDao getInstance() {
		if (instancia == null)
			instancia = new RodadoDao();
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
	//5) + traerRodado(String dominio) : Rodado
	public Rodado traerRodado(String dominio) {
		Rodado obj=null;
		try {
			iniciaOperacion();
			String hQL="FROM Rodado r where r.dominio='"+dominio+"'";
			obj=(Rodado)session.createQuery(hQL).uniqueResult();
			Hibernate.initialize(obj.getAbonado());
		}finally {
			session.close();
		}
		return obj;
	}
}
