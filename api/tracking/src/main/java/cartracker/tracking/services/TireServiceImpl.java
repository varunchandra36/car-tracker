package cartracker.tracking.services;

import org.springframework.stereotype.Service;

import cartracker.tracking.entity.Tires;
import cartracker.tracking.repository.TireRepository;
@Service
public class TireServiceImpl implements TireService {
	TireRepository trepository;
	
	public TireServiceImpl(TireRepository trepository) {
	
		this.trepository = trepository;
	}

	@Override
	public void save(Tires tire) {
		
		trepository.save(tire);
	}

}
