package be.yorian.dao;

import be.yorian.domain.Dossier;

public interface DossierDAO{

	public Dossier findDossier(int id);

	public void saveDossier(Dossier dossier);

}
