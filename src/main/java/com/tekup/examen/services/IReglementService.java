package com.tekup.examen.services;

import java.util.Date;
import java.util.List;

import com.tekup.examen.entities.ReglementDTO;

public interface IReglementService {

	List<ReglementDTO> retrieveAllReglements();
	ReglementDTO addReglement(ReglementDTO r);
	ReglementDTO retrieveReglement(Long id);
	List<ReglementDTO> retrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate); 

}
