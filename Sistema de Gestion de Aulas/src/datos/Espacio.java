package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Espacio {
	private int id;
	private LocalDate fecha;
	private char turno;
	private Aula aula;
	private boolean libre;
	public Espacio() {
		super();
	}
	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public char getTurno() {
		return turno;
	}
	public void setTurno(char turno) {
		this.turno = turno;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	public boolean isLibre() {
		return libre;
	}
	public void setLibre(boolean libre) {
		this.libre = libre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		Espacio other = (Espacio) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "\nEspacio [id=" + id + ", turno=" + turno + ", aula=" + aula + ", libre=" + libre + "]";
	}
	
}
