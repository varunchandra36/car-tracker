package cartracker.tracking.services;

import java.util.List;

import cartracker.tracking.entity.VechileAlerts;


public interface AlertService {

	public VechileAlerts findOne(String vin);

	public List<VechileAlerts> findAll();

	public VechileAlerts add(VechileAlerts vechiledetails);

}
