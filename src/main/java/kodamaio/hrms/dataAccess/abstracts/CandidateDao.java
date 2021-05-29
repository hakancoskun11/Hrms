package kodamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByEmailEquals(String findEmail);
	Candidate findIdentityNumberEquals(String findIdentityNumber);
}
