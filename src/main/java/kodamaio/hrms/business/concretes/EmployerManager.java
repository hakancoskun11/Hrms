package kodamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.ConfirmByPersonelService;

import kodamaio.hrms.business.abstracts.EmployerService;

import kodamaio.hrms.core.adapters.abstracts.RegexService;
import kodamaio.hrms.core.utilities.results.DataResult;

import kodamaio.hrms.core.utilities.results.ErrorResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.core.utilities.results.SuccessResult;
import kodamaio.hrms.dataAccess.abstracts.EmployerDao;

import kodamaio.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private RegexService regexService;
	private ConfirmByPersonelService confirmByPersonelService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, RegexService regexService,ConfirmByPersonelService confirmByPersonelService) {
		super();
		this.employerDao=employerDao;
		this.confirmByPersonelService=confirmByPersonelService;
		this.regexService=regexService;
		
	}
	

	@Override
	public Result add(Employer employer) {
		if(employer.getCompanyName().isEmpty() || employer.getWebAdress().isEmpty()
				|| employer.getPhoneNumber().isEmpty() || employer.getEmail().isEmpty() 
				|| employer.getPassword().isEmpty()) {
			return new ErrorResult("Fields cannot be left blank");
		}
		
		String email = employer.getEmail();
        String[] emailSplit = email.split("@");
        if(!emailSplit[1].equals(employer.getWebAdress())) {
            return new ErrorResult("Your e-mail address and domain do not match");
        }
        
        if(employerDao.findByEmailEquals(employer.getEmail())!=null) {
        	return new ErrorResult("Registered e-mail");
        }
        
        if(!regexService.isPhoneNumberFormat(employer.getPhoneNumber())) {
        	return new ErrorResult("Invalid phone number");
        }
        
        if(employerDao.findBygetWebAdressEquals(employer.getWebAdress())!=null) {
        	return new ErrorResult("Registered website");
        }
        
        if(employerDao.findByPhoneNumberEquals(employer.getPhoneNumber())!=null) {
        	return new ErrorResult("Registered phone number");
        }
        
        else {
			this.employerDao.save(employer);
			return new SuccessResult(true,"Your registration has been created successfully");
	}
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listelendi");
	}

	@Override
	public Result confirm(Employer employer) {
		if(!confirmByPersonelService.isConfirmedByPersonel(employer)) {
			return new ErrorResult("Personel tarafından gerekli onayınız tamamlanmadı");
		}
		else {
			return new SuccessResult(true,"Personel tarafından onayınız tamamlandı");
		}
	}	
	
}
