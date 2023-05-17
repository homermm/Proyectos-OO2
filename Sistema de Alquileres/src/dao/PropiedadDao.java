package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Propiedad;


public class PropiedadDao {
	private static Session session;
	private Transaction tx;
	private static PropiedadDao instancia = null; // Patrón Singleton

	protected PropiedadDao() {}

	public static PropiedadDao getInstance() {
		if (instancia == null)
			instancia = new PropiedadDao();
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

	public List<Propiedad> traerPropiedad(){
		List <Propiedad> lista= null;
		try {
			iniciaOperacion();
			String hQL="from Propiedad p order by p.idPropiedad asc";
			lista= session.createQuery(hQL).list();
		}finally {
			session.close();
		}
		return lista;
	}
	// +traerPropiedad(boolean tieneAscensor): List<Propiedad>
	public List<Propiedad> traerPropiedad(boolean tieneAscensor){
		List<Propiedad> lista=null;
		try {
			iniciaOperacion();
			String hQL="FROM Departamento d where d.tieneAscensor="+tieneAscensor;
			lista=session.createQuery(hQL).list();
		}finally {
			session.close();
		}
		return lista;
	}
}
