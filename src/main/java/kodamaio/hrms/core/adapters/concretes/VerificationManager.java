package kodamaio.hrms.core.adapters.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.core.adapters.abstracts.VerificationService;
import kodamaio.hrms.core.utilities.results.ErrorDataResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.entities.concretes.EmailVerification;

@Service
public class VerificationManager implements VerificationService {
	
	private VerificationDao verificationDao;
	@Autowired
	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao=verificationDao;
	}
	
	@Override
	public void genereatedVerify(EmailVerification verification, int id) {
		
		EmailVerification verifications = verification;
		verifications.setEmailVerification(null);
		verifications.setVerified(false);
		if (verification.isVerified()==false) {
			RandomGeneratedVerify randomVerify = new RandomGeneratedVerify();
			String create_verify = randomVerify.create();
			verifications.setEmailVerification(create_verify);
			
			this.verificationDao.save(verifications);
		}
		return;

	}		
	
	@Override
	public Result isVerified(String randomVerify, int id) {
		EmailVerification verify = verificationDao.getOne(id);
		if(verify.getEmailVerification().equals(randomVerify)) {
			verify.setVerified(true);
			return new SuccessDataResult()<EmailVerification>(this.verificationDao.save(verify),"Successfull");
		}
		else {
			return new ErrorDataResult()<EmailVerification>("Unsuccessfull");
		}
	}
	}
