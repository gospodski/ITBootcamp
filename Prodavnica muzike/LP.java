package treca_nedelja_domaci_tri;

public class LP extends AlbumArtikal {

	private int tezina;
	
	
	
public LP(Album album, String izdavac, double cena, int kol, int tezina) {
		super(album, izdavac, cena, kol);
		this.tezina = tezina;
	}



@Override
public String ime() {
	String ispis = super.getAlbum().getIzvodjac() + " - " + super.getAlbum().getNaziv() + " (" + tezina + "g LP)";
	return ispis;
}


	
	

}
