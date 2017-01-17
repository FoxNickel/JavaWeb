package com.hdu.carrental.service;

import java.util.ArrayList;
import java.util.List;

import com.hdu.carrental.dao.CarDao;
import com.hdu.carrental.model.Car;

public class CarService {
	private CarDao cardao=new CarDao();
	public void addCar(Car car)
	{
		cardao.savaCar(car);
	}
	public void deleteCarByCarID(String carID)
	{
		cardao.deleteCar(carID);
	}
	public void update(Car car)
	{
		cardao.update(car);
	}
	public Car findCarById(String id)
	{
		Car car=new Car();
		car=cardao.findCarByID(id);
		return car;	
	}
	public List<Car> findAllCar()
	{
		List<Car> list=new ArrayList<Car>();
		list = cardao.findAllCar();
		return list;
	}
	public void setRented(String carID){
		cardao.updateRentedStat(carID);
	}
}
