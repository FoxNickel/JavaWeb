package com.hdu.carrental.service;

import java.util.ArrayList;
import java.util.List;

import com.hdu.carrental.dao.UserDao;
import com.hdu.carrental.model.User;

public class UserService {
	private UserDao ud = new UserDao();
	
	public Boolean loginVerify(String username,String password){
		User user = ud.findUserByName(username);
		if(password.equals(user.getPassword()))
			return true;
		return false;
	}
	/*从数据库返回用户名为name的用户*/
	public User getUser(String name){
		return ud.findUserByName(name);
	}
	/*增加用户*/
	public void addUser(User user){
		ud.saveUser(user);
	}
	/*修改用户信息*/
	public void modifyProfile(User user){
		ud.updateUser(user);
	}
	/*删除用户*/
	public void deleteUserByUsername(String username){
		ud.deleteUser(username);
	}
	/*返回所有用户*/
	public ArrayList<User> getAllUsers(){
		ArrayList<User> users = ud.findAllUsers();
		return users;
	}
	/*管理员修改用户信息*/
	public void modifyUserInfoByAdministrator(String userName,String tel,String realName,String email){
		ud.updateUserByAdministrator(userName, tel, realName, email);
	}
}
