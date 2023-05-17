package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Alquiler {
	private int idAlquiler;
	private Propiedad propiedad;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private int cantidadNoches;

	public Alquiler() {
		super();
	}

	public Alquiler(Propiedad propiedad, LocalDate fechaDesde, LocalDate fechaHasta, int cantidadNoches) {
		super();
		this.propiedad = propiedad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.cantidadNoches = cantidadNoches;
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	protected void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public int getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(int cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAlquiler);
	}

	@Override
	public boolean equals(Object obj) {
		Alquiler other = (Alquiler) obj;
		return idAlquiler == other.idAlquiler;
	}

	@Override
	public String toString() {
		return "\nAlquiler [idAlquiler=" + idAlquiler + ", propiedad=" + propiedad + ", fechaDesde=" + fechaDesde
				+ ", fechaHasta=" + fechaHasta + ", cantidadNoches=" + cantidadNoches + "]";
	}

	// +precioFinal(): double
	// Calcula el precio por noche multiplicado por la cantidad de noches
	public double precioFinal() {
		return propiedad.precioPorNoche() * cantidadNoches;
	}
}
