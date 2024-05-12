package org.example.project_java.repository;

import org.example.project_java.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("select s from Stock s where s.id=?1")
    Stock getStockById(Long id);

    @Query("select s from Stock s")
    List<Stock> getAllStocks();

    @Query("select s from Stock s where s.price < 150")
    List<Stock> getStockByPrice();

    @Query("select s from Stock s where s.count > 50 and s.price < 100")
    List<Stock> getStockByPriceAndCount();

    @Query("select s from Stock s where s.id = ?1")
    Stock getAccountingByStockId(long id);

}
