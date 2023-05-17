package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Dosis {
	private int idDosis;
	private String vacunatorio;
	private LocalDate fecha;
	private LocalTime hora;
	private Vacuna vacuna;
	private Persona persona;
	
	public Dosis() {
		super();
	}
	
	public Dosis(String vacunatorio, LocalDate fecha, LocalTime hora, Vacuna vacuna, Persona persona) {
		super();
		this.vacunatorio = vacunatorio;
		this.fecha = fecha;
		this.hora = hora;
		this.vacuna = vacuna;
		this.persona = persona;
	}

	public int getIdDosis() {
		return idDosis;
	}
	protected void setIdDosis(int idDosis) {
		this.idDosis = idDosis;
	}
	public String getVacunatorio() {
		return vacunatorio;
	}
	public void setVacunatorio(String vacunatorio) {
		this.vacunatorio = vacunatorio;
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
	public Vacuna getVacuna() {
		return vacuna;
	}
	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idDosis);
	}
	@Override
	public boolean equals(Object obj) {
		Dosis other = (Dosis) obj;
		return idDosis == other.idDosis;
	}
	@Override
	public String toString() {
		return "\nDosis [idDosis=" + idDosis + ", vacunatorio=" + vacunatorio + ", fecha=" + fecha + ", hora=" + hora
				+ ", vacuna=" + vacuna + ", persona=" + persona + "]";
	}
	
	
}
