package cartracker.tracking.controller;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cartracker.tracking.entity.Vechile;

import cartracker.tracking.services.VechileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="Vechiles")
public class VechileController {
 private VechileService vechileService;
 
	public VechileController(VechileService vechileService) {
	this.vechileService = vechileService;
}
	@RequestMapping(method=RequestMethod.GET,value="/vechiles")
	@ApiOperation(value="Find all vechiles", notes= "Returns a list of vechiles in the app")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public List<Vechile> findAll(){
		return vechileService.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="vechiles/{vin}")
	@ApiOperation(value="Find vechile by Id", notes= "Returns a vechile if it exists in the app")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=404,message="Not Found"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public Vechile findOne(@PathVariable("vin") String vin){
		return vechileService.findOne(vin);
	}
	
	@CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(method=RequestMethod.PUT,value="/vechiles")
	@ApiOperation(value="Add  Vechile", notes= "Updates an existing vechiles")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Success"),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Internal Error")
	})
	public List<Vechile> add(@RequestBody List<Vechile> vechiles){
		return vechileService.add(vechiles);
	}

}
