package datos;

import java.util.Objects;

public class Abonado {
	private int id;
	private String apellido;
	private String nombres;
	private int dni;
	public Abonado() {
		super();
	}
	public Abonado(String apellido, String nombres, int dni) {
		super();
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		Abonado other = (Abonado) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Abonado [id=" + id + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni + "]";
	}
	
	
}
