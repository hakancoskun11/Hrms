package kodamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodamaio.hrms.business.abstracts.JobTitleService;
import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitle/")
public class JobTitlesController {
	@Autowired
	private JobTitleService jobTitleService;
	
	JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService=jobTitleService;
	}
	
	
	 @GetMapping("getall")
	 public DataResult<List<JobTitle>> getAll() {
		 return jobTitleService.getAll();
	 }
	 
	 
	 
	 @PostMapping("add")
	 public DataResult<JobTitle> add(JobTitle jobTitle) {
		 return this.jobTitleService.add(jobTitle);
	 }
	
	
	
	
}
