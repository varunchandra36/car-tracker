package cartracker.tracking.services;

import java.util.List;

import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileDetails;

public interface VdService {
	public List<VechileDetails> findAll();
	public VechileDetails findOne(String id);
	
	public VechileDetails save(VechileDetails vechiledetails);
	
}
