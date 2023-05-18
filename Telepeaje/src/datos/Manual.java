package datos;

public class Manual extends Peaje {
	private String codCabina;

	public Manual() {
		super();
	}

	public Manual(String codCabina) {
		super();
		this.codCabina = codCabina;
	}

	public String getCodCabina() {
		return codCabina;
	}

	public void setCodCabina(String codCabina) {
		this.codCabina = codCabina;
	}

	@Override
	public String toString() {
		return super.toString()+"Manual [codCabina=" + codCabina + "]";
	}
	
}
