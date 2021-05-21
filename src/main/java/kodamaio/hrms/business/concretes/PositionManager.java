package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.PositionService;
import kodamaio.hrms.dataAccess.abstracts.PositionRepository;
import kodamaio.hrms.entities.Position;
@Service
public class PositionManager implements PositionService{

	
	private PositionRepository positionRepository;
	
	@Autowired
	public PositionManager(PositionRepository positionRepository) {
		super();
		this.positionRepository = positionRepository;
	}


	@Override
	public List<Position> getAll() {
		return this.positionRepository.findAll();
	}

}
