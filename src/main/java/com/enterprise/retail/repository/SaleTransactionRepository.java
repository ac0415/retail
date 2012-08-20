package com.enterprise.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.retail.entity.SaleTransaction;

@Repository
public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Integer>{

}
