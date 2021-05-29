package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.JobPostingService;
import kodamaio.hrms.core.utilities.results.DataResult;

import kodamaio.hrms.core.utilities.results.Result;

import kodamaio.hrms.dataAccess.abstracts.JobPostingDao;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
		
	@Autowired
	JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}
	

	@Override
	public Result post(JobPostingService jobPosting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobPostingService jobPosting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPostingService>> findByActivityStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPostingService>> findByActivityStatusAndApplicationDeadline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPostingService>> findByActivityStatusAndCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}
	}
