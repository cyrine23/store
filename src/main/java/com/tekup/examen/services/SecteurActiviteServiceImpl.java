package com.tekup.examen.services;

import java.util.List;

import com.tekup.examen.entities.SecteurActiviteDTO;
import com.tekup.examen.repositories.SecteurActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
    SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActiviteDTO> retrieveAllSecteurActivite() {
		return (List<SecteurActiviteDTO>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActiviteDTO addSecteurActivite(SecteurActiviteDTO sa) {
		secteurActiviteRepository.save(sa);
		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public SecteurActiviteDTO updateSecteurActivite(SecteurActiviteDTO sa) {
		secteurActiviteRepository.save(sa);
		return sa;
	}

	@Override
	public SecteurActiviteDTO retrieveSecteurActivite(Long id) {
		return secteurActiviteRepository.findById(id).orElse(null);
	}

}
