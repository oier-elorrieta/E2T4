package Modelo;

public class Aireportua {
	private String id_aireportua;
	private String herrialdea;
	private String hiria;

	public Aireportua(String id_aireportua, String herrialdea, String hiria) {
		this.id_aireportua = id_aireportua;
		this.herrialdea = herrialdea;
		this.hiria = hiria;
	}

	public String getId_aireportua() {
		return id_aireportua;
	}

	public void setId_aireportua(String id_aireportua) {
		this.id_aireportua = id_aireportua;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	public String getHiria() {
		return hiria;
	}

	public void setHiria(String hiria) {
		this.hiria = hiria;
	}
}
