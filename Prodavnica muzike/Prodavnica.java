package treca_nedelja_domaci_tri;

import java.util.LinkedList;

public class Prodavnica {
	
	private String ime;
	private String lokacija;
	LinkedList<Artikal> inventar;
	
	
public Prodavnica(String ime, String lokacija) {
	this.ime = ime;
	this.lokacija = lokacija;
	inventar = new LinkedList<Artikal>();
}

public LinkedList<Artikal> pretrazi(String tekst){
	LinkedList<Artikal> pretraga = new LinkedList<Artikal>();
	String pom1="";
	String pom2="";
	for(int i=0;i<inventar.size();i++) {
		pom1 = inventar.get(i).ime().toLowerCase();
		pom2 = tekst.toLowerCase();
		if(pom1.contains(pom2)) {
			pretraga.add(inventar.get(i));
		}
			
	}
	return pretraga;
}

public void dodaj(Artikal artikal) {
	inventar.add(artikal);
}

public String getIme() {
	return ime;
}

public String getLokacija() {
	return lokacija;
}

public String toString() {
	String ispis = ime + ": " + lokacija + "[\n\t";
	for(int i = 0; i<inventar.size();i++) {
		if(i == inventar.size() - 1) {
			ispis += inventar.get(i).toString() + "\n";
		}
		else 
			ispis += inventar.get(i).toString() + "\n\t";
	}
	ispis+="]";
	return ispis;
}

}
