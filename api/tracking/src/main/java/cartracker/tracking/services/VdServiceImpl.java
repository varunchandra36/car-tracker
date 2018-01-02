package cartracker.tracking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cartracker.tracking.entity.Tires;
import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileAlerts;
import cartracker.tracking.entity.VechileDetails;
import cartracker.tracking.repository.VdRepository;
import cartracker.tracking.repository.VechileRepository;
@Service
public class VdServiceImpl implements VdService {
	VdRepository repository;
	TireService tireservice;
	VechileService vechileservice;
	AlertService alertservice;
	
public VdServiceImpl(VdRepository repository, TireService tireservice,VechileService vechileservice,AlertService alertservice) {
		super();
		this.repository = repository;
		this.tireservice = tireservice;
		this.vechileservice = vechileservice;
		this.alertservice = alertservice;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VechileDetails> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public VechileDetails findOne(String id) {
		
		return repository.findOne(id);
	}


	@Override
	@Transactional
	public VechileDetails save(VechileDetails vechiledetails) {
		VechileAlerts vechilealert=new VechileAlerts();
		int rpmflag=0;
		int fuelflag=0;
		int tireflag=0;
		int coolflag=0;
		//checkingforalerts
	 String vin=vechiledetails.getVin();
	 Vechile vechile=vechileservice.findOne(vin);
	 
	 if(Integer.parseInt(vechiledetails.getEngineRpm())>Integer.parseInt(vechile.getRedlineRpm()))
	 {
		vechilealert.setRpmalert(3);
		rpmflag=1;
	 }
	 else{
		 vechilealert.setRpmalert(0);
		 
	 }
	 if(fuelCheck(vechiledetails.getFuelVolume(),vechile.getMaxFuelVolume()))
	 {
		 vechilealert.setFuelvolume(2);
		 fuelflag=1;
	 }
	 else
	 {
		 vechilealert.setFuelvolume(0);
	 }
	 if(tireCheck(vechiledetails.getTires()))
	 {
		vechilealert.setTirepressure(1);
		tireflag=1;
	 }
	 else
	 {
		 vechilealert.setTirepressure(0); 
	 }
	 if(vechiledetails.getEngineCoolantLow().equals("true")||vechiledetails.getCheckEngineLightOn().equals("true"))
	 {
		 vechilealert.setCoolantorligth(1); 
		 coolflag=0;
	 }
	 else
	 {
		 vechilealert.setCoolantorligth(0); 
	 }
	 if(rpmflag==1||fuelflag==1||tireflag==1||coolflag==1)
	 {tireservice.save(vechiledetails.getTires());
		 vechilealert.setVechile(vechile);
		 vechilealert.setVechiledetails(vechiledetails);
		 repository.save(vechiledetails);
		 System.out.println(vechiledetails.toString());
		 alertservice.add(vechilealert);
		 
	 }
	 
	 tireservice.save(vechiledetails.getTires());
		 
		return repository.save(vechiledetails);
	}

	public boolean tireCheck(Tires tire)
	{
		boolean check=false;
		int t1,t2,t3,t4;
		t1=Integer.parseInt(tire.getFrontLeft());
		t2=Integer.parseInt(tire.getFrontRight());
		t3=Integer.parseInt(tire.getRearLeft());
		t4=Integer.parseInt(tire.getRearRight());
		if(pressureCheck(t1)||pressureCheck(t2)||pressureCheck(t3)||pressureCheck(t4))
		{
		check=true;
		}
		
		return check;
		
		
	}
	public boolean pressureCheck(int t)
	{
		boolean check=false;
		if(t<32||t>36)
		{
			check=true;
		}
		return check;
	}
  public boolean fuelCheck(String fuellevel,String maxfuel)
  { 
	  float flevel=Float.parseFloat(fuellevel);
	  float maxlevel=Float.parseFloat(maxfuel);
	  float tenpercent=(maxlevel/100)*10;
	  boolean check=false;
	  if(flevel<tenpercent)
	  {
		  check=true;
	  }
	
	  return check;
  }
	
}
