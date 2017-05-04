package com.didicms.entry;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public Car() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Exam getIsExam() {
		return isExam;
	}

	public void setIsExam(Exam isExam) {
		this.isExam = isExam;
	}

	private int id;
	private String number;
	private String model;
	private String displacement;
	private String color;
	private String image;
	private Exam isExam;

}
