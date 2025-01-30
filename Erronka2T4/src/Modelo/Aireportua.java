package Modelo;

public class Aireportua {
	private String id_aireportua;
	private String herrialde_kod;
	private String hiria;

	public Aireportua(String id_aireportua, String herrialde_kod, String hiria) {
		this.id_aireportua = id_aireportua;
		this.herrialde_kod = herrialde_kod;
		this.hiria = hiria;
	}

	public String getId_aireportua() {
		return id_aireportua;
	}

	public void setId_aireportua(String id_aireportua) {
		this.id_aireportua = id_aireportua;
	}

	public String getHerrialde_kod() {
		return herrialde_kod;
	}

	public void setHerrialde_kod(String herrialdea) {
		this.herrialde_kod = herrialdea;
	}

	public String getHiria() {
		return hiria;
	}

	public void setHiria(String hiria) {
		this.hiria = hiria;
	}
}
