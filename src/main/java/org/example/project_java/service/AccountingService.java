package org.example.project_java.service;

import org.example.project_java.entity.Accounting;
import org.example.project_java.entity.Stock;
import org.example.project_java.repository.AccountingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingService {
    AccountingRepository accountingRepository;

    public AccountingService(AccountingRepository accountingRepository) {this.accountingRepository = accountingRepository;}

    public Stock getStockByAccountingId(Long id){
        Accounting accounting = accountingRepository.getStockByAccountingId(id);
        return accounting.getStock();
    }

    public List<Accounting> getAllAccountings(){
        return accountingRepository.getAllAccountings();
    }

    public List<Accounting> getAccountingByDefective(){
        return accountingRepository.getAccountingByDefective();
    }

    public List<Accounting> getAccountingByName(){
        return accountingRepository.findAccountingsByStockNameStartingWithA();
    }
}
