package kodamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodamaio.hrms.business.abstracts.UserService;
import kodamaio.hrms.core.adapters.abstracts.RegexService;
import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.core.utilities.results.ErrorResult;
import kodamaio.hrms.core.utilities.results.Result;
import kodamaio.hrms.core.utilities.results.SuccessDataResult;
import kodamaio.hrms.core.utilities.results.SuccessResult;
import kodamaio.hrms.dataAccess.abstracts.UserDao;
import kodamaio.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	private RegexService regexService;

	
	@Autowired
	public UserManager(UserDao userDao, RegexService regexService) {
		super();
		this.userDao=userDao;
		this.regexService=regexService;
	}


	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}