package ModeloPOJOS;

import java.util.ArrayList;
import java.util.Date;

public class Bidaia {
	private int agentzia_id;
	private int bidaia_id;
	private String bidaia_izena;
	private String mota;
	private int egunak;
	private Date hasiData;
	private Date amaituData;
	private String herrialde;
	private String deskripzioa;
	private String servNoinc;
	private ArrayList<Zerbitzua> zerbitzuak;

    public Bidaia(int agentzia_id, int bidaia_id, String bidaia_izena, String mota, int egunak, Date hasiData, Date amaituData, String herrialdea, String deskripzioa, String servNoinc, ArrayList<Zerbitzua> zerbitzuak) {
        this.agentzia_id = agentzia_id;
    	this.bidaia_id = bidaia_id;
    	this.bidaia_izena = bidaia_izena;
        this.mota = mota;
        this.egunak = egunak;
        this.hasiData = hasiData;
        this.amaituData = amaituData;
        this.herrialde = herrialdea;
        this.deskripzioa = deskripzioa;
        this.servNoinc = servNoinc;
        this.zerbitzuak = new ArrayList<>();
    }

    public int getAgentzia_id() {
    	return agentzia_id;
    }
    
    public void setAgentzia_id(int agentzia_id) {
    	this.agentzia_id = agentzia_id;
    }
    public int getBidaia_id() {
		return bidaia_id;
	}

	public void setBidaia_id(int bidaia_id) {
		this.bidaia_id = bidaia_id;
	}
    
    public String getBidaia_izena() {
        return bidaia_izena;
    }

    public void setBidaia(String bidaia_izena) {
        this.bidaia_izena = bidaia_izena;
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
    
    public ArrayList<Zerbitzua> getZerbitzuak() {
		return zerbitzuak;
	}

	public void setZerbituzak(ArrayList<Zerbitzua> zerbitzuak) {
		this.zerbitzuak = zerbitzuak;
	}
	
	public void gehituZerbitzua(Zerbitzua z) {
		this.zerbitzuak.add(z);
	}

	@Override
	public String toString() {
		return "Bidaia [agentzia_id=" + agentzia_id + ", bidaia_id=" + bidaia_id + ", bidaia_izena=" + bidaia_izena
				+ ", mota=" + mota + ", egunak=" + egunak + ", hasiData=" + hasiData + ", amaituData=" + amaituData
				+ ", herrialde=" + herrialde + ", deskripzioa=" + deskripzioa + ", servNoinc=" + servNoinc
				+ ", zerbitzuak=" + zerbitzuak + "]";
	}
	
	
}
