package datos;

public class SensorTemperatura extends Dispositivo {
	private double valorMinimo;
	private double valorMaximo;
	public SensorTemperatura() {
		super();
	}
	public SensorTemperatura(double valorMinimo, double valorMaximo) {
		super();
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}
	public double getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public double getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	@Override
	public String toString() {
		return super.toString()+"SensorTemperatura [valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + "]";
	}
	
}
