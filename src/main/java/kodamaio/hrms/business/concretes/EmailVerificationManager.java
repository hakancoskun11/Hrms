package kodamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.EmailVerificationService;
import kodamaio.hrms.core.utilities.GenerateRandomCode;
import kodamaio.hrms.core.utilities.results.ErrorDataResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.dataAccess.abstracts.EmailVerificationDao;
import kodamaio.hrms.entities.concretes.EmailVerification;

@Service
public class EmailVerificationManager  implements EmailVerificationService{
	private EmailVerificationDao emailVerificationDao;
	
    @Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;
	}

    @Override
	public void generateCode(EmailVerification code,Integer id) {
		// TODO Auto-generated method stub
				EmailVerification code_ = code;
				code.setCode(null);
				code.setVerified(false);
				if(code.isVerified() == false) {
					GenerateRandomCode generator = new GenerateRandomCode();
					String code_create = generator.create();
					code.setCode(code_create);
					code.setUserId(id);
			
					emailVerificationDao.save(code);
					
				}
				return ;
	}
	
	@Override
	public Result verify(String verificationCode,Integer id) {
		// TODO Auto-generated method stub
		EmailVerification ref = emailVerificationDao.findByUserId(id).stream().findFirst().get();
		if(ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
			ref.setVerified(true);
			return  new SuccessDataResult<EmailVerification>(this.emailVerificationDao.save(ref),"Başarılı");
		}
		else if(ref.isVerified() == true) {
			return  new ErrorDataResult<EmailVerification>(null,"Zaten Doğrulanmış Hesap");
		}
		return  new ErrorDataResult<EmailVerification>(null,"Doğrulama Kodu Geçersiz");
		
		
		
		
		
		
	}


	

}