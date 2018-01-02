package cartracker.tracking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cartracker.tracking.entity.Vechile;
import cartracker.tracking.entity.VechileDetails;
import cartracker.tracking.services.VdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="VechileDetails")
public class VdController {
	private VdService vechileService;
	
	
	public VdController(VdService vechileService) {
		super();
		this.vechileService = vechileService;
	}
	@RequestMapping(method=RequestMethod.GET,value="/readings")
	@ApiOperation(value="Find all Vechiles", notes= "Returns a list of Vechiles in the app")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public List<VechileDetails> findAll(){
		return vechileService.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="readings/{vin}")
	@ApiOperation(value="Find Vechiles by Id", notes= "Returns a Vechiles if it exists in the app")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=404,message="Not Found"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public VechileDetails findOne(@PathVariable("vin") String vin){
		return vechileService.findOne(vin);
	}
	
	@CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(method=RequestMethod.POST,value="/readings")
	@ApiOperation(value="Add  Vechile", notes= "Updates an existing User")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public VechileDetails adddetails(@RequestBody VechileDetails vechiles){
		return vechileService.save(vechiles);
	}

}
