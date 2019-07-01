package cetvrta_nedelja_Planinarenje;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public abstract class Planinar {

	protected static int idGlobal = 0;
	private String ime;
	private int id;
	private UspesnoPenjanje[] zbirka;
	private int brPopunjenih;

	public Planinar(String ime, int kapacitet) {
		this.ime = ime;
		id = idGlobal++;
		zbirka = new UspesnoPenjanje[kapacitet];
		brPopunjenih = 0;

	}

	public void dodaj(Planina p, Date datum) {
		if (brPopunjenih < zbirka.length) {
			zbirka[brPopunjenih++] = new UspesnoPenjanje(p,datum);
		}
	}

	public abstract boolean penjanje(Planina p, Date datum);

	public boolean penjanjeUspesno(Planina p, Date datum) {
		if (penjanje(p,datum) == true) {
			dodaj(p,datum);
			return true;
		} else
			return false;
	}

	public String toString() {
		String str = ime + " - " + id + " ";
		Planina[] planine = new Planina[brPopunjenih];
		for (int p = 0; p < brPopunjenih; p++) {
			planine[p] = zbirka[p].getPlanina();
		}
		str += "(";
		str += Planina.ispisNiza(planine);
		str += ")";
		return str;
	}

	public int getVisina() {
		int sum = 0;
		Calendar refDatum = Calendar.getInstance();
		refDatum.set(2019, 4,21);
		//refDatum.getTime();
		refDatum.getTimeInMillis();
		
		
		for (int i = 0; i < zbirka.length; i++) {
			if (zbirka[i] == null) {
				return sum;
			}
			
			if (((refDatum.get(Calendar.YEAR)==(zbirka[i].getDatum().get(Calendar.YEAR)-1900))&&(refDatum.get(Calendar.MONTH) == zbirka[i].getDatum().get(Calendar.MONTH)
					&& refDatum.get(Calendar.DAY_OF_MONTH) >= zbirka[i].getDatum().get(Calendar.DAY_OF_MONTH)))
					|| (((zbirka[i].getDatum().get(Calendar.YEAR)-1900)==refDatum.get(Calendar.YEAR)-1)&&((zbirka[i].getDatum().get(Calendar.MONTH) == 12 && refDatum.get(Calendar.MONTH) == 0)
							&& zbirka[i].getDatum().get(Calendar.DAY_OF_MONTH) >= refDatum.get(Calendar.DAY_OF_MONTH)))
					|| ((refDatum.get(Calendar.YEAR)==(zbirka[i].getDatum().get(Calendar.YEAR)-1900))&&(zbirka[i].getDatum().get(Calendar.MONTH) == refDatum.get(Calendar.MONTH) - 1
							&& zbirka[i].getDatum().get(Calendar.DAY_OF_MONTH) >= refDatum.get(Calendar.DAY_OF_MONTH)))) {
				if (zbirka[i].getPlanina().getVisina() > 1800) {
					sum += zbirka[i].getPlanina().getVisina() + 300;
				} else
					sum += zbirka[i].getPlanina().getVisina();
			}

		}
		return sum;
	}

	public String getIme() {
		return ime;
	}
	
	public int getID() {
		return id;
	}

}
