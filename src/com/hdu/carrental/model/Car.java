package com.hdu.carrental.model;

public class Car {
	private String  carID;
	private String carName;
	private int price;
	private Boolean isRanted;
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Boolean getIsRented() {
		return isRanted;
	}
	public void setIsRented(Boolean isRanted) {
		this.isRanted = isRanted;
	}
	

}
