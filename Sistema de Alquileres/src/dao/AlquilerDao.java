package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Alquiler;

public class AlquilerDao {
	private static Session session;
	private Transaction tx;
	private static AlquilerDao instancia = null; // Patrón Singleton

	protected AlquilerDao() {}

	public static AlquilerDao getInstance() {
		if (instancia == null)
			instancia = new AlquilerDao();
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
	//2) +traerAlquiler(int id): Alquiler
	public Alquiler traerAlquiler(int id) {
		Alquiler obj= null;
		try {
			iniciaOperacion();
			String hQL="FROM Alquiler a WHERE a.id="+id;
			obj=(Alquiler)session.createQuery(hQL).uniqueResult();
			Hibernate.initialize(obj.getPropiedad());
		}finally {
			session.close();
		}
		return obj;
	}
	public double calcularPrecioFinal(Alquiler alquiler) {
		return alquiler.precioFinal();
	}
	//+calcularPrecioFinal(LocalDate desde, LocalDate hasta): double
	//Al momento de traer los alquileres se tienen que obtener los que tengan una fechaDesde igual o
//	posterior al parámetro ‘desde’, y que además, tengan una fechaHasta igual o anterior al parámetro
//	‘hasta’
	
	public double calcularPrecioFinal(LocalDate desde, LocalDate hasta) {
		double calcular = 0;
		for(Alquiler a: traerAlquileres()) {
	
			if(a.getFechaDesde().equals(desde) || a.getFechaDesde().isAfter(desde) && a.getFechaHasta().isBefore(hasta)||a.getFechaHasta().equals(hasta)) {
				calcular+= a.precioFinal();
			}
		}
		return calcular;
	}

	public List<Alquiler> traerAlquileres(){
		List<Alquiler> lista =null;
		try {
			iniciaOperacion();
			String hQL="FROM Alquiler a order by a.idAlquiler asc";
			lista = session.createQuery(hQL).list();
			for(Alquiler a: lista) {
				Hibernate.initialize(a.getPropiedad());
			}
		}finally {
			session.close();
		}
		return lista;
	}
}
