package cartracker.tracking.repository;

import org.springframework.data.repository.Repository;

import cartracker.tracking.entity.Tires;


public interface TireRepository extends Repository<Tires,String>  {
	public void save(Tires tire);

}
