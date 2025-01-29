package Modelo;

public class Bidaiak {
	private String viajes;
	private String tipo;
	private int dias;
	private String fechaInicio;
	private String fechaFin;
	private String pais;
	private String desc;
	private String servNoinc;

    public Bidaiak() {
    }

    public Bidaiak(String viajes, String tipo, int dias, String fechaInicio, String fechaFin, String pais, String desc, String servNoinc) {
        this.viajes = viajes;
        this.tipo = tipo;
        this.dias = dias;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pais = pais;
        this.desc = desc;
        this.servNoinc = servNoinc;
    }

    public String getViajes() {
        return viajes;
    }

    public void setViajes(String viajes) {
        this.viajes = viajes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getServNoinc() {
        return servNoinc;
    }

    public void setServNoinc(String servNoinc) {
        this.servNoinc = servNoinc;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "viajes='" + viajes + '\'' +
                ", tipo='" + tipo + '\'' +
                ", dias=" + dias +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", pais='" + pais + '\'' +
                ", desc='" + desc + '\'' +
                ", servNoinc='" + servNoinc + '\'' +
                '}';
    }
}
