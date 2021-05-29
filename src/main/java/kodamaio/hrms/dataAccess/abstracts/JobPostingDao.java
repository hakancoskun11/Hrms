package kodamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodamaio.hrms.entities.concretes.JobPosting;

@Repository
public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	JobPosting findByPostingEquals(int positionId);
	 List<JobPosting> findByActivityStatus(boolean activityStatus);
	 List<JobPosting> findByActivityStatusOrderByApplicationDeadline(boolean activityStatus);
	 List<JobPosting> findByActivityStatusTrueAndEmployer_CompanyName(String companyName);
}
