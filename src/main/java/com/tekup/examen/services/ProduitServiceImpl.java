package com.tekup.examen.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.examen.entities.ProduitDTO;
import com.tekup.examen.entities.StockDTO;
import com.tekup.examen.repositories.CategorieProduitRepository;
import com.tekup.examen.repositories.ProduitRepository;
import com.tekup.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<ProduitDTO> retrieveAllProduits() {
		List<ProduitDTO> produitDTOS =  produitRepository.findAll();
		for (ProduitDTO produitDTO : produitDTOS) {
			log.info(" Produit : " + produitDTO);
		}
		return produitDTOS;
	}

	@Transactional
	public ProduitDTO addProduit(ProduitDTO p) {
		produitRepository.save(p);
		return p;
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return produitRepository.save(p);
	}

	@Override
	public ProduitDTO retrieveProduit(Long produitId) {
		ProduitDTO produitDTO = produitRepository.findById(produitId).orElse(null);
		log.info("produit :" + produitDTO);
		return produitDTO;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		ProduitDTO produit = new ProduitDTO();
		Optional<ProduitDTO> value = this.produitRepository.findById(idProduit);
		StockDTO stock = stockRepository.findById(idStock).orElse(null);

		if(value.isPresent()){
			produit = value.get();
			produit.setStockDTO(stock);

		}
		produitRepository.save(produit);


	}


}