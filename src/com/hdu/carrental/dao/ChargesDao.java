package com.hdu.carrental.dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.Charges;

public class ChargesDao {
	HttpSession session = ServletActionContext.getRequest().getSession();
    public void insertCharges(Charges ch)
    {
    	String sql="insert into charge values('"+ch.getCarID()+"','"+session.getAttribute("username")+"','"+ch.getRantedDay()+"','"+ch.getCirculateDay()+"','"+ch.getRentedplace()+"')";
    	DataBaseService.connectDataBase();
    	DataBaseService.executeUpdate(sql);
    	DataBaseService.close();
    }
    
    
    public void deleteCharges(Charges ch)
    {
    	String sql="delete from charge where username='"+ch.getUserName()+"'and carID='"+ch.getCarID()+"';";
    	DataBaseService.connectDataBase();
    	DataBaseService.executeUpdate(sql);
    	DataBaseService.close();
    }
    public void updateCharges(Charges ch)
    {
    	String sql="Update Charge set rentedDay='"+ch.getRantedDay()+"',circulateDay='"+
                              ch.getCirculateDay()+"',rentedPlace='"+ch.getRentedplace()+"' where username='"+ch.getUserName()+"'and carID='"+ch.getCarID()+"'";
    	DataBaseService.connectDataBase();
    	DataBaseService.executeUpdate(sql);
    	DataBaseService.close();
    	
    }
    
    
    public Charges findByusn(String usn)
    {
    	String sql="select *from charge where userName ='"+usn+"'";
    	DataBaseService.connectDataBase();
    	ResultSet rs=DataBaseService.executeQurey(sql);
    	Charges ch = new Charges();
    	try {
			if(rs.next()){
				ch.setCarID(rs.getString(1));
				ch.setUserName(rs.getString(2));
				ch.setRantedDay(rs.getString(3));
				ch.setCirculateDay(rs.getString(4));
				ch.setRentedplace(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DataBaseService.close();
    	return ch;
    }
    public Charges findCharges(String usn,String carid)
    {
    	String sql="select *from charge where userName ='"+usn+"'and carId='"+carid+"'";
    	DataBaseService.connectDataBase();
    	ResultSet rs=DataBaseService.executeQurey(sql);
    	Charges ch = new Charges();
    	try {
			while(rs.next()){
				ch.setCarID(rs.getString(1));
				ch.setUserName(rs.getString(2));
				ch.setRantedDay(rs.getString(3));
				ch.setCirculateDay(rs.getString(4));
				ch.setRentedplace(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DataBaseService.close();
    	return ch;
    }
    
    public ArrayList<Charges> findAllCharges()
    {
    	String sql="select *from charge";
    	DataBaseService.connectDataBase();
    	ResultSet rs=DataBaseService.executeQurey(sql);
    	ArrayList<Charges> list = new ArrayList<Charges>();
    	try {
			while(rs.next()){
				Charges ch=new Charges();
				ch.setCarID(rs.getString(1));
				ch.setUserName(rs.getString(2));
				ch.setRantedDay(rs.getString(3));
				ch.setCirculateDay(rs.getString(4));
				ch.setRentedplace(rs.getString(5));
			    list.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	DataBaseService.close();
    	return list;
    } 
}
