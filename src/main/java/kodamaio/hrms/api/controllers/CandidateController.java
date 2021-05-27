package kodamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodamaio.hrms.business.abstracts.CandidateService;
import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	
	private CandidateService candidateService;
	
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService=candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<Candidate> add(Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
}
