package kodamaio.hrms.dataAccess.abstracts;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import kodamaio.hrms.entities.concretes.JobTitle;

@Repository
public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{
	JobTitle findByPositionNameEquals(String findJobName); 
	
}
