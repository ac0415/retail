package com.enterprise.retail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.retail.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
	List<Store> findByStoreCode(String storeCode);
	List<Store> findByStoreName(String storeName);
}
