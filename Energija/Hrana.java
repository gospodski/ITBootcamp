package cetvrta_nedelja_domaci_treci;

public class Hrana extends Namirnica {

	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;

	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljHidrati) {
		super(ime);
		this.tezina = tezina;
		this.belancevine = belancevine;
		this.masti = masti;
		this.ugljHidrati = ugljHidrati;

	}

	public double getTezina() {
		return tezina;
	}

	public double getBelancevine() {
		return belancevine;
	}

	public double getMasti() {
		return masti;
	}

	public double getUgljHidrati() {
		return ugljHidrati;
	}

	public double energVr() {
		double sum = 0;
		if (belancevine + masti + ugljHidrati > 100) {
			System.err.println("Greska u unosu procenata!");
			return sum;
		} else {
			sum += ((tezina * belancevine) / 100 * 16.7) + ((tezina * masti) / 100 * 37.6)
					+ ((tezina * ugljHidrati) / 100 * 17.2);
			return sum;
		}
	}

	public String toString() {
		String str = super.toString() + " (" + tezina + "g, " + energVr() + "kJ" + ")";
		return str;
	}

}
