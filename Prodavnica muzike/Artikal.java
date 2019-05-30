package treca_nedelja_domaci_tri;

public abstract class Artikal {
	
	private static int idglobal=1;
	private int id;
	private double cena;
	private int kolicina;
	
	
public Artikal(double cena, int kol) {
	this.cena = cena;
	kolicina = kol;
	id=idglobal;
	idglobal++;
}


public boolean kupi() {
	if(kolicina>0) {
		kolicina--;
		return true;
	} else return false;
}

public abstract String ime();

public int getId() {
	return id;
}


public double getCena() {
	return cena;
}


public int getKolicina() {
	return kolicina;
}

public String toString() {
	String ispis = "#" + id + ": " + ime() + " - " + cena + " [kol: " + kolicina + "]";
	return ispis;
}


}
