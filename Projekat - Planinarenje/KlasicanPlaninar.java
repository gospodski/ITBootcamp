package cetvrta_nedelja_Planinarenje;

import java.util.Calendar;
import java.util.Date;

public class KlasicanPlaninar extends Planinar {

	private static final int V = 2000;

	public KlasicanPlaninar(String ime, int kapacitet) {
		super(ime, kapacitet);
	}

	@Override
	public boolean penjanje(Planina p, Date datum) {
		if (p.getVisina() <= V)
			return true;
		else
			return false;
	}

	public String toString() {
		String str = "K_" + super.toString();
		return str;
	}

}
