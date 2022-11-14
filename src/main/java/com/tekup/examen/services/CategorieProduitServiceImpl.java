package com.tekup.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.examen.entities.CategorieProduitDTO;
import com.tekup.examen.repositories.CategorieProduitRepository;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduitDTO> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduitDTO addCategorieProduit(CategorieProduitDTO cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	@Override
	public CategorieProduitDTO updateCategorieProduit(CategorieProduitDTO cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public CategorieProduitDTO retrieveCategorieProduit(Long id) {
		return categorieProduitRepository.findById(id).orElse(null);
	}

}
