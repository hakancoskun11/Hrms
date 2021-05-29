package kodamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodamaio.hrms.entities.concretes.ConfirmByPersonel;

@Repository
public interface ConfirmByPersonelDao extends JpaRepository<ConfirmByPersonel,Integer>{

}
