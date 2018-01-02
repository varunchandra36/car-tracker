package cartracker.tracking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileDetails;
import cartracker.tracking.repository.VechileRepository;

@Service
public class VechileServiceImpl implements VechileService{
	VechileRepository repository;
	

	public VechileServiceImpl(VechileRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vechile> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vechile findOne(String id) {
		
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public List<Vechile> add(List<Vechile> vechiles) {
		List<Vechile> ListAdded=new ArrayList<Vechile>();
		for (Vechile vechile : vechiles) {
			Vechile v=repository.save(vechile);
		ListAdded.add(v);   
		}
		return ListAdded;
	}
	@Override
	@Transactional
	public VechileDetails save(VechileDetails vechiledetails) {
		
		return repository.save(vechiledetails);
	}

}
