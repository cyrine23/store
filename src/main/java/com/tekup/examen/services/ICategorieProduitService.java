package com.tekup.examen.services;

import java.util.List;

import com.tekup.examen.entities.CategorieProduitDTO;


public interface ICategorieProduitService {

	List<CategorieProduitDTO> retrieveAllCategorieProduits();

	CategorieProduitDTO addCategorieProduit(CategorieProduitDTO cp);

	void deleteCategorieProduit(Long id);

	CategorieProduitDTO updateCategorieProduit(CategorieProduitDTO cp);

	CategorieProduitDTO retrieveCategorieProduit(Long id);

}
