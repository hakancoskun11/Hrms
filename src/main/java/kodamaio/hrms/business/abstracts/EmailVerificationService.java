package kodamaio.hrms.business.abstracts;

import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.entities.concretes.EmailVerification;

public interface EmailVerificationService {
	void generateCode(EmailVerification code, Integer id);
	Result verify(String verificationCode, Integer id );
}
