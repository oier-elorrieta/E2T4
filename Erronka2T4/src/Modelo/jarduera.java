package Modelo;

public class jarduera {
	private String jIzena;
	private String deskribapena;
	private String data;
	private double prezioa;

	public jarduera(String izena, String deskribapena, String data, double prezioa) {
		this.jIzena = izena;
		this.deskribapena = null;
		this.data = null;
		this.prezioa = prezioa;
	}

	public String getjIzena() {
		return jIzena;
	}

	public void setjIzena(String jIzena) {
		this.jIzena = jIzena;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "jarduera [jIzena=" + jIzena + ", deskribapena=" + deskribapena + ", data=" + data + ", prezioa="
				+ prezioa + "]";
	}
}
