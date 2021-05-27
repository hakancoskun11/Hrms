package kodamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	List<Candidate> findAllByEmail(String email);
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
}
