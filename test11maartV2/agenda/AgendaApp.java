package test11maartV2.agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgendaApp {

	
	public static void main(String[] args) {
		LocalDate nowDate = LocalDate.now();
		LocalDate beginOpleiding = LocalDate.of(2019, 01, 28);
		LocalDate firstHoliday = LocalDate.of(2019, 04, 20);
		LocalDate summer  = LocalDate.of(2019, 06, 21);
		
	
		
		System.out.print("Days since the begin of the training: ");		
		System.out.println((int) ChronoUnit.DAYS.between( beginOpleiding,nowDate));
		System.out.print("Days to wait before our first holidays begins: ");		
		System.out.println((int) ChronoUnit.DAYS.between( nowDate,firstHoliday));
		System.out.print("This year, summer will begin on ");				
		System.out.println(summer.getDayOfWeek());
		

	}
}
