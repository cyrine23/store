package com.tekup.examen.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tekup.examen.entities.ReglementDTO;

@Repository
public interface ReglementRepository extends CrudRepository<ReglementDTO, Long>{
	@Query("SELECT r FROM ReglementDTO r where r.factureDTO.idFacture=:idFacture")
	List<ReglementDTO> retrieveReglementByFacture(@Param("idFacture") Long idFacture);

	
	@Query("SELECT sum(r.montantPaye) FROM ReglementDTO r where  r.dateReglement between :startDate"
			+ " and :endDate and r.factureDTO.archivee=false")
	float getChiffreAffaireEntreDeuxDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
