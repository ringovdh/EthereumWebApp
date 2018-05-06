package be.yorian.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.yorian.dao.DossierDAO;
import be.yorian.domain.Dossier;

@Service
public class DossierServiceImpl implements DossierService{

	@Autowired
	private DossierDAO dossierDAO;

	@Override
	public Dossier findDossier(int id) {
			
		Dossier dossier = dossierDAO.findDossier(id);

		return dossier;
	}
	
	
}
