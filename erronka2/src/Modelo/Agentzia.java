package Modelo;

import java.util.ArrayList;

public class Agentzia {
	private int agentzia_id;
	private String erabiltzailea;
	private String pasahitza;
	private String deskripzioa;
	private String logo;
	private String kolorea;
	private String langileKop;
	private String agentzia_mota_kod;

	private ArrayList<Bidaia> bidaiak;

	

	public Agentzia(int agentzia_id, String erabiltzailea, String pasahitza, String deskripzioa, String logo,
			String kolorea, String langileKop, String agentzia_mota_kod, ArrayList<Bidaia> bidaiak) {
		this.agentzia_id = agentzia_id;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.deskripzioa = deskripzioa;
		this.logo = logo;
		this.kolorea = kolorea;
		this.langileKop = langileKop;
		this.agentzia_mota_kod = agentzia_mota_kod;
		this.bidaiak = bidaiak;
	}

	public int getAgentzia_id() {
		return agentzia_id;
	}

	public void setAgentzia_id(int agentzia_id) {
		this.agentzia_id = agentzia_id;
	}

	public String getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getDeskripzioa() {
		return deskripzioa;
	}

	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getKolorea() {
		return kolorea;
	}

	public void setKolorea(String kolorea) {
		this.kolorea = kolorea;
	}

	public String getLangileKop() {
		return langileKop;
	}

	public void setLangileKop(String langileKop) {
		this.langileKop = langileKop;
	}

	public String getAgentzia_mota_kod() {
		return agentzia_mota_kod;
	}

	public void setAgentzia_mota_kod(String agentzia_mota_kod) {
		this.agentzia_mota_kod = agentzia_mota_kod;
	}

	public ArrayList<Bidaia> getBidaiak() {
		return bidaiak;
	}

	public void setBidaiak(ArrayList<Bidaia> bidaiak) {
		this.bidaiak = bidaiak;
	}

	@Override
	public String toString() {
		return "Agentzia [agentzia_id=" + agentzia_id + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza
				+ ", deskripzioa=" + deskripzioa + ", logo=" + logo + ", kolorea=" + kolorea + ", langileKop="
				+ langileKop + ", agentzia_mota_kod=" + agentzia_mota_kod + ", bidaiak=" + bidaiak + "]";
	}

}
