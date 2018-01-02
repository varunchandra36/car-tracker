package cartracker.tracking.repository;

import java.util.List;


import org.springframework.data.repository.Repository;

import cartracker.tracking.entity.VechileAlerts;

public interface AlertRepository extends Repository<VechileAlerts ,String>  {
	
	public VechileAlerts findOne(String vin);

	public List<VechileAlerts> findAll();

	public VechileAlerts save(VechileAlerts vechiledetails);


}
