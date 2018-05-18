package be.yorian.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.yorian.dao.VerstrekkerDAO;
import be.yorian.domain.Verstrekker;

@Service
public class VerstrekkerServiceImpl implements VerstrekkerService {

	@Autowired
	VerstrekkerDAO verstrekkerDAO;
	
	
	@Override
	public Verstrekker findVerstrekkerByUserName(String userName) {

		Verstrekker verstrekker = verstrekkerDAO.findVerstrekkerByUserName(userName);
		
		return verstrekker;
	}


	@Override
	public List<Verstrekker> findAll() {
		
		List<Verstrekker> verstrekkers = verstrekkerDAO.findAll();
		
		return verstrekkers;
	}

}
