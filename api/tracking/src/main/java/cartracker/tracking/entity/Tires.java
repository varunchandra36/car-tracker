package cartracker.tracking.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Tires {
	@Id
	private String id;
	private String frontLeft;
	private String frontRight;
	 private String rearLeft;
	private String rearRight;
	public String getFrontLeft() {
		return frontLeft;
	}
	public Tires(){
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFrontLeft(String frontLeft) {
		this.frontLeft = frontLeft;
	}
	public String getFrontRight() {
		return frontRight;
	}
	public void setFrontRight(String frontRight) {
		this.frontRight = frontRight;
	}
	public String getRearLeft() {
		return rearLeft;
	}
	public void setRearLeft(String rearLeft) {
		this.rearLeft = rearLeft;
	}
	public String getRearRight() {
		return rearRight;
	}
	public void setRearRight(String rearRight) {
		this.rearRight = rearRight;
	}
	
}
