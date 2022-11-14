package com.tekup.examen.controllers;

import java.util.List;

import com.tekup.examen.services.IOperateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tekup.examen.entities.OperateurDTO;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@CrossOrigin("*")
public class OperateurController {

	@Autowired
    IOperateurService operateurService;
	

	@GetMapping("/retrieve-all-operateurs")
	@ResponseBody
	public List<OperateurDTO> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
	}


	@GetMapping("/retrieve-operateur/{operateur-id}")
	@ResponseBody
	public OperateurDTO retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		return operateurService.retrieveOperateur(operateurId);
	}


	@PostMapping("/add-operateur")
	@ResponseBody
	public OperateurDTO addOperateur(@RequestBody OperateurDTO op) {
		return operateurService.addOperateur(op);
	}


	@DeleteMapping("/remove-operateur/{operateur-id}")
	@ResponseBody
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}


	@PutMapping("/modify-operateur")
	@ResponseBody
	public OperateurDTO modifyOperateur(@RequestBody OperateurDTO operateurDTO) {
		return operateurService.updateOperateur(operateurDTO);
	}

	
}
