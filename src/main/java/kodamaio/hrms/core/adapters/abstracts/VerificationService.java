package kodamaio.hrms.core.adapters.abstracts;

import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.entities.concretes.EmailVerification;

public interface VerificationService {
	void generatedVerify(EmailVerification verification, int id);
	Result isVerified(String emailVerify, int id);
}
