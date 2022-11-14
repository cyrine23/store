package com.tekup.examen.services;

import java.util.List;

import com.tekup.examen.entities.SecteurActiviteDTO;

public interface ISecteurActiviteService {

	List<SecteurActiviteDTO> retrieveAllSecteurActivite();

	SecteurActiviteDTO addSecteurActivite(SecteurActiviteDTO sa);

	void deleteSecteurActivite(Long id);

	SecteurActiviteDTO updateSecteurActivite(SecteurActiviteDTO sa);

	SecteurActiviteDTO retrieveSecteurActivite(Long id);

}
