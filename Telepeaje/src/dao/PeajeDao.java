package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Manual;
import datos.Rodado;
import datos.Telepeaje;


public class PeajeDao {
	private static Session session;
	private Transaction tx;
	private static PeajeDao instancia = null; // Patrón Singleton

	protected PeajeDao() {}

	public static PeajeDao getInstance() {
		if (instancia == null)
			instancia = new PeajeDao();
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
	//1) + traerManual() : List<Manual>
	public List<Manual> traerManual(){
		List<Manual> lista = null;
		try {
			iniciaOperacion();
			String hQL="FROM Manual m order by m.id asc";
			lista = session.createQuery(hQL).list();
		}finally {
			session.close();
		}
		return lista;
	}
	//2) + traerTelepeaje():List<Telepeaje>
	public List<Telepeaje> traerTelepeaje(){
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			String hQL="FROM Telepeaje t order by t.id asc";
			lista = session.createQuery(hQL).list();
			for(Telepeaje t: lista) {
				Hibernate.initialize(t.getRodado());
				Hibernate.initialize(t.getRodado().getAbonado());
			}
			
		}finally {
			session.close();
		}
		return lista;
	}
	//3) + traerManual(LocalDate fecha):List<Manual>
	public List<Manual> traerManual(LocalDate fecha){
		List<Manual> lista = null;
		try {
			iniciaOperacion();
			String hQL="FROM Manual m where m.fecha='"+fecha+"'";
			lista = session.createQuery(hQL).list();
		}finally {
			session.close();
		}
		return lista;
	}
	//4) + cerrarCaja(LocalDate fecha) : double
	//4) Calcular e imprimir el total de caja por los peajes manuales del día=2020-11-01
	public double cerrarCaja(LocalDate fecha) {
		double total= 0;
		for (Manual m: traerManual(fecha)) {
			total += m.getPrecio();
		}
		return total;
	}
	//6) + traerTelepeaje(Rodado rodado) : List<Telepeaje>
	public List<Telepeaje> traerTelepeaje(Rodado rodado){
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			String hQL="FROM Telepeaje t inner join fetch t.rodado r where r.id="+rodado.getId();
			lista=session.createQuery(hQL).list();
			for (Telepeaje p :lista) {
				Hibernate.initialize(p.getRodado().getAbonado());
			}
		}finally {
			session.close();
		}
		return lista;
	}

}
