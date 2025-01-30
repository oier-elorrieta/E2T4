package Modelo;

import java.util.Date;

public class Zerbitzua {
	private String hegaldiIzen;
	private String hMota;
	private boolean ibilbide;
	private String portuJatorri;
	private String portuJoan;
	private Date dataJoan;
	private String kodeHegaldiNorako;
	private String aerolineaNorako;
	private String horduIrteera;
	private String demboraldiNorako;
	private Date dataItzul;
	private String kodeHegaldiItzul;
	private String aerolineaItzul;
	private double prezio;
	private String horduItzul;
	private String demboraldiItzul;

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

	public Zerbitzua(String hegaldiIzen, String hMota, boolean ibilbide, String portuJatorri, String portuJoan,
			Date dataJoan, String kodeHegaldiNorako, String aerolineaNorako, String horduIrteera,
			String demboraldiNorako, Date dataItzul, String kodeHegaldiItzul, String aerolineaItzul, double prezio,
			String horduItzul, String demboraldiItzul, String ekiIzena, String eMota, Date data, String ePrezioa,
			String oIzena, String logelaMota, String hiria, String hasiData, String amaituData, double oPrezioa) {
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.ibilbide = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuJoan = portuJoan;
		this.dataJoan = dataJoan;
		this.kodeHegaldiNorako = kodeHegaldiNorako;
		this.aerolineaNorako = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.demboraldiNorako = demboraldiNorako;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.prezio = prezio;
		this.horduItzul = horduItzul;
		this.demboraldiItzul = demboraldiItzul;
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

	public Zerbitzua(String hegaldiIzen, String hMota, boolean ibilbide, String portuJatorri, String portuJoan,
			Date dataJoan, String kodeHegaldiNorako, String aerolineaNorako, String horduIrteera,
			String demboraldiNorako, double prezio) {
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.ibilbide = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuJoan = portuJoan;
		this.dataJoan = dataJoan;
		this.kodeHegaldiNorako = kodeHegaldiNorako;
		this.aerolineaNorako = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.demboraldiNorako = demboraldiNorako;
		this.prezio = prezio;
	}

	public Zerbitzua(String hegaldiIzen, String hMota, boolean ibilbide, String portuJatorri, String portuNorako,
			Date dataNorako, String kodeHegaldiNorako, String aerolineaNorako, String horduIrteera,
			String demboraldiNorako, Date dataItzul, String kodeHegaldiItzul, String aerolineaItzul, double prezio,
			String horduItzul, String demboraldiItzul) {
		this.hegaldiIzen = hegaldiIzen;
		this.hMota = hMota;
		this.ibilbide = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuJoan = portuNorako;
		this.dataJoan = dataNorako;
		this.kodeHegaldiNorako = kodeHegaldiNorako;
		this.aerolineaNorako = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.demboraldiNorako = demboraldiNorako;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.prezio = prezio;
		this.horduItzul = horduItzul;
		this.demboraldiItzul = demboraldiItzul;
	}

	public Zerbitzua(String ekiIzena, String eMota, Date data, String ePrezioa) {
		this.ekiIzena = ekiIzena;
		this.eMota = eMota;
		this.data = data;
		this.ePrezioa = ePrezioa;
	}

	public Zerbitzua(String oIzena, String logelaMota, String hiria, String hasiData, String amaituData,
			double oPrezioa) {
		this.oIzena = oIzena;
		this.logelaMota = logelaMota;
		this.hiria = hiria;
		this.hasiData = hasiData;
		this.amaituData = amaituData;
		this.oPrezioa = oPrezioa;
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
		return ibilbide;
	}

	public void setIbilbide(boolean ibilbide) {
		this.ibilbide = ibilbide;
	}

	public String getPortuJatorri() {
		return portuJatorri;
	}

	public void setPortuJatorri(String portuJatorri) {
		this.portuJatorri = portuJatorri;
	}

	public String getPortuNorako() {
		return portuJoan;
	}

	public void setPortuNorako(String portuNorako) {
		this.portuJoan = portuNorako;
	}

	public Date getDataNorako() {
		return dataJoan;
	}

	public void setDataNorako(Date dataNorako) {
		this.dataJoan = dataNorako;
	}

	public String getKodeHegaldiNorako() {
		return kodeHegaldiNorako;
	}

	public void setKodeHegaldiNorako(String kodeHegaldiNorako) {
		this.kodeHegaldiNorako = kodeHegaldiNorako;
	}

	public String getAerolineaNorako() {
		return aerolineaNorako;
	}

	public void setAerolineaNorako(String aerolineaNorako) {
		this.aerolineaNorako = aerolineaNorako;
	}

	public String getHorduIrteera() {
		return horduIrteera;
	}

	public void setHorduIrteera(String horduIrteera) {
		this.horduIrteera = horduIrteera;
	}

	public String getDemboraldiNorako() {
		return demboraldiNorako;
	}

	public void setDemboraldiNorako(String demboraldiNorako) {
		this.demboraldiNorako = demboraldiNorako;
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

	public String getDemboraldiItzul() {
		return demboraldiItzul;
	}

	public void setDemboraldiItzul(String demboraldiItzul) {
		this.demboraldiItzul = demboraldiItzul;
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
