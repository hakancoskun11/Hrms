package kodamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodamaio.hrms.business.abstracts.EmailVerificationService;
import kodamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verify")
public class EmailVerifyController {
	private EmailVerificationService emailVerificationService;
	
	
	@Autowired
	public EmailVerifyController(EmailVerificationService emailVerificationService) {
		super();
		this.emailVerificationService = emailVerificationService;
	}



	@PostMapping("/update/{verificationCode}/{id}")
	public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id) {
			return emailVerificationService.verify(verificationCode,id);
	}
}