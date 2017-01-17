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
	/*�����ݿⷵ���û���Ϊname���û�*/
	public User getUser(String name){
		return ud.findUserByName(name);
	}
	/*�����û�*/
	public void addUser(User user){
		ud.saveUser(user);
	}
	/*�޸��û���Ϣ*/
	public void modifyProfile(User user){
		ud.updateUser(user);
	}
	/*ɾ���û�*/
	public void deleteUserByUsername(String username){
		ud.deleteUser(username);
	}
	/*���������û�*/
	public ArrayList<User> getAllUsers(){
		ArrayList<User> users = ud.findAllUsers();
		return users;
	}
	/*����Ա�޸��û���Ϣ*/
	public void modifyUserInfoByAdministrator(String userName,String tel,String realName,String email){
		ud.updateUserByAdministrator(userName, tel, realName, email);
	}
}
