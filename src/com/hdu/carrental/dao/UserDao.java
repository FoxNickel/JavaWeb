package com.hdu.carrental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.User;

public class UserDao {
	HttpSession session = ServletActionContext.getRequest().getSession();
	public void saveUser(User user) {
		String sql = "insert into [user] values('" + user.getTel() + "','"
				+ user.getUserName() + "','" + user.getRealName() + "','"
				+ user.getEmail() + "','" + user.getPassword() + "')";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}

	public void deleteUser(String username) {
		String sql = "delete from [user] where userName =" + "'"
				+ username+ "'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}

	public User findUserByName(String name) {
		String sql = "select * from [user] where userName ='"+name+"'";
		DataBaseService.connectDataBase();
		ResultSet rs = DataBaseService.executeQurey(sql);
		User user = new User();
		try {
			while(rs.next()){
				user.setTel(rs.getString(1));
				user.setUserName(rs.getString(2));
				user.setRealName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseService.close();
		return user;
	}

	public ArrayList<User> findAllUsers() {
		String sql = "select * from [user]";
		DataBaseService.connectDataBase();
		ResultSet rs = DataBaseService.executeQurey(sql);
		ArrayList<User> users = new ArrayList<User>();
		try {
			while(rs.next()){
				User user = new User();
				user.setTel(rs.getString(1));
				user.setUserName(rs.getString(2));
				user.setRealName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DataBaseService.close();
		return users;
	}
	
	public void updateUser(User user){
		session.getAttribute("username");
		String sql = "update [user] set tel ='" + user.getTel() + "',realName = '" + user.getRealName() + "',email = '"
				+ user.getEmail() + "',password = '" + user.getPassword() + "' where userName = '"+session.getAttribute("username")+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	
	public void updateUserByAdministrator(String userName,String tel,String realName,String email){
		String sql = "update [user] set tel ='" + tel + "',realName = '" + realName + "',email = '"
				+ email + "' where userName = '"+userName+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
}
