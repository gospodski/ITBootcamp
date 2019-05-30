package treca_nedelja_domaci_tri;

public class CD extends AlbumArtikal {

	
	
public CD(Album album, String izdavac, double cena, int kol) {
		super(album, izdavac, cena, kol);
		
	}

public String ime() {
	String ispis = super.getAlbum().getIzvodjac() + " - " + super.getAlbum().getNaziv() + " (CD)";
	return ispis;
}

}
