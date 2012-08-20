package com.enterprise.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.retail.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
