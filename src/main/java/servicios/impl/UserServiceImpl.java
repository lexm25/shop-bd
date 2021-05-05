package servicios.impl;

import persistencia.UserDAO;
import persistencia.impl.UserDAOImpl;
import servicios.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAOImpl();
	@Override
	public boolean login(String username, String password) {
		return userDAO.login(username, password);
	}

}
