package Modelo;

public class ostatua {
	private String oIzena;
	private String logelaMota;
	private String hiria;
	private String hasiData;
	private String amaituData;
	private double prezioa;

	public ostatua(String izena, String logelaMota, String hiria, String hasiData, String amaituData, double prezioa) {
		this.oIzena = izena;
		this.logelaMota = logelaMota;
		this.hiria = hiria;
		this.hasiData = null;
		this.amaituData = null;
		this.prezioa = prezioa;
	}

	public String getIzena() {
		return oIzena;
	}

	public void setIzena(String izena) {
		this.oIzena = izena;
	}

	public String getLogelaMota() {
		return logelaMota;
	}

	public void setLogelaMota(String logelaMota) {
		this.logelaMota = logelaMota;
	}

	public String getHiria() {
		return hiria;
	}

	public void setHiria(String hiria) {
		this.hiria = hiria;
	}

	public String getHasiData() {
		return hasiData;
	}

	public void setHasiData(String hasiData) {
		this.hasiData = hasiData;
	}

	public String getAmaituData() {
		return amaituData;
	}

	public void setAmaituData(String amaituData) {
		this.amaituData = amaituData;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "ostatua [izena=" + oIzena + ", logelaMota=" + logelaMota + ", hiria=" + hiria + ", hasiData=" + hasiData
				+ ", amaituData=" + amaituData + ", prezioa=" + prezioa + "]";
	}
}
