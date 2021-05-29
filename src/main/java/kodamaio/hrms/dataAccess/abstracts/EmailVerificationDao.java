package kodamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodamaio.hrms.entities.concretes.EmailVerification;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer>{
	
}
