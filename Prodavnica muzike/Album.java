package treca_nedelja_domaci_tri;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Album {

	private String naziv;
	private String izvodjac;
	private Date datum;
	private LinkedList<Numera> lista;

	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		lista = new LinkedList<Numera>();
	}

	public void dodaj(Numera numera) {
		lista.add(numera);
	}

	public void dodaj(String name, String trajanje) {
		Numera numera = new Numera(name, izvodjac, trajanje);
		lista.add(numera);
	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public String getTrajanje() {
		int sum1 = 0;
		int sum2 = 0;
		String ukupnoTrajanje;
		for (int i = 0; i < lista.size(); i++) {
			String[] pom = lista.get(i).getTrajanje().split(":");
			String pomMinut = pom[0];
			String pomSekund = pom[1];
			int minut = Integer.parseInt(pomMinut);
			int sekund = Integer.parseInt(pomSekund);
			sum1 += minut;
			sum2 += sekund;
		}
		int x = 0;
		for (int j = 60; j <= sum2; sum2 -= 60) {
			x++;
		}

		ukupnoTrajanje = (sum1 + x) + ":" + sum2;
		return ukupnoTrajanje;
	}

	public Date getDatum() {
		return datum;
	}

	public Numera getNumera(int indeks) {
		return lista.get(indeks);
	}

	public Numera getNumera(String ime) {
		Numera trazenaNumera = null;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNaziv().equals(ime)) {
				trazenaNumera = lista.get(i);
			}
		}
		return trazenaNumera;
	}

	public String toString() {
		String ispis = izvodjac + " - " + naziv + "(" + getDatum().getYear() + ")" + ":[\n\t";
		for (int i = 0; i < lista.size(); i++) {
			if (i == lista.size() - 1) {
				ispis += lista.get(i).toString() + "\n";
			} else 
				ispis += lista.get(i).toString() + "\n\t";
		}
		ispis += "]: " + getTrajanje() + "\n";
		return ispis;
	}
}
