package cetvrta_nedelja_Planinarenje;

import java.util.Calendar;
import java.util.Date;

public class UspesnoPenjanje {

	private Planina planina;
	private Calendar datum;

	public UspesnoPenjanje(Planina planina, Date datum) {
		this.planina = planina;
		Calendar cal = Calendar.getInstance();
		cal.setTime(datum);
		this.datum = cal;
	}

	public UspesnoPenjanje(Planina planina) {
		this.planina = planina;
		datum = Calendar.getInstance();
	}

	public Planina getPlanina() {
		return planina;
	}

	public Calendar getDatum() {
		return datum;
	}

}
