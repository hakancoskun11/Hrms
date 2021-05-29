package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.HrmsPersonelService;
import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.dataAccess.abstracts.HrmsPersonelDao;
import kodamaio.hrms.entities.concretes.HrmsPersonel;

@Service
public class HrmsPersonelManager implements HrmsPersonelService{

private HrmsPersonelDao hrmsPersonelDao;
	
	@Autowired
	public HrmsPersonelManager(HrmsPersonelDao hrmsPersonelDao) {
		this.hrmsPersonelDao=hrmsPersonelDao;
	}
	@Override
	public DataResult<List<HrmsPersonel>> getAll() {
		return new SuccessDataResult<List<HrmsPersonel>>
		(this.hrmsPersonelDao.findAll(),"Listed");
	}

}
