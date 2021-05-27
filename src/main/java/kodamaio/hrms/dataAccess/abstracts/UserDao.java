package kodamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{

}
