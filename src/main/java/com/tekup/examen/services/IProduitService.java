package com.tekup.examen.services;

import java.util.List;
import com.tekup.examen.entities.ProduitDTO;

public interface IProduitService {

	List<ProduitDTO> retrieveAllProduits();

	ProduitDTO addProduit(ProduitDTO p);

	void deleteProduit(Long id);

	ProduitDTO updateProduit(ProduitDTO p);

	ProduitDTO retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

}
