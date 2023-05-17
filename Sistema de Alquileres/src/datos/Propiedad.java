package datos;

import java.util.Objects;

public abstract class Propiedad {
	protected int idPropiedad;
	protected double precioBase;
	protected String direccion;
	public Propiedad() {
		super();
	}
	public Propiedad(double precioBase, String direccion) {
		super();
		this.precioBase = precioBase;
		this.direccion = direccion;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	protected void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPropiedad);
	}
	@Override
	public boolean equals(Object obj) {
		Propiedad other = (Propiedad) obj;
		return idPropiedad == other.idPropiedad;
	}
	@Override
	public String toString() {
		return "\nPropiedad [idPropiedad=" + idPropiedad + ", precioBase=" + precioBase + ", direccion=" + direccion
				+ "]";
	}
//	 ~precioPorNoche(): double
	public abstract double precioPorNoche();
	
}
