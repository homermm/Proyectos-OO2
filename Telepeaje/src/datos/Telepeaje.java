package datos;

public class Telepeaje extends Peaje {
	private Rodado rodado;
	private String lector;
	public Telepeaje() {
		super();
	}
	public Telepeaje(Rodado rodado, String lector) {
		super();
		this.rodado = rodado;
		this.lector = lector;
	}
	public Rodado getRodado() {
		return rodado;
	}
	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}
	public String getLector() {
		return lector;
	}
	public void setLector(String lector) {
		this.lector = lector;
	}
	@Override
	public String toString() {
		return super.toString()+"Telepeaje [rodado=" + rodado + ", lector=" + lector + "]";
	}
	
}
