package com.tekup.examen.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tekup.examen.entities.StockDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockDTOServiceImplTest {
	@Autowired
	IStockService stockService;
	
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		StockDTO s = new StockDTO("stock test",10,100);
		StockDTO savedStockDTO = stockService.addStock(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStockDTO.getLibelleStock());
		stockService.deleteStock(savedStockDTO.getIdStock());
		
	} 
	
	@Test
	public void testAddStockOptimized() {

		StockDTO s = new StockDTO("stock test",10,100);
		StockDTO savedStockDTO = stockService.addStock(s);
		assertNotNull(savedStockDTO.getIdStock());
		assertSame(10, savedStockDTO.getQte());
		assertTrue(savedStockDTO.getQteMin()>0);
		stockService.deleteStock(savedStockDTO.getIdStock());
		
	} 
	
	@Test
	public void testDeleteStock() {
		StockDTO s = new StockDTO("stock test",30,60);
		StockDTO savedStockDTO = stockService.addStock(s);
		stockService.deleteStock(savedStockDTO.getIdStock());
		assertNull(stockService.retrieveStock(savedStockDTO.getIdStock()));
	}

}
