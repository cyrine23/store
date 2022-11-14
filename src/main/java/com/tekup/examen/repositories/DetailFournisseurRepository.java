package com.tekup.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.examen.entities.DetailFournisseurDTO;

@Repository
public interface DetailFournisseurRepository  extends JpaRepository<DetailFournisseurDTO, Long>{

}
