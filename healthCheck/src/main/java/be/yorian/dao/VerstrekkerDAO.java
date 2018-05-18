package be.yorian.dao;

import java.util.List;

import be.yorian.domain.Verstrekker;

public interface VerstrekkerDAO {

	Verstrekker findVerstrekkerByUserName(String userName);

	List<Verstrekker> findAll();

}
