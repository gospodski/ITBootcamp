package sesta_nedelja_domaci_prvi;

import java.sql.*;

public class Ponuda {

	private int idTerm;
	private String naziv;
	private String drzava;
	private int datumOd;
	private int datumDo;
	private int preostaloMesta;
	private int cena;

	public Ponuda(int id, String naziv, String drzava, int datumOd, int datumDo, int cena, int mesta) {
		idTerm = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.cena = cena;
		preostaloMesta = mesta;
	}

	public boolean zakupi() {
		if (preostaloMesta > 0) {
			try (Connection connection = DriverManager.getConnection(Agencija.url)) {
				String upit = "UPDATE Termin SET PreostaloMesta = PreostaloMesta - 1 WHERE idTer = " + idTerm;
				Statement stm = connection.createStatement();
				stm.executeUpdate(upit);
				stm.close();
			} catch (Exception e) {

			}
			return true;
		} else
			return false;
	}

	public String toString() {
		String str = "(" + idTerm + ") " + naziv + "(" + drzava + ") " + datumOd + " - " + datumDo + " / " + cena
				+ "€ : " + preostaloMesta;
		return str;
	}

}
