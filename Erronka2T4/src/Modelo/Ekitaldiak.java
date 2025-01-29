package Modelo;

public class Ekitaldiak {
	private String ekiIzena;
	private String mota;
	private String data;
	private String prezioa;
	
	public Ekitaldiak(String ekiIzena, String mota, String data, String prezioa) {
		this.ekiIzena = ekiIzena;
		this.mota = mota;
		this.data = data;
		this.prezioa = prezioa;
	}
	
	public String getEkiIzena() {
		return ekiIzena;
	}
	
	public void setEkiIzena(String ekiIzena) {
		this.ekiIzena = ekiIzena;
	}
	
	public String getMota() {
		return mota;
	}
	
	public void setMota(String mota) {
		this.mota = mota;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getPrezioa() {
		return prezioa;
	}
	
	public void setPrezioa(String prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "Ekitaldiak [ekiIzena=" + ekiIzena + ", mota=" + mota + ", data=" + data + ", prezioa=" + prezioa + "]";
	}
	
}
