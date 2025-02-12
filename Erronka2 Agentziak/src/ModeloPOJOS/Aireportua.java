package ModeloPOJOS;

public class Aireportua {
	private String id_aireportua;
	private String hiria;

	public Aireportua(String id_aireportua, String hiria) {
		this.id_aireportua = id_aireportua;
		this.hiria = hiria;
	}

	public String getId_aireportua() {
		return id_aireportua;
	}

	public void setId_aireportua(String id_aireportua) {
		this.id_aireportua = id_aireportua;
	}

	public String getHiria() {
		return hiria;
	}

	public void setHiria(String hiria) {
		this.hiria = hiria;
	}
}
