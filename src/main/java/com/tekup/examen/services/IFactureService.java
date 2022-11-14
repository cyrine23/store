package com.tekup.examen.services;

import java.util.Date;
import java.util.List;
import com.tekup.examen.entities.FactureDTO;

public interface IFactureService {
	List<FactureDTO> retrieveAllFactures();

	List<FactureDTO> getFacturesByFournisseur(Long idFournisseur);

	FactureDTO addFacture(FactureDTO f);

	void cancelFacture(Long id);

	FactureDTO retrieveFacture(Long id);
	
	void assignOperateurToFacture(Long idOperateur, Long idFacture);

	float pourcentageRecouvrement(Date startDate, Date endDate);

}
