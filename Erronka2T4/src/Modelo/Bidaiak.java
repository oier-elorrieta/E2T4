package Modelo;

import java.util.ArrayList;

public class Bidaiak {
	private String bidaia;
	private String mota;
	private int egunak;
	private String hasiData;
	private String amaituData;
	private String herrialde;
	private String deskripzioa;
	private String servNoinc;
	private ArrayList<Zerbitzuak> zerbitzuak;

    public ArrayList<Zerbitzuak> getZerbitzuak() {
		return zerbitzuak;
	}

	public void setZerbituzak(ArrayList<Zerbitzuak> zerbitzuak) {
		this.zerbitzuak = zerbitzuak;
	}

	public Bidaiak() {
    
    }

    public Bidaiak(String viajes, String tipo, int dias, String fechaInicio, String fechaFin, String pais, String desc, String servNoinc, ArrayList<Zerbitzuak> zerbitzuak) {
        this.bidaia = viajes;
        this.mota = tipo;
        this.egunak = dias;
        this.hasiData = fechaInicio;
        this.amaituData = fechaFin;
        this.herrialde = pais;
        this.deskripzioa = desc;
        this.servNoinc = servNoinc;
        this.zerbitzuak = zerbitzuak;
    }

    public String getBidaia() {
        return bidaia;
    }

    public void setBidaia(String viajes) {
        this.bidaia = viajes;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String tipo) {
        this.mota = tipo;
    }

    public int getEgunak() {
        return egunak;
    }

    public void setEgunak(int dias) {
        this.egunak = dias;
    }

    public String getHasiData() {
        return hasiData;
    }

    public void setHasiData(String fechaInicio) {
        this.hasiData = fechaInicio;
    }

    public String getAmaituData() {
        return amaituData;
    }

    public void setAmaituData(String fechaFin) {
        this.amaituData = fechaFin;
    }

    public String getHerrialde() {
        return herrialde;
    }

    public void setHerrialde(String pais) {
        this.herrialde = pais;
    }

    public String getDeskripzioa() {
        return deskripzioa;
    }

    public void setDeskripzioa(String desc) {
        this.deskripzioa = desc;
    }

    public String getServNoinc() {
        return servNoinc;
    }

    public void setServNoinc(String servNoinc) {
        this.servNoinc = servNoinc;
    }

    @Override
    public String toString() {
        return "Bidaia{" +
                "Bidaia='" + bidaia + '\'' +
                ", mota='" + mota + '\'' +
                ", egunak=" + egunak +
                ", hasiData='" + hasiData + '\'' +
                ", amaituData='" + amaituData + '\'' +
                ", herrialde='" + herrialde + '\'' +
                ", deskipzioa='" + deskripzioa + '\'' +
                ", servNoinc='" + servNoinc + '\'' +
                '}';
    }
}
