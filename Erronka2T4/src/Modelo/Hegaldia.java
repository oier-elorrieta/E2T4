package Modelo;

public class Hegaldia {
	private String hegaldiIzen;
	private String mota;
	private boolean ibilbide;
	private String portuJatorri;
	private String portuNorako;
	private String dataNorako;
	private String kodeHegaldiNorako;
	private String aerolineaNorako;
	private String horduIrteera;
	private String demboraldiNorako;
	private String dataItzul;
	private String kodeHegaldiItzul;
	private String aerolineaItzul;
	private double prezio;
	private String horduItzul;
	private String demboraldiItzul;

	public Hegaldia(String hegaldiIzen, String mota, boolean ibilbide, String portuJatorri, String portuNorako,
			String dataNorako, String kodeHegaldiNorako, String aerolineaNorako, String horduIrteera, String demboraldiNorako,
			double prezio) {
		this.hegaldiIzen = hegaldiIzen;
		this.mota = mota;
		this.ibilbide = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuNorako = portuNorako;
		this.dataNorako = dataNorako;
		this.kodeHegaldiNorako = kodeHegaldiNorako;
		this.aerolineaNorako = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.demboraldiNorako = demboraldiNorako;
		this.prezio = prezio;
		this.dataItzul = null;
		this.kodeHegaldiItzul = null;
		this.aerolineaItzul = null;
		this.horduItzul = null;
		this.demboraldiItzul = null;
	}


	public Hegaldia(String hegaldiIzen, String mota, boolean ibilbide, String portuJatorri, String portuNorako,
			String dataNorako, String kodeHegaldiNorako, String aerolineaNorako, String horduIrteera, String demboraldiNorako,
			String dataItzul, String kodeHegaldiItzul, String aerolineaItzul, String horduItzul,
			String demboraldiItzul, double prezio) {
		this.hegaldiIzen = hegaldiIzen;
		this.mota = mota;
		this.ibilbide = ibilbide;
		this.portuJatorri = portuJatorri;
		this.portuNorako = portuNorako;
		this.dataNorako = dataNorako;
		this.kodeHegaldiNorako = kodeHegaldiNorako;
		this.aerolineaNorako = aerolineaNorako;
		this.horduIrteera = horduIrteera;
		this.demboraldiNorako = demboraldiNorako;
		this.dataItzul = dataItzul;
		this.kodeHegaldiItzul = kodeHegaldiItzul;
		this.aerolineaItzul = aerolineaItzul;
		this.horduItzul = horduItzul;
		this.demboraldiItzul = demboraldiItzul;
		this.prezio = prezio;
	}

	public String gethegaldiIzen() {
		return hegaldiIzen;
	}

	public void sethegaldiIzen(String hegaldiIzen) {
		this.hegaldiIzen = hegaldiIzen;
	}

	public String getmota() {
		return mota;
	}

	public void setmota(String mota) {
		this.mota = mota;
	}

	public boolean isibilbide() {
		return ibilbide;
	}

	public void setibilbide(boolean ibilbide) {
		this.ibilbide = ibilbide;
	}

	public String getportuJatorri() {
		return portuJatorri;
	}

	public void setportuJatorri(String portuJatorri) {
		this.portuJatorri = portuJatorri;
	}

	public String getportuNorako() {
		return portuNorako;
	}

	public void setportuNorako(String portuNorako) {
		this.portuNorako = portuNorako;
	}

	public String getdataNorako() {
		return dataNorako;
	}

	public void setdataNorako(String dataNorako) {
		this.dataNorako = dataNorako;
	}

	public String getkodeHegaldiNorako() {
		return kodeHegaldiNorako;
	}

	public void setkodeHegaldiNorako(String kodeHegaldiNorako) {
		this.kodeHegaldiNorako = kodeHegaldiNorako;
	}

	public String getaerolineaNorako() {
		return aerolineaNorako;
	}

	public void setaerolineaNorako(String aerolineaNorako) {
		this.aerolineaNorako = aerolineaNorako;
	}

	public String gethorduIrteera() {
		return horduIrteera;
	}

	public void sethorduIrteera(String horduIrteera) {
		this.horduIrteera = horduIrteera;
	}

	public String getdemboraldiNorako() {
		return demboraldiNorako;
	}

	public void setdemboraldiNorako(String demboraldiNorako) {
		this.demboraldiNorako = demboraldiNorako;
	}

	public String getdataItzul() {
		return dataItzul;
	}

	public void setdataItzul(String dataItzul) {
		this.dataItzul = dataItzul;
	}

	public String getkodeHegaldiItzul() {
		return kodeHegaldiItzul;
	}

	public void setkodeHegaldiItzul(String kodeHegaldiItzul) {
		this.kodeHegaldiItzul = kodeHegaldiItzul;
	}

	public String getaerolineaItzul() {
		return aerolineaItzul;
	}

	public void setaerolineaItzul(String aerolineaItzul) {
		this.aerolineaItzul = aerolineaItzul;
	}

	public double getprezio() {
		return prezio;
	}

	public void setprezio(double prezio) {
		this.prezio = prezio;
	}

	public String gethorduItzul() {
		return horduItzul;
	}

	public void sethorduItzul(String horduItzul) {
		this.horduItzul = horduItzul;
	}

	public String getdemboraldiItzul() {
		return demboraldiItzul;
	}

	public void setdemboraldiItzul(String demboraldiItzul) {
		this.demboraldiItzul = demboraldiItzul;
	}

	@Override
	public String toString() {
		return "Vuelo{" + "hegaldiIzen='" + hegaldiIzen + '\'' + ", mota='" + mota + '\'' + ", ibilbide="
				+ (ibilbide ? "Ida y Vuelta" : "Solo Ida") + ", portuJatorri='" + portuJatorri + '\''
				+ ", portuNorako='" + portuNorako + '\'' + ", dataNorako='" + dataNorako + '\'' + ", kodeHegaldiNorako='"
				+ kodeHegaldiNorako + '\'' + ", aerolineaNorako='" + aerolineaNorako + '\'' + ", horduIrteera='" + horduIrteera
				+ '\'' + ", demboraldiNorako='" + demboraldiNorako + '\''
				+ (ibilbide
						? ", dataItzul='" + dataItzul + '\'' + ", kodeHegaldiItzul='" + kodeHegaldiItzul + '\''
								+ ", aerolineaItzul='" + aerolineaItzul + '\'' + ", horduItzul='" + horduItzul
								+ '\'' + ", demboraldiItzul='" + demboraldiItzul + '\''
						: "")
				+ ", prezio=" + prezio + '}';
	}
}
