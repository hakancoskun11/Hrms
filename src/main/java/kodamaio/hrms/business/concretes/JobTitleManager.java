package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.ErrorDataResult;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
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
		
		if(jobTitleDao.findAllByTitle(title.getTitle()).stream().count() !=0) {
			return new ErrorDataResult<JobTitle>(null, "bu iş pozisyonu zaten kayıtlı");
		}
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(title),"Başarıyla iş pozisyonu eklendi");
		
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),"Başarılı Şekilde Listelendi");
	}

}
