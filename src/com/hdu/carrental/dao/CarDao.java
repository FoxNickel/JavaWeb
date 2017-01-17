package com.hdu.carrental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hdu.carrental.model.Car;

public class CarDao {
	public void savaCar(Car car)
	{
		byte a = (byte) (car.getIsRented() ? 0x01 : 0x00);
		String sql="insert into car values('"+car.getCarID()+"','"+car.getCarName()+"','"+car.getPrice()+"','"+a+"')";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public void deleteCar(String carID)
	{
		String sql="delete from car where carID = '"+carID+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public Car findCarByID(String id)
	{
		String sql = "select from car where carID = ' "+id+"'";
		DataBaseService.connectDataBase();
		ResultSet rs=DataBaseService.executeQurey(sql);
		Car car=new Car();
		try {
			boolean b = (rs.getByte(3) == 0x00) ? false : true;
			car.setCarID(rs.getString(1));
			car.setCarName(rs.getString(2));
			car.setIsRented(b);
			car.setPrice(rs.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseService.close();
		return car;
		
	}
	public List<Car> findAllCar()
	{
		String sql="select * from car";
		DataBaseService.connectDataBase();
		ResultSet rs=DataBaseService.executeQurey(sql);
		
		List<Car> list = new ArrayList<Car>();
		try {
			while(rs.next())
			{
				Car car=new Car();
				car.setCarID(rs.getString(1));
				car.setCarName(rs.getString(2));
				car.setPrice(rs.getInt(3));
				boolean b = (rs.getByte(4) == 0x00) ? false : true;
				car.setIsRented(b);
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseService.close();
		return list;
		
	}
	public void update(Car car)
	{
		byte a = (byte) (car.getIsRented() ? 0x01 : 0x00);
		String sql="update car set carName='"+car.getCarName()+"',price='"+car.getPrice()+"',IsRanted='"+a+"' where carID = '"+car.getCarID()+"'" ;
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public void updateRentedStat(String carID){
		String sql = "update car set isRanted = 1 where carID = '"+carID+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
}
