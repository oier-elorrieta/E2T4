package Modelo;

import java.sql.Time;
import java.util.Date;

public class Zerbitzua {
	private int bidaia_id;
	private int zerbitzu_id;

	private int hegaldi_id;
	private String hegaldiIzen;
	private String hMota;
	private String portuJatorri;
	private String portuHelmuga;
	private Date dataJoan;
	private String aerolineaJoan;
	private Time orduIrteera;
	private int iraupenJoan;
	private Date dataItzul;
	private String kodeHegaldiItzul;
	private String aerolineaItzul;
	private double prezio;
	private Time horduItzul;
	private int iraupenItzuli;

	private int jarduera_id;
	private String jarduera_izena;
	private String jarduera_desk;
	private Date jarduera_data;
	private double jarduera_prezioa;

	private int ostatu_id;
	private String oIzena;
	private String logelaMota;
	private String hiria;
	private Date hasiData;
	private Date amaituData;
	private double oPrezioa;
	
	public Zerbitzua(int bidaia_id, int zerbitzu_id, int hegaldi_id, int ekitaldi_id, int ostatu_id, String hegaldiIzen, String hMota, String portuJatorri, String portuJoan,
			Date dataJoan, String aerolineaNorako, Time horduIrteera, int iraupenJoan, Date dataItzul,
			String kodeHegaldiItzul, String aerolineaItzul, double prezio, Time horduItzul, int iraupenItzuli,
			String ekiIzena, String jarduera_desk, Date data, double ePrezioa, String oIzena, String logelaMota, String hiria,
			Date hasiData, Date amaituData, double oPrezioa) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.hegaldi_id = hegaldi_id;
		this.jarduera_id = ekitaldi_id;
		this.ostatu_id = ostatu_id;
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.portuJatorri = portuJatorri;
		this.portuHelmuga = portuJoan;
		this.dataJoan = dataJoan;
		this.aerolineaJoan = aerolineaNorako;
		this.orduIrteera = horduIrteera;
		this.iraupenJoan = iraupenJoan;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.prezio = prezio;
		this.horduItzul = horduItzul;
		this.iraupenItzuli = iraupenItzuli;
		this.jarduera_izena = ekiIzena;
		this.jarduera_desk = jarduera_desk;
		this.jarduera_data = data;
		this.jarduera_prezioa = ePrezioa;
		this.oIzena = oIzena;
		this.logelaMota = logelaMota;
		this.hiria = hiria;
		this.hasiData = hasiData;
		this.amaituData = amaituData;
		this.oPrezioa = oPrezioa;
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, int hegaldi_id, String hegaldiIzen, String hMota, String portuJatorri, String portuHelmuga,
			Date dataJoan, String aerolineaJoan, Time horduIrteera,
			int iraupenJoan, double prezio) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.hegaldi_id = hegaldi_id;
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.portuJatorri = portuJatorri;
		this.portuHelmuga = portuHelmuga;
		this.dataJoan = dataJoan;
		this.aerolineaJoan = aerolineaJoan;
		this.orduIrteera = horduIrteera;
		this.iraupenJoan = iraupenJoan;
		this.prezio = prezio;
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, int hegaldi_id, String hegaldiIzen, String hMota, String portuJatorri, String portuNorako,
			Date dataNorako, String aerolineaNorako, Time orduIrteera,
			int iraupenJoan, Date dataItzul, String kodeHegaldiItzul, String aerolineaItzul, double prezio,
			Time horduItzul, int iraupenItzuli) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.hegaldi_id = hegaldi_id;
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.portuJatorri = portuJatorri;
		this.portuHelmuga = portuNorako;
		this.dataJoan = dataNorako;
		this.aerolineaJoan = aerolineaNorako;
		this.orduIrteera = orduIrteera;
		this.iraupenJoan = iraupenJoan;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.prezio = prezio;
		this.horduItzul = horduItzul;
		this.iraupenItzuli = iraupenItzuli;
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, int ekitaldi_id, String ekiIzena, String jarduera_desk, Date data, double ePrezioa) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.jarduera_id = ekitaldi_id;
		this.jarduera_izena = ekiIzena;
		this.jarduera_desk = jarduera_desk;
		this.jarduera_data = data;
		this.jarduera_prezioa = ePrezioa;
	}

	public Zerbitzua(int bidaia_id, int zerbitzu_id, int ostatu_id, String oIzena, String logelaMota, String hiria, Date hasiData, Date amaituData,
			double oPrezioa) {
		this.bidaia_id = bidaia_id;
		this.zerbitzu_id = zerbitzu_id;
		this.ostatu_id = ostatu_id;
		this.oIzena = oIzena;
		this.logelaMota = logelaMota;
		this.hiria = hiria;
		this.hasiData = hasiData;
		this.amaituData = amaituData;
		this.oPrezioa = oPrezioa;
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
	
	public int getHegaldiId() {
		return hegaldi_id;
	}
	
	public void setHegaldiId(int hegaldi_id) {
		this.hegaldi_id = hegaldi_id;
	}

	public String getHegaldiIzen() {
		return hegaldiIzen;
	}

	public void setHegaldiIzen(String hegaldiIzen) {
		this.hegaldiIzen = hegaldiIzen;
	}

	public String gethMota() {
		return hMota;
	}

	public void sethMota(String hMota) {
		this.hMota = hMota;
	}

	public String getPortuJatorri() {
		return portuJatorri;
	}

	public void setPortuJatorri(String portuJatorri) {
		this.portuJatorri = portuJatorri;
	}

	public String getPortuHelmuga() {
		return portuHelmuga;
	}

	public void setPortuHelmuga(String portuHelmuga) {
		this.portuHelmuga = portuHelmuga;
	}

	public Date getDataNorako() {
		return dataJoan;
	}

	public void setDataNorako(Date dataNorako) {
		this.dataJoan = dataNorako;
	}

	public String getAerolineaNorako() {
		return aerolineaJoan;
	}

	public void setAerolineaNorako(String aerolineaNorako) {
		this.aerolineaJoan = aerolineaNorako;
	}

	public Time getHorduIrteera() {
		return orduIrteera;
	}

	public void setHorduIrteera(Time horduIrteera) {
		this.orduIrteera = horduIrteera;
	}

	public int getIraupenJoan() {
		return iraupenJoan;
	}

	public void setIraupenJoan(int iraupenJoan) {
		this.iraupenJoan = iraupenJoan;
	}

	public Date getDataItzul() {
		return dataItzul;
	}

	public void setDataItzul(Date dataItzul) {
		this.dataItzul = dataItzul;
	}

	public String getKodeHegaldiItzul() {
		return kodeHegaldiItzul;
	}

	public void setKodeHegaldiItzul(String kodeHegaldiItzul) {
		this.kodeHegaldiItzul = kodeHegaldiItzul;
	}

	public String getAerolineaItzul() {
		return aerolineaItzul;
	}

	public void setAerolineaItzul(String aerolineaItzul) {
		this.aerolineaItzul = aerolineaItzul;
	}

	public double getPrezio() {
		return prezio;
	}

	public void setPrezio(double prezio) {
		this.prezio = prezio;
	}

	public Time getHorduItzul() {
		return horduItzul;
	}

	public void setHorduItzul(Time horduItzul) {
		this.horduItzul = horduItzul;
	}

	public int getIraupenItzuli() {
		return iraupenItzuli;
	}

	public void setIraupenItzul(int iraupenItzuli) {
		this.iraupenItzuli = iraupenItzuli;
	}

	public int getEkitaldi_id() {
		return jarduera_id;
	}
	
	public void setEkitaldi_id(int ekitaldi_id) {
		this.jarduera_id = ekitaldi_id;
	}
	
	public String getEkiIzena() {
		return jarduera_izena;
	}

	public void setEkiIzena(String ekiIzena) {
		this.jarduera_izena = ekiIzena;
	}

	public String geteMota() {
		return jarduera_desk;
	}

	public void seteMota(String eMota) {
		this.jarduera_desk = eMota;
	}

	public Date getData() {
		return jarduera_data;
	}

	public void setData(Date data) {
		this.jarduera_data = data;
	}

	public double getePrezioa() {
		return jarduera_prezioa;
	}

	public void setePrezioa(double ePrezioa) {
		this.jarduera_prezioa = ePrezioa;
	}

	public int getOstatu_id() {
		return ostatu_id;
	}
	
	public void setOstatu_id(int ostatu_id) {
		this.ostatu_id = ostatu_id;
	}
	
	public String getOIzena() {
		return oIzena;
	}

	public void setOIzena(String oIzena) {
		this.oIzena = oIzena;
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

	public Date getHasiData() {
		return hasiData;
	}

	public void setHasiData(Date hasiData) {
		this.hasiData = hasiData;
	}

	public Date getAmaituData() {
		return amaituData;
	}

	public void setAmaituData(Date amaituData) {
		this.amaituData = amaituData;
	}

	public double getoPrezioa() {
		return oPrezioa;
	}

	public void setoPrezioa(double oPrezioa) {
		this.oPrezioa = oPrezioa;
	}
}
