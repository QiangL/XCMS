package com.didicms.entry;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Driver {
	public Driver() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Integer getBindCarId() {
		return bindCarId;
	}

	public void setBindCarId(Integer bindCarId) {
		this.bindCarId = bindCarId;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Double getChargingTime() {
		return chargingTime;
	}

	public void setChargingTime(Double chargingTime) {
		this.chargingTime = chargingTime;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Double getBadReview() {
		return badReview;
	}

	public void setBadReview(Double badReview) {
		this.badReview = badReview;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public DriverGrade getGrade() {
		return grade;
	}

	public void setGrade(DriverGrade grade) {
		this.grade = grade;
	}

	public Exam getIsExam() {
		return isExam;
	}

	public void setIsExam(Exam isExam) {
		this.isExam = isExam;
	}

	private String id;
	private String number;
	private String name;
	private String gender;
	private int age;
	private int companyId;
	private Integer bindCarId;
	private Integer orderQuantity;
	private Double chargingTime;
	private BigDecimal transactionAmount;
	private Double badReview;
	private Double score;
	private DriverGrade grade;
	private Exam isExam;

}
