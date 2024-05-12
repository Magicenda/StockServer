package org.example.project_java.controller;

import org.example.project_java.entity.Accounting;
import org.example.project_java.entity.Stock;
import org.example.project_java.service.AccountingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounting")
public class AccountingController {
    AccountingService accountingService;

    public AccountingController(AccountingService accountingService) {this.accountingService = accountingService;}

    @GetMapping("/getStockByAccountingId/{id}")
    public ResponseEntity<Stock> getStockByAccountingId(@PathVariable("id") Long id) {
        Stock stock = accountingService.getStockByAccountingId(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Accounting>> getAll() {
        List<Accounting> accountings = accountingService.getAllAccountings();
        return new ResponseEntity<>(accountings,HttpStatus.OK);
    }

    @GetMapping("/getByDefective")
    public ResponseEntity<List<Accounting>> getByDefective() {
        List<Accounting> accountings = accountingService.getAccountingByDefective();
        return new ResponseEntity<>(accountings,HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Accounting>> getByName() {
        List<Accounting> accountings = accountingService.getAccountingByName();
        return new ResponseEntity<>(accountings,HttpStatus.OK);
    }

}
