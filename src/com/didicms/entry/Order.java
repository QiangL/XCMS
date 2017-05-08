package com.didicms.entry;

import java.util.Date;

public class Order {
	
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public double getChargingTime() {
		return chargingTime;
	}
	public void setChargingTime(double chargingTime) {
		this.chargingTime = chargingTime;
	}
	public double getBadReview() {
		return badReview;
	}
	public void setBadReview(double badReview) {
		this.badReview = badReview;
	}
	public double getDriverScore() {
		return driverScore;
	}
	public void setDriverScore(double driverScore) {
		this.driverScore = driverScore;
	}
	public DriverGrade getDriverGrade() {
		return driverGrade;
	}
	public void setDriverGrade(DriverGrade driverGrade) {
		this.driverGrade = driverGrade;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	private String driverId;
	private Date date;
	private int quantity;
	private double transactionAmount;
	private double chargingTime;
	private double badReview;
	private double driverScore;
	private DriverGrade driverGrade;
	private double reward;

}
