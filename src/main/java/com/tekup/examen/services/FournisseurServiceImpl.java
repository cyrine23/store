package com.tekup.examen.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.examen.entities.DetailFournisseurDTO;
import com.tekup.examen.entities.FournisseurDTO;
import com.tekup.examen.entities.SecteurActiviteDTO;
import com.tekup.examen.repositories.DetailFournisseurRepository;
import com.tekup.examen.repositories.FournisseurRepository;
import com.tekup.examen.repositories.ProduitRepository;
import com.tekup.examen.repositories.SecteurActiviteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;

	@Override
	public List<FournisseurDTO> retrieveAllFournisseurs() {
		List<FournisseurDTO> fournisseurDTOS =  fournisseurRepository.findAll();
		for (FournisseurDTO fournisseurDTO : fournisseurDTOS) {
			log.info(" fournisseur : " + fournisseurDTO);
		}
		return fournisseurDTOS;
	}


	public FournisseurDTO addFournisseur(FournisseurDTO f /*Master*/) {
		DetailFournisseurDTO df= new DetailFournisseurDTO();//Slave
		df.setDateDebutCollaboration(new Date()); //util
		//On affecte le "Slave" au "Master"
		f.setDetailFournisseurDTO(df);
		fournisseurRepository.save(f);
		return f;
	}
	
	private DetailFournisseurDTO saveDetailFournisseur(FournisseurDTO f){
		DetailFournisseurDTO df = f.getDetailFournisseurDTO();
		detailFournisseurRepository.save(df);
		return df;
	}

	public FournisseurDTO updateFournisseur(FournisseurDTO f) {
		DetailFournisseurDTO df = saveDetailFournisseur(f);
		f.setDetailFournisseurDTO(df);
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public void deleteFournisseur(Long fournisseurId) {
		fournisseurRepository.deleteById(fournisseurId);

	}

	@Override
	public FournisseurDTO retrieveFournisseur(Long fournisseurId) {
		return fournisseurRepository.findById(fournisseurId).orElse(null);
	}

	@Override
	public void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur) {

		FournisseurDTO fournisseurDTO = new FournisseurDTO();
		Optional<FournisseurDTO> value = this.fournisseurRepository.findById(idFournisseur);
		if(value.isPresent()){
			fournisseurDTO = value.get();
		}
		SecteurActiviteDTO secteurActiviteDTO = secteurActiviteRepository.findById(idSecteurActivite).orElse(null);

		fournisseurDTO.getSecteurActiviteDTOS().add(secteurActiviteDTO);

		fournisseurRepository.save(fournisseurDTO);


	}

	

}