package datos;

import java.util.Objects;
import java.util.Set;

public class Edificio {
	private int id;
	private String edificio;
	private Set<Aula> aulas;
	public Edificio() {
		super();
	}
	public Edificio(int id, String edificio, Set<Aula> aulas) {
		super();
		this.id = id;
		this.edificio = edificio;
		this.aulas = aulas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public Set<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		Edificio other = (Edificio) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Edificio [id=" + id + ", edificio=" + edificio + "]";
	}
	
	
}
