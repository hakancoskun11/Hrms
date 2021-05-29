package kodamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodamaio.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer findByEmailEquals(String findEmail);
	Employer findByPhoneNumberEquals(String findPhoneNumber);
	Employer findBygetWebAdressEquals(String findWebAdress);
}
