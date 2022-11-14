package com.tekup.examen.services;

import java.util.List;
import com.tekup.examen.entities.OperateurDTO;


public interface IOperateurService {

	List<OperateurDTO> retrieveAllOperateurs();

	OperateurDTO addOperateur(OperateurDTO o);

	void deleteOperateur(Long id);

	OperateurDTO updateOperateur(OperateurDTO o);

	OperateurDTO retrieveOperateur(Long id);

}
