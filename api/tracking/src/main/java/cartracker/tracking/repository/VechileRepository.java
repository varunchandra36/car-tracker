package cartracker.tracking.repository;

import java.util.List;


import org.springframework.data.repository.Repository;

import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileDetails;


public interface VechileRepository extends Repository<Vechile, String>{
	public List<Vechile> findAll();
	 public Vechile findOne(String id);
	  public Vechile save(Vechile vechile);
	  public VechileDetails save(VechileDetails vechiledetails);
}
