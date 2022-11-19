package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();

	CategorieProduit addCategorieProduit(CategorieProduit cp);

	void deleteCategorieProduit(Long id);


	CategorieProduit retrieveCategorieProduit(Long id);

}
