package cetvrta_nedelja_domaci_treci;

public class Meni {

	private Namirnica[] niz;
	private int brNam = 0;

	public Meni(int kapacitet) {
		niz = new Namirnica[kapacitet];

	}

	public boolean dodaj(Namirnica namirnica) {
		if (niz.length > brNam) {
			niz[brNam++] = namirnica;
			return true;
		} else
			return false;
	}

	public String toString() {
		double sum = 0;
		for (int i = 0; i < brNam; i++) {
			sum += niz[i].energVr();
		}
		String str = "Meni (" + sum + "kJ): \n";
		for (int i = 0; i < brNam; i++) {
			str += "  " + niz[i].toString() + "\n";
		}
		return str;
	}

}
