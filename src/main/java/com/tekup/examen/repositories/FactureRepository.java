package com.tekup.examen.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tekup.examen.entities.FactureDTO;
import com.tekup.examen.entities.FournisseurDTO;

@Repository
public interface FactureRepository extends JpaRepository<FactureDTO, Long> {

	
	@Query("SELECT f FROM FactureDTO f where f.fournisseurDTO=:fournisseur and f.archivee=false")
	public List<FactureDTO> getFactureByFournisseur(@Param("fournisseur") FournisseurDTO fournisseurDTO);

	
	@Query("SELECT sum(f.montantFacture) FROM FactureDTO f where  f.dateCreationFacture between :startDate"
			+ " and :endDate and f.archivee=false")
	float getTotalFacturesEntreDeuxDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Modifying
	@Query("update FactureDTO f set f.archivee=true where f.idFacture=?1")
	void updateFacture(Long id);
	
}
