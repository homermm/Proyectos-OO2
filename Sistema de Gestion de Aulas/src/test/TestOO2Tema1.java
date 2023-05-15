package test;

import java.time.LocalDate;

import datos.Aula;
import datos.Edificio;
import datos.Espacio;
import negocio.AulaAbm;
import negocio.EdificioAbm;
import negocio.EspacioAbm;

public class TestOO2Tema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-1-");
		int id=1;
		Edificio edificio1 = EdificioAbm.getInstance().traerEdificioConAulas(id);
		System.out.println(edificio1);
		System.out.println(edificio1.getAulas());

		System.out.println("-2-");
		Aula aula1=AulaAbm.getInstance().traerAulaConEdificio(5);
		System.out.println(aula1);
		System.out.println(aula1.getEdificio());
		
		System.out.println("-3-");
		Espacio espacio1 = EspacioAbm.getInstance().traer(LocalDate.of(2022, 5, 1), 'M', AulaAbm.getInstance().traerAulaConEdificio(5));
		System.out.println(espacio1);
		
		System.out.println("-4-");
		try {
			System.out.println(EspacioAbm.getInstance().agregar(LocalDate.of(2022, 5, 1), 'M', aula1, true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	
		
	}

}
