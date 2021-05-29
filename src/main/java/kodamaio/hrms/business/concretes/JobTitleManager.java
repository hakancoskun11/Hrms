package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.ErrorDataResult;
import kodamaio.hrms.core.utilities.results.ErrorResult;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.core.utilities.results.SuccessResult;
import kodamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodamaio.hrms.business.abstracts.JobTitleService;

import kodamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	@Autowired
	private JobTitleDao jobTitleDao;
	
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao=jobTitleDao;
	}

	@Override
	public DataResult<JobTitle> add(JobTitle title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobTitle> delete(JobTitle jobPositio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
