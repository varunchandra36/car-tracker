package cartracker.tracking.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cartracker.tracking.entity.VechileAlerts;
import cartracker.tracking.services.AlertService;

@RestController
@Api(tags="Alerts")
public class AlertController {
	private AlertService alertservice; 
	
	
	
	public AlertController(AlertService alertservice) {
		this.alertservice = alertservice;
	}
	@RequestMapping(method=RequestMethod.GET,value="/alerts")
	@ApiOperation(value="Find all Alerts", notes= "Returns a list of Alerts in the app")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public List<VechileAlerts> findAll(){
		return alertservice.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="alerts/{vin}")
	@ApiOperation(value="Find Alert by Id", notes= "Returns a Alert if it exists in the app")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=404,message="Not Found"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public VechileAlerts findOne(@PathVariable("vin") String vin){
		return alertservice.findOne(vin);
	}
	
	@CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(method=RequestMethod.PUT,value="/alerts")
	@ApiOperation(value="Add  Alert", notes= "Updates an existing Alert")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public VechileAlerts add(@RequestBody VechileAlerts vechiledetails){
		return alertservice.add(vechiledetails);
	}
}
