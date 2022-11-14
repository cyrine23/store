package com.tekup.examen.services;

import java.util.List;
import com.tekup.examen.entities.FournisseurDTO;

public interface IFournisseurService {

	List<FournisseurDTO> retrieveAllFournisseurs();

	FournisseurDTO addFournisseur(FournisseurDTO f);

	void deleteFournisseur(Long id);

	FournisseurDTO updateFournisseur(FournisseurDTO f);

	FournisseurDTO retrieveFournisseur(Long id);
	
	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
