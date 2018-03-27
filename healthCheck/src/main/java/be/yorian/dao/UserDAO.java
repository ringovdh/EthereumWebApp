package be.yorian.dao;

import be.yorian.domain.User;

public interface UserDAO{

	public User findUserByUserName(String username);

}
