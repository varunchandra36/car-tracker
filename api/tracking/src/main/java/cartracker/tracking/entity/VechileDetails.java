package cartracker.tracking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;
@Entity
public class VechileDetails {
	@Id
	public String vin;
	public String latitude;
	public String longitude;
	public String timestamp; 
	public String fuelVolume;
	public String speed; 
	public String engineHp;
	public String checkEngineLightOn;
	public String engineCoolantLow;
	public String cruiseControlOn;
	public String engineRpm;
	@OneToOne
	public Tires tires;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(String fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(String engineHp) {
		this.engineHp = engineHp;
	}
	public String getCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(String checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	public String getEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(String engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	public String getCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(String cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	public String getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(String engineRpm) {
		this.engineRpm = engineRpm;
	}
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}
}
