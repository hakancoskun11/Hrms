package kodamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.EmailVerificationService;
import kodamaio.hrms.business.abstracts.EmployerService;
import kodamaio.hrms.business.abstracts.UserService;
import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.ErrorDataResult;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodamaio.hrms.entities.concretes.EmailVerification;
import kodamaio.hrms.entities.concretes.Employer;
import kodamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;
	
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService, UserService userService) {
		super();
		this.employerDao=employerDao;
		this.emailVerificationService=emailVerificationService;
		this.userService=userService;
	}
	

	@Override
	public DataResult<Employer> add(Employer employer) {
		
		
		if(!companyNameChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"Şirket adı doldurulmak zorundadır");
		}
		if(!webSiteChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"Web site adresi doldurulmak zorundadır");
		}
		if(!isRealEmployer(employer)) {
			return new ErrorDataResult<Employer>(null,"Geçersiz email adresi");
		}
		if(!passwordNullChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"Şifre bilgisi doldurulmak zorundadır");
		}
		if(!isRealPhoneNumber(employer)) {
			return new ErrorDataResult<Employer>(null,"Geçersiz telefon numarası");  
		}
		if(!isEmailAlreadyRegistered(employer)) {
			return new ErrorDataResult<Employer>(null,"Email adresi zaten kullanımda");
		}
		User savedUser = this.userService.add(employer);
		this.emailVerificationService.generateCode(new EmailVerification(), savedUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İşveren hesabı eklendi, doğrulama kodu gönderildi. ID:"+employer.getId());
		
		
	}
	
	private boolean companyNameChecker(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getCompanyName()==null) {
			return false;
		}
		return true;
	}
	
	private boolean webSiteChecker(Employer employer) {
		if(employer.getWebAdress().isBlank() || employer.getWebAdress()==null) {
			return false;
		}
		return true;
	}
	
	private boolean isRealEmployer(Employer employer) {
		String regex ="^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if(!matcher.matches()) {
			return false;
		}
		else if(!employer.getEmail().contains(employer.getWebAdress())) {
			return false;
		}
		return true;
	}
	
	
	private boolean isEmailAlreadyRegistered(Employer employer) {
		if(employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return false;
		}
		return true;
	}
	
	private boolean passwordNullChecker(Employer employer) {
		if(employer.getPassword().isBlank() || employer.getPassword() == null) {
			return false;
		}
		return true;
	}
	
	private boolean isRealPhoneNumber(Employer employer) {
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		/*
		 * ÖRNEK TELEFON NUMARALARI
		 * String[] validPhoneNumbers 
      = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125", 
      "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
		 */
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if(!matcher.matches()) {
			return false;
		}
		return true;
		
	}
	
	
	
	

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer başarılı şekilde listelendi");
	}

}
