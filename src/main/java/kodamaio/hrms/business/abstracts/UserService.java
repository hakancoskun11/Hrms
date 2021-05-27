package kodamaio.hrms.business.abstracts;
import java.util.List;

import kodamaio.hrms.core.utilities.results.DataResult;
import kodamaio.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	User add(User user);
}
