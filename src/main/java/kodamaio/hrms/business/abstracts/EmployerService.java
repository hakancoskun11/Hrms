package kodamaio.hrms.business.abstracts;

import java.util.List;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
	Result confirm(Employer employer);
}
