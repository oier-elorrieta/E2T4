package Modelo;

import java.util.Date;

public class Zerbitzua {
	private int zerbitzu_id;

	private String hegaldiIzen;
	private String hMota;
	private boolean joanEtorri;
	private String portuJatorri;
	private String portuHelmuga;
	private Date dataJoan;
	private String aerolineaJoan;
	private String horduIrteera;
	private String iraupenJoan;
	private Date dataItzul;
	private String kodeHegaldiItzul;
	private String aerolineaItzul;
	private double prezio;
	private String horduItzul;
	private double iraupenItzuli;

	private String ekiIzena;
	private String eMota;
	private Date data;
	private String ePrezioa;

	private String oIzena;
	private String logelaMota;
	private String hiria;
	private String hasiData;
	private String amaituData;
	private double oPrezioa;

	public Zerbitzua(int zerbitzu_id, String hegaldiIzen, String hMota, boolean ibilbide, String portuJatorri, String portuJoan,
			Date dataJoan, String aerolineaNorako, String horduIrteera, String demboraldiNorako, Date dataItzul,
			String kodeHegaldiItzul, String aerolineaItzul, double prezio, String horduItzul, double iraupenItzuli,
			String ekiIzena, String eMota, Date data, String ePrezioa, String oIzena, String logelaMota, String hiria,
			String hasiData, String amaituData, double oPrezioa) {
		this.zerbitzu_id = zerbitzu_id;
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.joanEtorri = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuHelmuga = portuJoan;
		this.dataJoan = dataJoan;
		this.aerolineaJoan = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.iraupenJoan = demboraldiNorako;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.prezio = prezio;
		this.horduItzul = horduItzul;
		this.iraupenItzuli = iraupenItzuli;
		this.ekiIzena = ekiIzena;
		this.eMota = eMota;
		this.data = data;
		this.ePrezioa = ePrezioa;
		this.oIzena = oIzena;
		this.logelaMota = logelaMota;
		this.hiria = hiria;
		this.hasiData = hasiData;
		this.amaituData = amaituData;
		this.oPrezioa = oPrezioa;
	}

	public Zerbitzua(int zerbitzu_id, String hegaldiIzen, String hMota, boolean ibilbide, String portuJatorri, String portuJoan,
			Date dataJoan, String aerolineaNorako, String horduIrteera,
			String demboraldiNorako, double prezio) {
		this.zerbitzu_id = zerbitzu_id;
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.joanEtorri = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuHelmuga = portuJoan;
		this.dataJoan = dataJoan;
		this.aerolineaJoan = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.iraupenJoan = demboraldiNorako;
		this.prezio = prezio;
	}

	public Zerbitzua(int zerbitzu_id, String hegaldiIzen, String hMota, boolean ibilbide, String portuJatorri, String portuNorako,
			Date dataNorako, String kodeHegaldiNorako, String aerolineaNorako, String horduIrteera,
			String demboraldiNorako, Date dataItzul, String kodeHegaldiItzul, String aerolineaItzul, double prezio,
			String horduItzul, double iraupenItzuli) {
		this.zerbitzu_id = zerbitzu_id;
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.joanEtorri = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuHelmuga = portuNorako;
		this.dataJoan = dataNorako;
		this.aerolineaJoan = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.iraupenJoan = demboraldiNorako;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.prezio = prezio;
		this.horduItzul = horduItzul;
		this.iraupenItzuli = iraupenItzuli;
	}

	public Zerbitzua(int zerbitzu_id, String ekiIzena, String eMota, Date data, String ePrezioa) {
		this.zerbitzu_id = zerbitzu_id;
		this.ekiIzena = ekiIzena;
		this.eMota = eMota;
		this.data = data;
		this.ePrezioa = ePrezioa;
	}

	public Zerbitzua(int zerbitzu_id, String oIzena, String logelaMota, String hiria, String hasiData, String amaituData,
			double oPrezioa) {
		this.zerbitzu_id = zerbitzu_id;
		this.oIzena = oIzena;
		this.logelaMota = logelaMota;
		this.hiria = hiria;
		this.hasiData = hasiData;
		this.amaituData = amaituData;
		this.oPrezioa = oPrezioa;
	}
	
	public int getZerbitzu_id() {
		return zerbitzu_id;
	}
	
	public void setZerbitzu_id(int zerbitzu_id) {
		this.zerbitzu_id = zerbitzu_id;
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

	public boolean isIbilbide() {
		return joanEtorri;
	}

	public void setIbilbide(boolean ibilbide) {
		this.joanEtorri = ibilbide;
	}

	public String getPortuJatorri() {
		return portuJatorri;
	}

	public void setPortuJatorri(String portuJatorri) {
		this.portuJatorri = portuJatorri;
	}

	public String getPortuNorako() {
		return portuHelmuga;
	}

	public void setPortuNorako(String portuNorako) {
		this.portuHelmuga = portuNorako;
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

	public String getHorduIrteera() {
		return horduIrteera;
	}

	public void setHorduIrteera(String horduIrteera) {
		this.horduIrteera = horduIrteera;
	}

	public String getDemboraldiNorako() {
		return iraupenJoan;
	}

	public void setDemboraldiNorako(String demboraldiNorako) {
		this.iraupenJoan = demboraldiNorako;
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

	public String getHorduItzul() {
		return horduItzul;
	}

	public void setHorduItzul(String horduItzul) {
		this.horduItzul = horduItzul;
	}

	public double getIraupenItzuli() {
		return iraupenItzuli;
	}

	public void setDemboraldiItzul(double iraupenItzuli) {
		this.iraupenItzuli = iraupenItzuli;
	}

	public String getEkiIzena() {
		return ekiIzena;
	}

	public void setEkiIzena(String ekiIzena) {
		this.ekiIzena = ekiIzena;
	}

	public String geteMota() {
		return eMota;
	}

	public void seteMota(String eMota) {
		this.eMota = eMota;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getePrezioa() {
		return ePrezioa;
	}

	public void setePrezioa(String ePrezioa) {
		this.ePrezioa = ePrezioa;
	}

	public String getoIzena() {
		return oIzena;
	}

	public void setoIzena(String oIzena) {
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

	public double getoPrezioa() {
		return oPrezioa;
	}

	public void setoPrezioa(double oPrezioa) {
		this.oPrezioa = oPrezioa;
	}
}
