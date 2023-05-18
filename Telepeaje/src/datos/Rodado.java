package datos;

import java.util.Objects;

public class Rodado {
	private int id;
	private String dominio;
	private int categoria;
	private Abonado abonado;
	public Rodado() {
		super();
	}
	public Rodado(String dominio, int categoria, Abonado abonado) {
		super();
		this.dominio = dominio;
		this.categoria = categoria;
		this.abonado = abonado;
	}
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public Abonado getAbonado() {
		return abonado;
	}
	public void setAbonado(Abonado abonado) {
		this.abonado = abonado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		Rodado other = (Rodado) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Rodado [id=" + id + ", dominio=" + dominio + ", categoria=" + categoria + ", abonado=" + abonado + "]";
	}
	
	
}
