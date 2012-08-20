package com.enterprise.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.retail.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer>{

}
