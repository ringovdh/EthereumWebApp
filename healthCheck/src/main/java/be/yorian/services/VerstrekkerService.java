package be.yorian.services;

import java.util.List;

import be.yorian.domain.Verstrekker;

public interface VerstrekkerService {

	Verstrekker findVerstrekkerByUserName(String userID);

	List<Verstrekker> findAll();

}
