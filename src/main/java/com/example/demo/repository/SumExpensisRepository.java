package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SumExpensis;

@Repository
public interface SumExpensisRepository extends JpaRepository<SumExpensis, Integer> {
	@Query(value = "select user_id, sum(sum) from sum_expensis group by user_id having user_id=:i", nativeQuery = true)
	List<Object[]> selectSum(Integer i);

//	@Query(value = "select user_id AS \"user_id\",max(substring(expensis_date, 1, 6)) AS month, sum(expensis_money) from expensis group by user_id having user_id=:i,substring(expensis_date, 1, 6)  order by user_id,substring(expensis_date, 1, 6)")
//	@Query(value = "select * from expensis where user_id=:i", nativeQuery = true)
//	List<Object[]> userExpensis(Integer i);

}
