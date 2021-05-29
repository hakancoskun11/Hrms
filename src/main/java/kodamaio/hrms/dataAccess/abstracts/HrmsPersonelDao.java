package kodamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodamaio.hrms.entities.concretes.HrmsPersonel;
@Repository
public interface HrmsPersonelDao extends JpaRepository<HrmsPersonel, Integer> {

}
