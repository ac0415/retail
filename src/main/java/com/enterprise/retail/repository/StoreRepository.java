package com.enterprise.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.retail.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{

}
