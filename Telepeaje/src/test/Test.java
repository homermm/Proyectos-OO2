package test;

import java.time.LocalDate;

import datos.Rodado;
import negocio.PeajeAbm;
import negocio.RodadoAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1) Traer e imprimir todos los peajes manuales
		System.out.println("-1-");
		System.out.println(PeajeAbm.getInstance().traerManual());
		
		System.out.println("-2-");
		System.out.println(PeajeAbm.getInstance().traerTelepeaje());
		
		System.out.println("-3-");
		//3) Traer e imprimir los peajes Manual de fecha=2020-11-01
		System.out.println(PeajeAbm.getInstance().traerManual(LocalDate.of(2020, 11, 1)));
		
		System.out.println("-4-");
		System.out.println(PeajeAbm.getInstance().cerrarCaja(LocalDate.of(2020, 11, 1)));
		
		System.out.println("-5-");
		Rodado rodado = RodadoAbm.getInstance().traerRodado("AAA111");
		System.out.println(rodado);
		
		System.out.println("-6-");
		System.out.println(PeajeAbm.getInstance().traerTelepeaje(rodado));
		
		
	}

}
