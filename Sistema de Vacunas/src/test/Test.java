package test;

import java.time.LocalTime;

import datos.Vacuna;
import negocio.DosisAbm;
import negocio.PersonaAbm;
import negocio.VacunaAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-1-");
		int vacuna=800011;
		Vacuna vacunaAux=VacunaAbm.getInstance().traerVacuna(vacuna);
		System.out.println(vacunaAux);
		
		System.out.println("-2-");
		System.out.println(PersonaAbm.getInstance().traerPersona(30, 40));
		
		System.out.println("-3-");
		System.out.println(DosisAbm.getInstance().traerDosis(vacunaAux));
		
		System.out.println("-4-");
		LocalTime horaDesde= LocalTime.of(11, 15);
		LocalTime horaHasta= LocalTime.of(11, 45);
		System.out.println(DosisAbm.getInstance().traerDosis(horaDesde, horaHasta));
		
		System.out.println("-5-");
		System.out.println(DosisAbm.getInstance().traerDosis(horaDesde, horaHasta, false));
	}

}
