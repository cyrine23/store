package com.tekup.examen.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekup.examen.entities.OperateurDTO;

@Repository
public interface OperateurRepository extends CrudRepository<OperateurDTO, Long> {

}
