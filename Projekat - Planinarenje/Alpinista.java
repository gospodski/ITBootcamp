package cetvrta_nedelja_Planinarenje;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Alpinista extends Planinar {

	private Alpinista partner;
	private static final int V = 3000;

	public Alpinista(String ime, int kapacitet) {
		super(ime, kapacitet);
		partner = null;
	}

	public void dodeli(Planinar a) {
		if(a instanceof Alpinista)
		partner = (Alpinista) a;
	}

	@Override
	public boolean penjanje(Planina p,Date datum) {
		if (partner != null && p.getVisina() >= V) {
			return true;
		} else
			return false;
	}

	public String toString() {
		String str = "A_" + super.toString();
		return str;
	}

}
