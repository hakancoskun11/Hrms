package kodamaio.hrms.business.abstracts;

import kodamaio.hrms.entities.concretes.Employer;

public interface ConfirmByPersonelService {
	boolean isConfirmedByPersonel(Employer employer);
}
