package org.example.project_java.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.project_java.entity.Accounting;
import org.example.project_java.entity.Stock;
import org.example.project_java.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StockService {
    StockRepository stockRepository;
    public StockService(StockRepository stockRepository) {this.stockRepository = stockRepository;}

    public List<Accounting> getAllAccountingByStockId(Long id){
        Stock stock = stockRepository.getStockById(id);
        return stock.getAccountings();
    }

    public Stock getStockById(Long id){
        return stockRepository.getStockById(id);
    }

    public List<Stock> getAllStock(){
        return stockRepository.getAllStocks();
    }

    public String[] getStockName(){
        List<Stock> stocks = stockRepository.getAllStocks();
        String[] stockName = new String[getAllStock().size()];
        for(int i=0;i<stocks.size();i++){
            stockName[i] = stocks.get(i).getName();
        }
        return stockName;
    }

    public List<Stock> getStockByPrice(){
        return stockRepository.getStockByPrice();
    }

    public List<Stock> getStockByCountAndPrice(){
        return stockRepository.getStockByPriceAndCount();
    }

    public List<Accounting> getAccountingByStockId(Long id){
        Stock stock = stockRepository.getAccountingByStockId(id);
        return stock.getAccountings();
    }

}
