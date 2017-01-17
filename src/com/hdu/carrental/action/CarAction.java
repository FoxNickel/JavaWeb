package com.hdu.carrental.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.Car;
import com.hdu.carrental.model.User;
import com.hdu.carrental.service.CarService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class CarAction extends ActionSupport implements ModelDriven<Car>{
	Car car = new Car();
	CarService carService = new CarService();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = ServletActionContext.getRequest().getSession();
	public String carInfo(){
		List<Car> cars = carService.findAllCar();
		request.setAttribute("cars", cars);
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(session.getAttribute("username")==null)
			return "NotLogin";
		else
		{
			return "success";
		}
	}
	
	public String carDetail(){
		if(session.getAttribute("username")==(null))
			return "NotLogin";
		else
		try {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("carName",new String (car.getCarName().getBytes("ISO-8859-1"),"UTF-8"));
			request.setAttribute("carID",new String (car.getCarID().getBytes("ISO-8859-1"),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String getAllCars(){
		List<Car> cars = carService.findAllCar();
		request.setAttribute("cars", cars);
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*修改车辆信息界面*/
	public String carInfoEdit(){
		List<Car> cars = carService.findAllCar();
		request.setAttribute("cars", cars);
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*修改车辆信息*/
	public String modifyCarInfo(){
		carService.update(car);
		return SUCCESS;
	}
	
	public String deleteCar(){
		String carID;
		try {
			carID = new String(car.getCarID().getBytes("ISO-8859-1"),"utf-8");
			carService.deleteCarByCarID(carID);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String addCar(){
		carService.addCar(car);
		return SUCCESS;
	}
	@Override
	public Car getModel() {
		return car;
	}
	
}
