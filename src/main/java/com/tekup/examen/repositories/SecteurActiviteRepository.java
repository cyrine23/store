package com.tekup.examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekup.examen.entities.SecteurActiviteDTO;

@Repository
public interface SecteurActiviteRepository extends CrudRepository<SecteurActiviteDTO, Long> {

}
