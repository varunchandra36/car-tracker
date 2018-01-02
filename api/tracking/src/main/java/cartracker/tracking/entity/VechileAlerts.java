package cartracker.tracking.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VechileAlerts {
	@Id
	private String id;
	@OneToOne
	private Vechile vechile;
	@OneToOne
	private VechileDetails vechiledetails;
	private int rpmalert;
	private int fuelvolume;
	private int tirepressure;
	private int coolantorligth;
	public VechileAlerts(){
		this.id = UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Vechile getVechile() {
		return vechile;
	}
	public void setVechile(Vechile vechile) {
		this.vechile = vechile;
	}
	public VechileDetails getVechiledetails() {
		return vechiledetails;
	}
	public void setVechiledetails(VechileDetails vechiledetails) {
		this.vechiledetails = vechiledetails;
	}
	public int getRpmalert() {
		return rpmalert;
	}
	public void setRpmalert(int rpmalert) {
		this.rpmalert = rpmalert;
	}
	public int getFuelvolume() {
		return fuelvolume;
	}
	public void setFuelvolume(int fuelvolume) {
		this.fuelvolume = fuelvolume;
	}
	public int getTirepressure() {
		return tirepressure;
	}
	public void setTirepressure(int tirepressure) {
		this.tirepressure = tirepressure;
	}
	public int getCoolantorligth() {
		return coolantorligth;
	}
	public void setCoolantorligth(int coolantorligth) {
		this.coolantorligth = coolantorligth;
	}
	
	

}
