package com.hdu.carrental.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.Charges;
import com.hdu.carrental.service.CarService;
import com.hdu.carrental.service.ChargesService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ChargesAction extends ActionSupport implements
		ModelDriven<Charges> {
	private Charges ch = new Charges();
	private ChargesService chs = new ChargesService();
	CarService carService = new CarService();
	private HttpSession session = ServletActionContext.getRequest().getSession();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String chargeInfo() {
		String usn = (String) session.getAttribute("username");
		Charges chfromDB = chs.findByusn(usn);
		ch.setCarID(chfromDB.getCarID());
		ch.setUserName(chfromDB.getUserName());
		ch.setRantedDay(chfromDB.getRantedDay());
		ch.setCirculateDay(chfromDB.getCirculateDay());
		ch.setRentedplace(chfromDB.getRentedplace());
		return SUCCESS;
	}
	
	public String rent(){
		chs.addCharge(ch);//新增订单信息
		carService.setRented(ch.getCarID());//目前车辆状态置为已租
		return "success";		
	}
	
	public String getAllCharges()
	{
		ArrayList<Charges> list =chs.findAllCharges();
		request.setAttribute("Charges",list);
		return SUCCESS;
	}
	
	public String deleteCharges()
	{
		try {
			String carID=new  String (ch.getCarID().getBytes("ISO-8859-1"),"utf-8");
			String username=new String(ch.getUserName().getBytes("ISO-8859-1"),"utf-8");
			ch.setCarID(carID);
			ch.setUserName(username);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chs.deleteCharge(ch);
		return SUCCESS;
	}
	
	public String findCharges()
	{
		try {
			String carid = new  String (ch.getCarID().getBytes("ISO-8859-1"),"utf-8");
			String usn = new String(ch.getUserName().getBytes("ISO-8859-1"),"utf-8");
			Charges ch2=chs.findCharges(usn, carid);
			request.setAttribute("Charge",ch2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String UpdateCharges()
	{
		try {
			String carid = new  String (ch.getCarID().getBytes("ISO-8859-1"),"utf-8");
			String usn = new String(ch.getUserName().getBytes("ISO-8859-1"),"utf-8");
			String rtp=new String(ch.getRentedplace().getBytes("ISO-8859-1"),"utf-8");
			ch.setCarID(carid);
			ch.setUserName(usn);
			ch.setRentedplace(rtp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		chs.UpdateCharges(ch);
		return SUCCESS;
	}
	public Charges getModel() {
		return ch;
	}

}
