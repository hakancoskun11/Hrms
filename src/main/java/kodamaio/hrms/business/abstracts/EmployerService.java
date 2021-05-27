package kodamaio.hrms.business.abstracts;

import java.util.List;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<Employer> add(Employer employer);
	DataResult<List<Employer>> getAll();
}
