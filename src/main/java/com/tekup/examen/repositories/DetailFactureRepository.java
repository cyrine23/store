package com.tekup.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.examen.entities.DetailFactureDTO;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFactureDTO, Long> {

}
