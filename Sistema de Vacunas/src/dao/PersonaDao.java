package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;

import datos.Persona;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null; // Patrón Singleton

	protected PersonaDao() {
	}

	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
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

	public List<Persona> traerPersona() {
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Persona p order by p.fechaNacimiento asc").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Persona> traerPersona(int edadDesde, int edadHasta) {
		List<Persona> lista = new ArrayList<Persona>();

		for (Persona p : traerPersona()) {
			if (p.calcularEdad(LocalDate.now()) > edadDesde && p.calcularEdad(LocalDate.now()) < edadHasta) {
				lista.add(p);
			}
		}

		return lista;
	}

}
