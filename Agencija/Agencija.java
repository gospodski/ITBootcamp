package sesta_nedelja_domaci_prvi;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Agencija {

	private String naziv;
	protected static String url = "Agencija.db";

	public Agencija(String naziv) {
		this.naziv = naziv;
		try(Connection konekcija = DriverManager.getConnection(url)){
			
		}
		catch(Exception e) {
			
		}
	}

	public List<Ponuda> pretrazi(int maxCena) throws SQLException {
		Connection connection = DriverManager.getConnection(url);
		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta FROM Skijaliste JOIN Termin USING (IdSki) WHERE Termin.Cena < "
				+ maxCena + " ORDER BY Termin.Cena ASC";
		Statement stm = connection.createStatement();
		ResultSet rezultat = stm.executeQuery(upit);
		LinkedList<Ponuda> listaPonuda = new LinkedList<Ponuda>();

		while (rezultat.next()) {
			Ponuda ponuda = new Ponuda(rezultat.getInt(1), rezultat.getString(2), rezultat.getString(3),
					rezultat.getInt(4), rezultat.getInt(5), rezultat.getInt(6), rezultat.getInt(7));
			listaPonuda.add(ponuda);
		}
		return listaPonuda;
	}

	public List<Ponuda> pretrazi(String drzava) throws SQLException {
		Connection connection = DriverManager.getConnection(url);
		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta FROM Skijaliste JOIN Termin USING (IdSki) WHERE Skijaliste.Drzava = '"
				+ drzava + "' ORDER BY Termin.Cena ASC";
		Statement stm = connection.createStatement();
		ResultSet rezultat = stm.executeQuery(upit);
		LinkedList<Ponuda> listaPonuda = new LinkedList<Ponuda>();

		while (rezultat.next()) {
			Ponuda ponuda = new Ponuda(rezultat.getInt(1), rezultat.getString(2), rezultat.getString(3),
					rezultat.getInt(4), rezultat.getInt(5), rezultat.getInt(6), rezultat.getInt(7));
			listaPonuda.add(ponuda);
		}
		return listaPonuda;
	}

	public String getNaziv() {
		return naziv;
	}

}
