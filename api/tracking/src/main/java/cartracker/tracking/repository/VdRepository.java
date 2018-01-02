package cartracker.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileDetails;

public interface VdRepository extends Repository<VechileDetails,String> {
	public List<VechileDetails> findAll();
	 public VechileDetails findOne(String id);
	 
	  public VechileDetails save(VechileDetails vechiledetails);
	  
}
/*SELECT foods.tem_name,foods.item_unit,
company.company_name, company.company_city
FROM foods ,company
WHERE  foods.company_id =company.company_id
AND company.company_city='London';*/