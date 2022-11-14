package com.tekup.examen.services;

import java.util.Date;
import java.util.List;

import com.tekup.examen.entities.ReglementDTO;
import com.tekup.examen.repositories.FactureRepository;
import com.tekup.examen.repositories.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReglementServiceImpl implements IReglementService {

	@Autowired
    FactureRepository factureRepository;
	@Autowired
    ReglementRepository reglementRepository;
	@Override
	public List<ReglementDTO> retrieveAllReglements() {
		return (List<ReglementDTO>) reglementRepository.findAll();
	}

	@Override
	public ReglementDTO addReglement(ReglementDTO r) {
        reglementRepository.save(r);
		return r;
	}

	@Override
	public ReglementDTO retrieveReglement(Long id) {
		
		return reglementRepository.findById(id).orElse(null);
	}

	@Override
	public List<ReglementDTO> retrieveReglementByFacture(Long idFacture) {
		return reglementRepository.retrieveReglementByFacture(idFacture);
		

	}

	@Override
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
		return reglementRepository.getChiffreAffaireEntreDeuxDate( startDate, endDate);
	}

}
