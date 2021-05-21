package kodamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import kodamaio.hrms.business.abstracts.PositionService;
import kodamaio.hrms.entities.Position;


@RestController
@RequestMapping("/api/positions")
public class PositionController {
	
	private PositionService positionService;
	
	@Autowired
	public PositionController(PositionService positionService) {
		this.positionService = positionService;
	}
	
	@GetMapping("/getall")
	public List<Position> getAll(){
		return this.positionService.getAll();
	}
	
}
