package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import datos.Dispositivo;
import negocio.DispositivoAbm;
import negocio.EventoAbm;

public class TestOO2Tema2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-1-");
		System.out.println(DispositivoAbm.getInstance().traer());
		
		System.out.println("-2-");
		//agregar(String descripcion,Dispositivo dispositivo,LocalDateTime fechaHora)
		Dispositivo dispositivo = DispositivoAbm.getInstance().traer("cortina pieza");
		LocalDate date1 = LocalDate.of(2023, 4, 3);
		LocalTime time1 = LocalTime.of(9, 10);
		
		try {
			EventoAbm.getInstance().agregar("Apertura de la cortina", dispositivo, LocalDateTime.of(date1, time1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalTime time2 = LocalTime.of(19, 05);
		
		try {
			EventoAbm.getInstance().agregar("Cierre de la cortina", dispositivo, LocalDateTime.of(date1, time2));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalDate date3 = LocalDate.of(2023, 4, 4);
		LocalTime time3 = LocalTime.of(9, 0);
		try {
			EventoAbm.getInstance().agregar("Apertura de la cortina", dispositivo, LocalDateTime.of(date3, time3));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalDate date4 = LocalDate.of(2023, 4, 4);
		LocalTime time4 = LocalTime.of(19, 01);
		
		try {
			EventoAbm.getInstance().agregar("Cierre de la cortina", dispositivo, LocalDateTime.of(date4, time4));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalDate date5 = LocalDate.of(2023, 4, 4);
		LocalTime time5 = LocalTime.of(11, 30);
		Dispositivo dispositivo2 = DispositivoAbm.getInstance().traer("temp pieza");
		try {
			EventoAbm.getInstance().agregar("23 grados. Prender aire acondicionado", dispositivo2, LocalDateTime.of(date5, time5));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalDate date6 = LocalDate.of(2023, 4, 4);
		LocalTime time6 = LocalTime.of(12, 00);
		
		try {
			EventoAbm.getInstance().agregar("20 grados. Apagar aire acondicionado", dispositivo2, LocalDateTime.of(date6, time6));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalDate date7 = LocalDate.of(2023, 4, 5);
		LocalTime time7 = LocalTime.of(9, 5);
		try {
			EventoAbm.getInstance().agregar("Apertura de la cortina", dispositivo, LocalDateTime.of(date7, time7));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		LocalDate date8 = LocalDate.of(2023, 4, 5);
		LocalTime time8 = LocalTime.of(19, 5);
		try {
			EventoAbm.getInstance().agregar("Cierre de la cortina", dispositivo, LocalDateTime.of(date8, time8));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-3-");
		LocalDate fechaDesde=LocalDate.of(2023, 4, 3);
		LocalTime horaDesde= LocalTime.of(12, 0);
		LocalDateTime fechaHoraDesde = LocalDateTime.of(fechaDesde, horaDesde);
		
		
		LocalDate fechaHasta= LocalDate.of(2023, 4, 5);
		LocalTime horaHasta= LocalTime.of(12, 0);
		LocalDateTime fechaHoraHasta= LocalDateTime.of(fechaHasta, horaHasta);
		
		System.out.println(EventoAbm.getInstance().traer(fechaHoraDesde, fechaHoraHasta));
		
		
		System.out.println("-4-");
		LocalDate fechaDesde1= LocalDate.of(2023, 4, 3);
		LocalTime horaDesde1= LocalTime.of(12, 0);
		LocalDateTime fechaHoraDesde1 = LocalDateTime.of(fechaDesde1, horaDesde1);
		
		LocalDate fechaHasta1= LocalDate.of(2023, 4, 5);
		LocalTime horaHasta1= LocalTime.of(12, 0);
		LocalDateTime fechaHoraHasta1 = LocalDateTime.of(fechaHasta1, horaHasta1);
		
		System.out.println(EventoAbm.getInstance().traer(fechaHoraDesde1, fechaHoraHasta1, dispositivo));
		
		System.out.println("-5-");
		System.out.println(DispositivoAbm.getInstance().traerTodosLosDispositivosSensorCortinaVentana());
		
		
	}

}
