package org.example.project_java.repository;

import org.example.project_java.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.example.project_java.entity.Accounting;

import java.util.List;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting, Long> {
    @Query("select a from Accounting a where a.id = ?1")
    Accounting getStockByAccountingId(Long id);

    @Query("select a from Accounting a")
    List<Accounting> getAllAccountings();

    @Query("select a from Accounting a where a.defective > 30")
    List<Accounting> getAccountingByDefective();

    @Query("SELECT a FROM Accounting a WHERE a.stock.name LIKE 'a%'")
    List<Accounting> findAccountingsByStockNameStartingWithA();
}

