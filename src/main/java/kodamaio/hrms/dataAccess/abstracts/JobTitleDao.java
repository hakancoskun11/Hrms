package kodamaio.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{
	//List<JobTitle> findJobTitles(@Param("title") String title);
	//List<JobTitle> findById(@Param("") int id);
	//Optional<JobTitle> findOneByTite(@Param("") String title);
	//List<JobTitle> findAllByTitle(String title);
	
}
