package com.tekup.examen.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tekup.examen.entities.StockDTO;
import com.tekup.examen.services.IStockService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockRestController {

	@Autowired
	IStockService stockService;


	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<StockDTO> getStocks() {
		return stockService.retrieveAllStocks();
	}


	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public StockDTO retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}


	@PostMapping("/add-stock")
	@ResponseBody
	public StockDTO addStock(@RequestBody StockDTO s) {

		return stockService.addStock(s);
	}


	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}


	@PutMapping("/modify-stock")
	@ResponseBody
	public StockDTO modifyStock(@RequestBody StockDTO stockDTO) {
		return stockService.updateStock(stockDTO);
	}


}