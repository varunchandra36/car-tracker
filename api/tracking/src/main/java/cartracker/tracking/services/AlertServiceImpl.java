package cartracker.tracking.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cartracker.tracking.entity.VechileAlerts;
import cartracker.tracking.repository.AlertRepository;


@Service
public class AlertServiceImpl implements AlertService {
	public AlertRepository alertrepository;
	

	public AlertServiceImpl(AlertRepository alertrepository) {
		
		this.alertrepository = alertrepository;
	}
	@Override
	@Transactional(readOnly = true)
	public VechileAlerts findOne(String vin) {
	
		return alertrepository.findOne(vin);
	}
	@Override
	@Transactional(readOnly = true)
	public List<VechileAlerts> findAll() {
		
		return alertrepository.findAll();
	}

	@Override
	@Transactional
	public VechileAlerts add(VechileAlerts vechiledetails) {
	
		return alertrepository.save(vechiledetails);
	}

}
