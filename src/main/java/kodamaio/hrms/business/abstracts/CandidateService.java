package kodamaio.hrms.business.abstracts;

import java.util.List;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	Result add(Candidate candidate);
	DataResult<List<Candidate>> getAll();
}
