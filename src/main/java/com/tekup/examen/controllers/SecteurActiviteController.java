package com.tekup.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tekup.examen.entities.SecteurActiviteDTO;
import com.tekup.examen.services.ISecteurActiviteService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {

	@Autowired
	ISecteurActiviteService secteurActiviteService;
	

	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurActiviteDTO> getSecteurActivite() {
		return secteurActiviteService.retrieveAllSecteurActivite();
	}


	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActiviteDTO retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}


	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public SecteurActiviteDTO addSecteurActivite(@RequestBody SecteurActiviteDTO sa) {
		return secteurActiviteService.addSecteurActivite(sa);
	}


	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}


	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public SecteurActiviteDTO modifySecteurActivite(@RequestBody SecteurActiviteDTO secteurActiviteDTO) {
		return secteurActiviteService.updateSecteurActivite(secteurActiviteDTO);
	}

	
}
