package test;

import java.time.LocalDate;

import negocio.AlquilerAbm;
import negocio.PropiedadAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-1-");
		System.out.println(PropiedadAbm.getInstance().traerPropiedad());
		
		System.out.println("-2-");
		System.out.println(AlquilerAbm.getInstance().traerAlquiler(1));
		
		System.out.println("-3-");
		System.out.println(PropiedadAbm.getInstance().traerPropiedad(true));
		
		System.out.println("-4-");
		System.out.println(AlquilerAbm.getInstance().calcularPrecioFinal(AlquilerAbm.getInstance().traerAlquiler(1)));
	
		System.out.println("-5-");
		//Calcular el precio final para los alquileres entre las fechas 2022-03-02 y 2022-03-09
		LocalDate desde= LocalDate.of(2022, 3, 2);
		LocalDate hasta= LocalDate.of(2022, 3, 9);
		System.out.println(AlquilerAbm.getInstance().calcularPrecioFinal(desde, hasta));
	
	}

}
