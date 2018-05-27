package be.yorian.services;

import java.util.List;

import be.yorian.domain.Dossier;
import be.yorian.domain.Item;

public interface DossierService {

	Dossier findDossierById(int id);

	List<Item> getItems(Dossier dossier) throws Exception;

	Item createFirstItem(Dossier dossier) throws Exception;
	
}
