package kodamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodamaio.hrms.business.abstracts.CandidateService;
import kodamaio.hrms.core.adapters.abstracts.RegexService;
import kodamaio.hrms.core.adapters.abstracts.SimulatedMernisService;
import kodamaio.hrms.core.utilities.results.DataResult;

import kodamaio.hrms.core.utilities.results.ErrorResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.core.utilities.results.SuccessResult;
import kodamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private RegexService regexService;
	private SimulatedMernisService simulatedMernisService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,RegexService regexService,  SimulatedMernisService simulatedMernisService) {
		this.candidateDao=candidateDao;
		this.regexService=regexService;
		this.simulatedMernisService=simulatedMernisService;
		
	}
	@Override
	public Result add(Candidate candidate) {
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() ||candidate.getIdentificationNumber().isEmpty()
				||candidate.getEmail().isEmpty() || candidate.getPassword().isEmpty()) {
			return new ErrorResult("Alanlar boş bırakılmamalıdır.");
		}
		if(!regexService.isFirstNameFormat(candidate.getFirstName())) {
			return new ErrorResult("lütfen isminizi doğru şekilde giriniz.");
		}
		if(!regexService.isLastNameFormat(candidate.getLastName())) {
			return new ErrorResult("lütfen soy isminizi doğru şekilde giriniz.");
		}
		if(!regexService.isBirthYearFormat(candidate.getBirthDate())) {
			return new ErrorResult("Please enter in birth year format");
		}
		
		if(!regexService.isEmailFormat(candidate.getEmail())) {
			return new ErrorResult("Please enter in e-mail format");
		}
		
		if(!simulatedMernisService.checkMernis(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentificationNumber(), 
				candidate.getBirthDate())) {
			return new ErrorResult("Giriş Başarısız");
		}
		if(candidateDao.findByEmailEquals(candidate.getEmail())!=null) {
			return new ErrorResult("Email zaten sisteme kayıtlı.");
		}
		if(candidateDao.findIdentityNumberEquals(candidate.getIdentificationNumber())!=null) {
			return new ErrorResult("Kimlik numarası zaten sisteme kayıtlı");
		}
		else {
			this.candidateDao.save(candidate);
			return new SuccessResult(true,"Kaydınız başarılı şekilde tamamlanmıştır.");
		}
		
		
		
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>> (this.candidateDao.findAll(),"Listed");
	}
	
	
	
	
	
	



}
