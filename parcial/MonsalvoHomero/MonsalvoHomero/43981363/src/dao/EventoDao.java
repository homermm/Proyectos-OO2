package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Dispositivo;
import datos.Evento;

public class EventoDao {
	private static Session session;
	private Transaction tx;
	private static EventoDao instancia = null; // Patrón Singleton

	protected EventoDao() {
	}

	public static EventoDao getInstance() {
		if (instancia == null)
			instancia = new EventoDao();
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

	// CU3
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		Evento obj = null;
		try {
			iniciaOperacion();
			String hQL = "FROM Evento e INNER JOIN FETCH e.dispositivo d where d.idDispositivo="
					+ dispositivo.getIdDispositivo() + " and e.fechaHora='" + fechaHora + "'";
			obj = (Evento) session.createQuery(hQL).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}

	// CU4
	public boolean agregar(String descripcion,Dispositivo dispositivo,LocalDateTime fechaHora) {
		int id=0;
		try {
			iniciaOperacion();
			Evento obj = new Evento(descripcion, dispositivo, fechaHora);
			id= Integer.parseInt(session.save(obj).toString());
			tx.commit();
		}catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
	}
		return true;
	}
	
	//CU5
	public List<Evento> traer(){
	List<Evento> lista = null;
	try {
		iniciaOperacion();
		String hQL="FROM Evento e INNER JOIN FETCH e.dispositivo d";
		lista = session.createQuery(hQL).list();
	}finally {
		session.close();
	}
	return lista;
	}
	
	//CU6
	public List<Evento> traer(LocalDateTime fechaHoraDesde,LocalDateTime fechaHoraHasta){
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			String hQL="FROM Evento e INNER JOIN FETCH e.dispositivo where e.fechaHora BETWEEN '"+fechaHoraDesde+"' and '"+fechaHoraHasta+"'";
			lista = session.createQuery(hQL).list();
		}finally {
			session.close();
		}
		return lista;
	}
//	//CU7
//	public List<Evento> traer(LocalDateTime fechaHoraDesde,LocalDateTime fechaHoraHasta,Dispositivo dispositivo){
//		List<Evento> lista = null;
//		try {
//			iniciaOperacion();
//			String hQL="FROM Evento e INNER JOIN FETCH e.dispositivo d where d.idDispositivo="+dispositivo.getIdDispositivo()+" and e where e.fechaHora BETWEEN '"+fechaHoraDesde+"' and '"+fechaHoraHasta+"'";
//			lista = session.createQuery(hQL).list();
//			
//			
//		}finally {
//			session.close();
//		}
//		return lista;
//	}
	
}
