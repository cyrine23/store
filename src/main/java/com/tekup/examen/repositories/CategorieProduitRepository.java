package com.tekup.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.examen.entities.CategorieProduitDTO;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduitDTO, Long>{

}
