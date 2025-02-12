package ModeloPOJOS;

import java.sql.Time;
import java.util.Date;

public class Zerbitzua {
	private int bidaia_id;
	private int zerbitzu_id;
	private String zerbitzu_mota;
	private Date zerbitzu_data;
	private double zerbitzu_prezioa;
	private String zerbitzu_izena;
	
	private int hegaldi_kod_joan;
	private Time orduIrteera;
	private int iraupen_joan;
	private String iata_kod_jatorri;
	private String iata_kod_helmuga;
	private String airelinea_kod;
	
	private int hegaldi_kod_itzuli;
	private String aerolineaItzul;
	
	
	private Time orduItzul;
	private int iraupenItzuli;
	
	private String jarduera_desk;
	
	private String logela_mota_kod;
	private String hiria;
	private Date amaiera_data;
	
	public Zerbitzua(int bidaia_id, int zerbitzu_id, int hegaldi_kod_joan, String zerbitzu_izena, Time orduIrteera,
			Date dataJoan, int iraupen_joan, double prezioa_joan, String iata_kod_jatorri, String iata_kod_helmuga, String airelinea_kod) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.zerbitzu_mota = "hegaldia";
		this.hegaldi_kod_joan = hegaldi_kod_joan;
		this.zerbitzu_izena = zerbitzu_izena;
		this.orduIrteera = orduIrteera;
		this.zerbitzu_data = dataJoan;
		this.iraupen_joan = iraupen_joan;
		this.zerbitzu_prezioa = prezioa_joan;
		this.iata_kod_jatorri = iata_kod_jatorri;
		this.iata_kod_helmuga = iata_kod_helmuga;
		this.airelinea_kod = airelinea_kod;
		
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, int hegaldi_kod_itzuli, Date dataItzul, String aerolineaItzul, double prezio, Time orduItzul, int iraupenItzuli) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.zerbitzu_mota = "hegaldia";
		this.hegaldi_kod_itzuli = hegaldi_kod_itzuli;
		this.zerbitzu_data=dataItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.zerbitzu_prezioa = prezio;
		this.orduItzul = orduItzul;
		this.iraupenItzuli = iraupenItzuli;
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, String ostatu_izena, String logela_mota_kod, String hiria, Date hasiera_data, Date amaiera_data, double ostatu_prezioa) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.zerbitzu_mota = "ostatua";
		this.zerbitzu_izena = ostatu_izena;
		this.logela_mota_kod = logela_mota_kod;
		this.hiria = hiria;
		this.zerbitzu_data = hasiera_data;
		this.amaiera_data = amaiera_data;
		this.zerbitzu_prezioa = ostatu_prezioa;
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, String jarduera_izena, String jarduera_desk, Date jarduera_data, double jarduera_prezioa) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.zerbitzu_mota = "jarduera";
		this.zerbitzu_izena = jarduera_izena;
		this.jarduera_desk = jarduera_desk;
		this.zerbitzu_data = jarduera_data;
		this.zerbitzu_prezioa = jarduera_prezioa;
	}
	
	public int getBidaia_id() {
		return bidaia_id;
	}
	
	public void setBidaia_id(int bidaia_id) {
		this.bidaia_id = bidaia_id;
	}

	public int getZerbitzu_id() {
		return zerbitzu_id;
	}

	public void setZerbitzu_id(int zerbitzu_id) {
		this.zerbitzu_id = zerbitzu_id;
	}

	public String getZerbitzu_mota() {
		return zerbitzu_mota;
	}

	public void setZerbitzu_mota(String zerbitzu_mota) {
		this.zerbitzu_mota = zerbitzu_mota;
	}
	
	public Date getZerbitzu_data() {
		return zerbitzu_data;
	}

	public void setZerbitzu_data(Date zerbitzu_data) {
		this.zerbitzu_data = zerbitzu_data;
	}
	
	public double getZerbitzu_prezioa() {
		return zerbitzu_prezioa;
	}
	
	public void setZerbitzu_prezioa(double zerbitzu_prezioa) {
		this.zerbitzu_prezioa = zerbitzu_prezioa;
	}
	
	public String getZerbitzu_izena() {
		return zerbitzu_izena;
	}
	
	public void setZerbitzu_izena(String zerbitzu_izena) {
		this.zerbitzu_izena = zerbitzu_izena;
	}

	public int getHegaldi_kod_joan() {
		return hegaldi_kod_joan;
	}

	public void setHegaldi_kod_joan(int hegaldi_kod_joan) {
		this.hegaldi_kod_joan = hegaldi_kod_joan;
	}

	public Time getOrduIrteera() {
		return orduIrteera;
	}

	public void setOrduIrteera(Time orduIrteera) {
		this.orduIrteera = orduIrteera;
	}

	public int getIraupen_joan() {
		return iraupen_joan;
	}

	public void setIraupen_joan(int iraupen_joan) {
		this.iraupen_joan = iraupen_joan;
	}

	public String getIata_kod_jatorri() {
		return iata_kod_jatorri;
	}

	public void setIata_kod_jatorri(String iata_kod_jatorri) {
		this.iata_kod_jatorri = iata_kod_jatorri;
	}

	public String getIata_kod_helmuga() {
		return iata_kod_helmuga;
	}

	public void setIata_kod_helmuga(String iata_kod_helmuga) {
		this.iata_kod_helmuga = iata_kod_helmuga;
	}

	public String getAirelinea_kod() {
		return airelinea_kod;
	}

	public void setAirelinea_kod(String airelinea_kod) {
		this.airelinea_kod = airelinea_kod;
	}

	public int getHegaldi_kod_itzuli() {
		return hegaldi_kod_itzuli;
	}

	public void setHegaldi_kod_itzuli(int hegaldi_kod_itzuli) {
		this.hegaldi_kod_itzuli = hegaldi_kod_itzuli;
	}

	public String getAerolineaItzul() {
		return aerolineaItzul;
	}

	public void setAerolineaItzul(String aerolineaItzul) {
		this.aerolineaItzul = aerolineaItzul;
	}

	public Time getOrduItzul() {
		return orduItzul;
	}

	public void setOrduItzul(Time orduItzul) {
		this.orduItzul = orduItzul;
	}

	public int getIraupenItzuli() {
		return iraupenItzuli;
	}

	public void setIraupenItzuli(int iraupenItzuli) {
		this.iraupenItzuli = iraupenItzuli;
	}

	public String getJarduera_desk() {
		return jarduera_desk;
	}

	public void setJarduera_desk(String jarduera_desk) {
		this.jarduera_desk = jarduera_desk;
	}

	public String getLogela_mota_kod() {
		return logela_mota_kod;
	}

	public void setLogela_mota_kod(String logela_mota_kod) {
		this.logela_mota_kod = logela_mota_kod;
	}

	public String getHiria() {
		return hiria;
	}

	public void setHiria(String hiria) {
		this.hiria = hiria;
	}

	public Date getAmaiera_data() {
		return amaiera_data;
	}

	public void setAmaiera_data(Date amaiera_data) {
		this.amaiera_data = amaiera_data;
	}
	
	@Override
	public String toString() {
		return "Zerbitzua [bidaia_id=" + bidaia_id + ", zerbitzu_id=" + zerbitzu_id + ", zerbitzu_mota=" + zerbitzu_mota + ", zerbitzu_data="
				+ zerbitzu_data + ", zerbitzu_prezioa=" + zerbitzu_prezioa + ", zerbitzu_izena=" + zerbitzu_izena
				+ ", hegaldi_kod_joan=" + hegaldi_kod_joan + ", orduIrteera=" + orduIrteera + ", iraupen_joan="
				+ iraupen_joan + ", iata_kod_jatorri=" + iata_kod_jatorri + ", iata_kod_helmuga=" + iata_kod_helmuga
				+ ", airelinea_kod=" + airelinea_kod + ", hegaldi_kod_itzuli=" + hegaldi_kod_itzuli
				+ ", aerolineaItzul=" + aerolineaItzul + ", orduItzul=" + orduItzul + ", iraupenItzuli=" + iraupenItzuli
				+ ", jarduera_desk=" + jarduera_desk + ", logela_mota_kod=" + logela_mota_kod + ", hiria=" + hiria
				+ ", amaiera_data=" + amaiera_data + "]";
	}
	
}