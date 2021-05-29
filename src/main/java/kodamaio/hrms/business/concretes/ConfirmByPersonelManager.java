package kodamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.ConfirmByPersonelService;
import kodamaio.hrms.entities.concretes.Employer;

@Service
public class ConfirmByPersonelManager implements ConfirmByPersonelService{

	@Override
	public boolean isConfirmedByPersonel(Employer employer) {
		return true;
	}

}
