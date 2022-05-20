package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//	List<Category> findByCategoryId(Integer category);

	public Category findByCategoryId(Integer CategoryId);

}