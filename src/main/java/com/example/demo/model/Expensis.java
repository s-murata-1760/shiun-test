package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "expensis")
public class Expensis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expensis_id")
	private Integer expensisId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "expensis_name")
	private String expensisName;

	@Column(name = "expensis_money")
	private Integer expensisMoney;

	@Column(name = "expensis_date")
	private String expensisDate;

	@Column(name = "category_id")
	private Integer categoryId;

	@Transient
	private String categoryName;

	public Expensis() {

	}

	public Expensis(Integer userId, String expensisName, Integer expensisMoney, String expensisDate,
			Integer categoryId) {
		super();
		this.userId = userId;
		this.expensisName = expensisName;
		this.expensisMoney = expensisMoney;
		this.expensisDate = expensisDate;
		this.categoryId = categoryId;
	}

	public Expensis(Integer expensisId, Integer userId, String expensisName, Integer expensisMoney, String expensisDate,
			Integer categoryId) {
		super();
		this.userId = userId;
		this.expensisName = expensisName;
		this.expensisMoney = expensisMoney;
		this.expensisDate = expensisDate;
		this.categoryId = categoryId;
	}

	public Integer getExpensisId() {
		return expensisId;
	}

	public void setExpensisId(Integer expensisId) {
		this.expensisId = expensisId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExpensisName() {
		return expensisName;
	}

	public void setExpensisName(String expensisName) {
		this.expensisName = expensisName;
	}

	public Integer getExpensisMoney() {
		return expensisMoney;
	}

	public void setExpensisMoney(Integer expensisMoney) {
		this.expensisMoney = expensisMoney;
	}

	public String getExpensisDate() {
		return expensisDate;
	}

	public void setExpensisDate(String expensisDate) {
		this.expensisDate = expensisDate;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
