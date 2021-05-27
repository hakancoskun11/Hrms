package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.UserService;
import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.dataAccess.abstracts.UserDao;
import kodamaio.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public UserManager() {
		
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(userDao.findAll(),"Başarılı Şekilde Kullanıcılar Listelendi");
	}

	@Override
	public User add(User user) {
		return userDao.save(user);
	}

}