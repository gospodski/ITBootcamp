package cetvrta_nedelja_domaci_treci;

public abstract class Namirnica extends Energent {

	protected String ime;
	public static int idGlobal = 1;
	protected int id;

	public Namirnica(String ime) {
		this.ime = ime;
		id = idGlobal++;
	}

	public String getIme() {
		return ime;
	}

	public int getId() {
		return id;
	}

	public abstract double energVr();

	public String toString() {
		String str = "[" + id + "] " + ime;
		return str;
	}
}
