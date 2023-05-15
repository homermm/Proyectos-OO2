package datos;

import java.util.Objects;

public class Laboratorio extends Aula {
	private int cantPC;
	private int cantSillas;
	public Laboratorio() {
		super();
	}
	public Laboratorio(int cantPC, int cantSillas) {
		super();
		this.cantPC = cantPC;
		this.cantSillas = cantSillas;
	}
	public int getCantPC() {
		return cantPC;
	}
	public void setCantPC(int cantPC) {
		this.cantPC = cantPC;
	}
	public int getCantSillas() {
		return cantSillas;
	}
	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cantPC, cantSillas);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
	
		Laboratorio other = (Laboratorio) obj;
		return cantPC == other.cantPC && cantSillas == other.cantSillas;
	}
	@Override
	public String toString() {
		return super.toString()+"Laboratorio [cantPC=" + cantPC + ", cantSillas=" + cantSillas + "]";
	}
	
}
