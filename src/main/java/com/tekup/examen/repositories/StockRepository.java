package com.tekup.examen.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tekup.examen.entities.StockDTO;

@Repository
public interface StockRepository extends JpaRepository<StockDTO, Long> {
	

	
	
	
	
	
	
	
	
	
	
	
	@Query("SELECT s FROM StockDTO s where s.qte< s.qteMin")
	List<StockDTO> retrieveStatusStock();
}
