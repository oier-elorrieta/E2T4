package Modelo;

import java.util.ArrayList;

public class Agentzia {
	private String aIzena;
	private String markaKolore;
	private String langileKop;
	private String logo;
	private ArrayList<Bidaia> bidaiak;


	public Agentzia(String nombreAgencia, String kolorMarca, String cantidadTrabajadores, String logo, ArrayList<Bidaia> bidaiak) {
		this.aIzena = nombreAgencia;
		this.markaKolore = kolorMarca;
		this.langileKop = cantidadTrabajadores;
		this.logo = logo;
		this.bidaiak = new ArrayList<>();
	}

	

	public String getNombreAgencia() {
		return aIzena;
	}

	public void setNombreAgencia(String nombreAgencia) {
		this.aIzena = nombreAgencia;
	}

	public String getKolorMarca() {
		return markaKolore;
	}

	public void setKolorMarca(String kolorMarca) {
		this.markaKolore = kolorMarca;
	}

	public String getCantidadTrabajadores() {
		return langileKop;
	}

	public void setCantidadTrabajadores(String cantidadTrabajadores) {
		this.langileKop = cantidadTrabajadores;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public ArrayList<Bidaia> getBidaiak() {
		return bidaiak;
	}

	public void setBidaiak(ArrayList<Bidaia> bidaiak) {
		this.bidaiak = bidaiak;
	}
	
	public void gehituBidaia(Bidaia e) {
		this.bidaiak.add(e);
	}
	
	@Override
    public String toString() {
        return "Agencias{" +
                "nombreAgencia='" + aIzena + '\'' +
                ", kolorMarca=" + markaKolore +
                ", cantidadTrabajadores=" + langileKop +
                ", logo='" + logo + '\'' +
                '}';
    }

}
