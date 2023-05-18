package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public abstract class Peaje {
	protected int idPeaje;
	protected LocalDate fecha;
	protected LocalTime hora;
	protected double precio;
	public Peaje() {
		super();
	}
	public Peaje(LocalDate fecha, LocalTime hora, double precio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}
	public int getIdPeaje() {
		return idPeaje;
	}
	protected void setIdPeaje(int idPeaje) {
		this.idPeaje = idPeaje;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPeaje);
	}
	@Override
	public boolean equals(Object obj) {
		Peaje other = (Peaje) obj;
		return idPeaje == other.idPeaje;
	}
	@Override
	public String toString() {
		return "\nPeaje [idPeaje=" + idPeaje + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + "]";
	}
	
}
