package org.example.project_java.controller;

import org.example.project_java.entity.Accounting;
import org.example.project_java.entity.Stock;
import org.example.project_java.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    StockService stockService;
    public StockController(StockService stockService) {this.stockService = stockService;}

    @GetMapping("/getAllAccountingByStockId/{id}")
    public ResponseEntity<List<Accounting>> getAllAccountingByStockId(@PathVariable("id") Long id) {
        List<Accounting> accountings = stockService.getAllAccountingByStockId(id);
        return new ResponseEntity<>(accountings, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Stock> getById(@PathVariable("id")Long id) {
        Stock stock = stockService.getStockById(id);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Stock>> getAll() {
        List<Stock> stocks = stockService.getAllStock();
        return new ResponseEntity<>(stocks,HttpStatus.OK);
    }

    @GetMapping("/getAllName")
    public ResponseEntity<String[]> getAllName() {
        String[] stocks = stockService.getStockName();
        return new ResponseEntity<>(stocks,HttpStatus.OK);
    }

    @GetMapping("/getAllPrice150")
    public ResponseEntity<List<Stock>> getAllPrice150() {
        List<Stock> stocks = stockService.getStockByPrice();
        return new ResponseEntity<>(stocks,HttpStatus.OK);
    }

    @GetMapping("/getAllCountAndPrice")
    public ResponseEntity<List<Stock>> getAllCountAndPrice() {
        List<Stock> stocks = stockService.getStockByCountAndPrice();
        return new ResponseEntity<>(stocks,HttpStatus.OK);
    }

    @GetMapping("/getStockById/{id}")
    public ResponseEntity<List<Accounting>> getStockById(@PathVariable("id")Long id) {
        List<Accounting> stock = stockService.getAccountingByStockId(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

}
