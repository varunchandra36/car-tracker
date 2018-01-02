package cartracker.tracking.services;

import java.util.List;

import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileDetails;

public interface VechileService {
	public List<Vechile> findAll();
	public Vechile findOne(String id);
	public List<Vechile> add(List<Vechile> vechiles);
	public VechileDetails save(VechileDetails vechiledetails);
}
