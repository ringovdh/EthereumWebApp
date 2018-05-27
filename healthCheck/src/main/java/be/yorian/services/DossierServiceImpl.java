package be.yorian.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;

import be.yorian.dao.DossierDAO;
import be.yorian.dao.ItemDAO;
import be.yorian.domain.Dossier;
import be.yorian.domain.Item;
import be.yorian.server.ServerHelper;

@Service
public class DossierServiceImpl implements DossierService{

	@Autowired
	private DossierDAO dossierDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public Dossier findDossierById(int id) {
			
		Dossier dossier = dossierDAO.findDossier(id);

		return dossier;
	}


	@Override
	public List<Item> getItems(Dossier dossier) throws Exception {
		List<Item> items = new ArrayList<>();
		ServerHelper server = new ServerHelper();
		List<BigInteger> itemIDs = server.getItems(dossier);
		
		for(BigInteger oid : itemIDs ){
			int id = oid.intValue();
			items.add(itemDAO.findItemByID(id));
		}
		
		return items;
	}


	@Override
	public Item createFirstItem(Dossier dossier) throws Exception{		
		Item item = new Item(dossier.getPatient(), "Opstart van dossier", new Date(), "nvt");		
		itemDAO.saveItem(item);

		
		return item;
	}
	
	
}
