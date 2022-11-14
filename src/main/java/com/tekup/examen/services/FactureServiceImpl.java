package com.tekup.examen.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.tekup.examen.entities.FactureDTO;
import com.tekup.examen.entities.FournisseurDTO;
import com.tekup.examen.entities.OperateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.examen.repositories.DetailFactureRepository;
import com.tekup.examen.repositories.FactureRepository;
import com.tekup.examen.repositories.FournisseurRepository;
import com.tekup.examen.repositories.OperateurRepository;
import com.tekup.examen.repositories.ProduitRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	@Autowired
    FactureRepository factureRepository;
	@Autowired
    OperateurRepository operateurRepository;
	@Autowired
    DetailFactureRepository detailFactureRepository;
	@Autowired
    FournisseurRepository fournisseurRepository;
	@Autowired
    ProduitRepository produitRepository;
    @Autowired
    ReglementServiceImpl reglementService;
	
	@Override
	public List<FactureDTO> retrieveAllFactures() {
		List<FactureDTO> factureDTOS = factureRepository.findAll();
		for (FactureDTO factureDTO : factureDTOS) {
			log.info(" facture : " + factureDTO);
		}
		return factureDTOS;
	}

	
	public FactureDTO addFacture(FactureDTO f) {
		return factureRepository.save(f);
	}

	/*
	 * calculer les montants remise et le montant total d'un détail facture
	 * ainsi que les montants d'une facture
	 */

	@Override
	public void cancelFacture(Long factureId) {

		FactureDTO factureDTO = factureRepository.findById(factureId).orElse(new FactureDTO());
		factureDTO.setArchivee(true);
		factureRepository.save(factureDTO);

		factureRepository.updateFacture(factureId);
	}

	@Override
	public FactureDTO retrieveFacture(Long factureId) {

		FactureDTO factureDTO = factureRepository.findById(factureId).orElse(null);
		log.info("facture :" + factureDTO);
		return factureDTO;
	}

	@Override
	public List<FactureDTO> getFacturesByFournisseur(Long idFournisseur) {
		FournisseurDTO fournisseurDTO ;
		Optional<FournisseurDTO> value = this.fournisseurRepository.findById(idFournisseur);
		if(value.isPresent()){
			fournisseurDTO = value.get();
			return (List<FactureDTO>) fournisseurDTO.getFactureDTOS();
		}
		return null;
	}

	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		FactureDTO factureDTO = factureRepository.findById(idFacture).orElse(null);
		OperateurDTO operateurDTO = new OperateurDTO();
		Optional<OperateurDTO> value = this.operateurRepository.findById(idOperateur);
		if(value.isPresent()){
			operateurDTO = value.get();
			operateurDTO.getFactureDTOS().add(factureDTO);
		}
		operateurRepository.save(operateurDTO);
	}

	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		float totalFacturesEntreDeuxDates = factureRepository.getTotalFacturesEntreDeuxDates(startDate,endDate);
		float totalRecouvrementEntreDeuxDates =reglementService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
		return (totalRecouvrementEntreDeuxDates/totalFacturesEntreDeuxDates)*100;
	}
	

}