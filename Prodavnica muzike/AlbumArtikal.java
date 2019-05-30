package treca_nedelja_domaci_tri;

public abstract class AlbumArtikal extends Artikal {
	
	private String izdavac;
	private Album album;
	
	
	
public AlbumArtikal(Album album, String izdavac, double cena, int kol) {
	super(cena, kol);
	this.album = album;
	this.izdavac = izdavac;
	
}

public abstract String ime();

public Album getAlbum() {
	return album;
}

}
