package kodamaio.hrms.business.abstracts;

import java.util.List;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.entities.concretes.HrmsPersonel;

public interface HrmsPersonelService {
	DataResult<List<HrmsPersonel>> getAll();
}
