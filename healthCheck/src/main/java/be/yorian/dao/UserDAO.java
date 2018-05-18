package be.yorian.dao;

import be.yorian.domain.Patient;

public interface UserDAO{

	public Patient findUserByUserName(String username);

}
