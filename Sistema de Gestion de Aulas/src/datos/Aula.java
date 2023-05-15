package datos;

import java.util.Objects;

public class Aula {
	private int id;
	private int numero;
	private Edificio edificio;
	public Aula() {
		super();
	}
	public Aula(int numero, Edificio edificio) {
		super();
		this.numero = numero;
		this.edificio = edificio;
	}
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	@Override
	public String toString() {
		return "\nAula [id=" + id + ", numero=" + numero + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		Aula other = (Aula) obj;
		return id == other.id;
	}
	
}
