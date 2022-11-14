package com.tekup.examen.services;

import java.util.List;
import com.tekup.examen.entities.StockDTO;

public interface IStockService {

	List<StockDTO> retrieveAllStocks();

	StockDTO addStock(StockDTO s);

	void deleteStock(Long id);

	StockDTO updateStock(StockDTO u);

	StockDTO retrieveStock(Long id);

	StringBuilder retrieveStatusStock();
}
