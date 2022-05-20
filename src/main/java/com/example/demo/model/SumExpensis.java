package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sum_expensis")
public class SumExpensis {
	@Column(name = "user_id")
	Integer userId;

	@Id
	@Column(name = "month")
	String month;

	@Column(name = "sum")
	Integer sum;
}
