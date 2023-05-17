package datos;

public class Casa extends Propiedad {
	private boolean tienePatio;

	public Casa() {
		super();
	}

	public Casa(boolean tienePatio) {
		super();
		this.tienePatio = tienePatio;
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	@Override
	public String toString() {
		return super.toString()+"Casa [tienePatio=" + tienePatio + "]";
	}

	@Override
	public double precioPorNoche() {
		 //Para el caso de Casa se pide que si tiene patio sea el precioBase + un 10%, sino solamente el
//		precioBase
		double precio = precioBase;
		if(tienePatio) precio=precioBase*1.10;
		return  precio;
	}
	
}
