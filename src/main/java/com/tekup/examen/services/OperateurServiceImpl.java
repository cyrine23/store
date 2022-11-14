package com.tekup.examen.services;

import java.util.List;

import com.tekup.examen.entities.OperateurDTO;
import com.tekup.examen.repositories.OperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
    OperateurRepository operateurRepository;
	@Override
	public List<OperateurDTO> retrieveAllOperateurs() {
		return (List<OperateurDTO>) operateurRepository.findAll();
	}

	@Override
	public OperateurDTO addOperateur(OperateurDTO o) {
		operateurRepository.save(o);
		return o;
	}

	@Override
	public void deleteOperateur(Long id) {
		operateurRepository.deleteById(id);
		
	}

	@Override
	public OperateurDTO updateOperateur(OperateurDTO o) {
		operateurRepository.save(o);
		return o;
	}

	@Override
	public OperateurDTO retrieveOperateur(Long id) {
		return operateurRepository.findById(id).orElse(null);
	}

}
