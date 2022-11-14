package com.tekup.examen.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekup.examen.entities.StockDTO;
import com.tekup.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<StockDTO> retrieveAllStocks() {
		// récuperer la date à l'instant t1
		log.info("In method retrieveAllStocks");
		List<StockDTO> stockDTOS =  stockRepository.findAll();
		for (StockDTO stockDTO : stockDTOS) {
			log.info(" Stock : " + stockDTO);
		}
		log.info("out of method retrieveAllStocks");
		// récuperer la date à l'instant t2
		// temps execution = t2 - t1
		return stockDTOS;
	}

	@Override
	public StockDTO addStock(StockDTO s) {
		// récuperer la date à l'instant t1
		log.info("In method addStock");
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		log.info("In method deleteStock");
		stockRepository.deleteById(stockId);

	}

	@Override
	public StockDTO updateStock(StockDTO s) {
		log.info("In method updateStock");
		return stockRepository.save(s);
	}

	@Override
	public StockDTO retrieveStock(Long stockId) {
		long start = System.currentTimeMillis();
		log.info("In method retrieveStock");
		StockDTO stockDTO = stockRepository.findById(stockId).orElse(null);
		log.info("out of method retrieveStock");
		 long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");

		return stockDTO;
	}

	@Override
	public StringBuilder retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		StringBuilder finalMessage = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		List<StockDTO> stocksEnRouge =  stockRepository.retrieveStatusStock();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			finalMessage.append( newLine + finalMessage + msgDate + newLine + ": le stock "
					+ stocksEnRouge.get(i).getLibelleStock() + " a une quantité de " + stocksEnRouge.get(i).getQte()
					+ " inférieur à la quantité minimale a ne pas dépasser de " + stocksEnRouge.get(i).getQteMin()
					+ newLine);

		}
		log.info(String.valueOf(finalMessage));
		return finalMessage;
	}

}