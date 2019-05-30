package cetvrta_nedelja_domaci_treci;

public class Pice extends Namirnica {

	private double kolicina;
	private double enVr;

	public Pice(String ime, double kolicina, double enVr) {
		super(ime);
		this.kolicina = kolicina;
		this.enVr = enVr;

	}

	public double getKolicina() {
		return kolicina;
	}

	public double energVr() {
		double sum = kolicina * enVr;
		return sum;
	}

	public String toString() {
		String str = super.toString() + " (" + kolicina + "l, " + energVr() + "kJ)";
		return str;
	}

}
