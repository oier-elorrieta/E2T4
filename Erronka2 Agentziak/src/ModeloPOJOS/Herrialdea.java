package ModeloPOJOS;

public class Herrialdea {
	private String herrialde_kod;
	private String izena;
	
	public Herrialdea(String izena, String herrialde_kod) {
		this.izena = izena;
		this.herrialde_kod = herrialde_kod;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	public String getHerrialde_kod() {
		return herrialde_kod;
	}
	
	public void setHerrialde_kod(String herrialde_kod) {
		this.herrialde_kod = herrialde_kod;
	}

	@Override
	public String toString() {
		return "Herriak [izena=" + izena + ", kontinentea=" + ", aireportua=" + ", kapitala="
				+ herrialde_kod + "]";
	}
}
