package Modelo;

public class Herrialdea {
	private String izena;
	private String kontinentea;
	private String aireportua;
	private String kapitala;
	
	public Herrialdea(String izena, String kontinentea, String aireportua, String kapitala) {
		this.izena = izena;
		this.kontinentea = kontinentea;
		this.aireportua = aireportua;
		this.kapitala = kapitala;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getKontinentea() {
		return kontinentea;
	}

	public void setKontinentea(String kontinentea) {
		this.kontinentea = kontinentea;
	}

	public String getAireportua() {
		return aireportua;
	}

	public void setAireportua(String aireportua) {
		this.aireportua = aireportua;
	}

	public String getKapitala() {
		return kapitala;
	}

	public void setKapitala(String kapitala) {
		this.kapitala = kapitala;
	}

	@Override
	public String toString() {
		return "Herriak [izena=" + izena + ", kontinentea=" + kontinentea + ", aireportua=" + aireportua + ", kapitala="
				+ kapitala + "]";
	}
	
}
