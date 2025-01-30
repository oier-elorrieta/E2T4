package Modelo;

import java.util.Date;

public class Ekitaldiak {
	private String ekiIzena;
	private String mota;
	private Date data;
	private String prezioa;
	
	public Ekitaldiak(String ekiIzena, String mota, Date data, String prezioa) {
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
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
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
