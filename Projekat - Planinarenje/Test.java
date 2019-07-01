package cetvrta_nedelja_Planinarenje;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Test {
	
	private static void popniSe(Planinar planinar, Planina planina, Date datum) {
		if (planinar.penjanjeUspesno(planina,datum) == true)
			System.out.println(planinar + " - USPEH");
		else
			System.out.println(planinar + " " + planina + " - NEUSPEH");
	}

	public static void main(String[] args) {
		Planina montBlan = new Planina("Mont Blan", 4807);
		Planina zlatibor = new Planina("Zlatibor", 1496);
		PlaninarskoDrustvo drustvo = 
				new PlaninarskoDrustvo("Drustvo", 2000,
				new Planinar[] { new Alpinista("Ognjen", 5),
				new KlasicanPlaninar("Marko", 10) });
		
		drustvo.uclanjenje(new Alpinista("Zoran", 15));
		drustvo.uclanjenje(new KlasicanPlaninar("Milos", 2));
		
	
		popniSe(drustvo.getPlaninara(1), montBlan, new Date(2019, 5, 13));
		popniSe(drustvo.getPlaninara(2), zlatibor, new Date(2019, 4, 13));
		if (drustvo.getPlaninara(1) instanceof Alpinista)
			((Alpinista) drustvo.getPlaninara(1)).dodeli(drustvo.getPlaninara(3));
		if (drustvo.getPlaninara(3) instanceof Alpinista)
			((Alpinista) drustvo.getPlaninara(3)).dodeli(drustvo.getPlaninara(1));
		popniSe(drustvo.getPlaninara(1), montBlan, new Date(2019, 4, 13));
		popniSe(drustvo.getPlaninara(3), montBlan, new Date(2018, 4, 15));
		popniSe(drustvo.getPlaninara(3), zlatibor, new Date(2019, 1, 1));
		System.out.println(drustvo.rangiranje());
	}



}
