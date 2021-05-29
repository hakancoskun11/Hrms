package kodamaio.hrms.business.abstracts;

import java.util.List;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.Result;

public interface JobPostingService {
	Result post(JobPostingService jobPosting);
	Result delete(JobPostingService jobPosting);
	DataResult<List<JobPostingService>> findByActivityStatus();
	DataResult<List<JobPostingService>> findByActivityStatusAndApplicationDeadline();
	DataResult<List<JobPostingService>> findByActivityStatusAndCompanyName(String companyName);
}
