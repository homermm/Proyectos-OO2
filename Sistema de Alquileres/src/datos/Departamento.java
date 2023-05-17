package datos;

public class Departamento extends Propiedad{
	private int cantidadAmbientes;
	private int nroPiso;
	private boolean tieneAscensor;
	public Departamento() {
		super();
	}
	public Departamento(int cantidadAmbientes, int nroPiso, boolean tieneAscensor) {
		super();
		this.cantidadAmbientes = cantidadAmbientes;
		this.nroPiso = nroPiso;
		this.tieneAscensor = tieneAscensor;
	}
	public int getCantidadAmbientes() {
		return cantidadAmbientes;
	}
	public void setCantidadAmbientes(int cantidadAmbientes) {
		this.cantidadAmbientes = cantidadAmbientes;
	}
	public int getNroPiso() {
		return nroPiso;
	}
	public void setNroPiso(int nroPiso) {
		this.nroPiso = nroPiso;
	}
	public boolean isTieneAscensor() {
		return tieneAscensor;
	}
	public void setTieneAscensor(boolean tieneAscensor) {
		this.tieneAscensor = tieneAscensor;
	}
	@Override
	public String toString() {
		return super.toString()+"Departamento [cantidadAmbientes=" + cantidadAmbientes + ", nroPiso=" + nroPiso + ", tieneAscensor="
				+ tieneAscensor + "]";
	}
	@Override
	public double precioPorNoche() {
		// Para el caso de Departamento se pide “precioBase + (cantidadAmbientes * 100)”
		return precioBase + (cantidadAmbientes * 100);
	}
	
}
