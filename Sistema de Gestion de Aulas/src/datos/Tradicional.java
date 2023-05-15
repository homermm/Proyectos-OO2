package datos;

public class Tradicional extends Aula {
	private int cantBancos;
	private String pizarron;
	private boolean tieneProyector;
	public Tradicional() {
		super();
	}
	public Tradicional(int cantBancos, String pizarron, boolean tieneProyector) {
		super();
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}
	public int getCantBancos() {
		return cantBancos;
	}
	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}
	public String getPizarron() {
		return pizarron;
	}
	public void setPizarron(String pizarron) {
		this.pizarron = pizarron;
	}
	public boolean isTieneProyector() {
		return tieneProyector;
	}
	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}
	@Override
	public String toString() {
		return super.toString()+"Tradicional [cantBancos=" + cantBancos + ", pizarron=" + pizarron + ", tieneProyector=" + tieneProyector
				+ "]";
	}
	
	
	
}
