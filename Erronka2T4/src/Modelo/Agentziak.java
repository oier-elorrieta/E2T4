package Modelo;

import java.util.ArrayList;

public class Agentziak {
	private String nombreAgencia;
	private String kolorMarca;
	private String cantidadTrabajadores;
	private String logo;
	private ArrayList<Bidaiak> bidaiak;


	public Agentziak(String nombreAgencia, String kolorMarca, String cantidadTrabajadores, String logo, ArrayList<Bidaiak> bidaiak) {
		this.nombreAgencia = nombreAgencia;
		this.kolorMarca = kolorMarca;
		this.cantidadTrabajadores = cantidadTrabajadores;
		this.logo = logo;
		this.bidaiak = bidaiak;
	}

	public ArrayList<Bidaiak> getBidaiak() {
		return bidaiak;
	}

	public void setBidaiak(ArrayList<Bidaiak> bidaiak) {
		this.bidaiak = bidaiak;
	}

	public String getNombreAgencia() {
		return nombreAgencia;
	}

	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}

	public String getKolorMarca() {
		return kolorMarca;
	}

	public void setKolorMarca(String kolorMarca) {
		this.kolorMarca = kolorMarca;
	}

	public String getCantidadTrabajadores() {
		return cantidadTrabajadores;
	}

	public void setCantidadTrabajadores(String cantidadTrabajadores) {
		this.cantidadTrabajadores = cantidadTrabajadores;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Override
    public String toString() {
        return "Agencias{" +
                "nombreAgencia='" + nombreAgencia + '\'' +
                ", kolorMarca=" + kolorMarca +
                ", cantidadTrabajadores=" + cantidadTrabajadores +
                ", logo='" + logo + '\'' +
                '}';
    }

}
