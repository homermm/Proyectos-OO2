package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;

public class DispositivoDao {
	private static Session session;
	private Transaction tx;
	private static DispositivoDao instancia = null; // Patrón Singleton

	protected DispositivoDao() {
	}

	public static DispositivoDao getInstance() {
		if (instancia == null)
			instancia = new DispositivoDao();
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

	// CU1
	public List<Dispositivo> traer() {
		List<Dispositivo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "FROM Dispositivo d ORDER BY d.id asc";
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// CU2
	public Dispositivo traer(String nombre) {
		Dispositivo obj = null;
		try {
			iniciaOperacion();
			String hQL = "FROM Dispositivo d where d.nombre='" + nombre + "'";
			obj = (Dispositivo) session.createQuery(hQL).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}

	// CU8
	public List<Dispositivo> traerTodosLosDispositivosSensorCortinaVentana() {
		List<Dispositivo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "FROM SensorCortinaVentana s";
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}

}
