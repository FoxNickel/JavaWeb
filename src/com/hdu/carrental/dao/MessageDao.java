package com.hdu.carrental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.Messages;
import com.hdu.carrental.model.User;

public class MessageDao {
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	public void saveMessage(Messages msg){
		String sql = "insert into message(userName,message) values ('"+session.getAttribute("username")+"','"+msg.getMessage()+"')";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	
	public void deleteMessage(Messages msg){
		String sql = "delete from message where userName = '"+msg.getMessageOwner()+"'and message = '"+msg.getMessage()+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	
	public void updateMessage(Messages msg,String oldMessage){
		String sql = "update message set message = '"+msg.getMessage()+"',response = '"+msg.getResponse()+"' where userName = '"+msg.getMessageOwner()+"' and message = '"+oldMessage+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public Messages findMessageByName(String username){
		Messages msg = new Messages();
		String sql = "select * from message where userName = '"+username+"'";
		DataBaseService.connectDataBase();
		ResultSet rs = DataBaseService.executeQurey(sql);
		try {
			while(rs.next()){
				msg.setMessageOwner(rs.getString(1));
				msg.setMessage(rs.getString(2));
				msg.setResponse(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseService.close();
		return msg;
	}
	
	public ArrayList<Messages> findAllMessages() {
		String sql = "select * from message";
		DataBaseService.connectDataBase();
		ResultSet rs = DataBaseService.executeQurey(sql);
		ArrayList<Messages> msgs = new ArrayList<Messages>();
		try {
			while(rs.next()){
				Messages msg = new Messages();
				msg.setMessageOwner(rs.getString(1));
				msg.setMessage(rs.getString(2));
				msg.setResponse(rs.getString(3));
				msgs.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseService.close();
		return msgs;
	}
}
