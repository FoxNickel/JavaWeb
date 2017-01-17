package com.hdu.carrental.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.Administrator;
import com.hdu.carrental.model.User;
import com.hdu.carrental.service.AdministratorService;
import com.hdu.carrental.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AdministratorAction extends ActionSupport implements ModelDriven<Administrator>{
	private Administrator admin = new Administrator();
	private AdministratorService adminService = new AdministratorService();
	private User user = new User();
	private UserService userService= new UserService();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	/*管理员登录*/
	public String login(){
		session.setAttribute("adminName", admin.getUserName());
		if(adminService.loginVerify(admin.getUserName(), admin.getPassWord()))
			return SUCCESS;
		return ERROR;
	}
	public String logOut(){
		session.invalidate();
		return SUCCESS;
	}
	/*获取用户信息*/
	public String getUsersInfo(){
		ArrayList<User> users = userService.getAllUsers();
		request.setAttribute("users", users);
		return SUCCESS;
	}
	/*修改用户信息界面*/
	public String userInfoEdit(){
		ArrayList<User> users = userService.getAllUsers();
		request.setAttribute("users", users);
		return SUCCESS;
	}
	/*修改用户信息*/
	public String modifyUserInfo(){
		String realName = user.getRealName();
		String userName = user.getUserName();
		String tel = user.getTel();
		String email = user.getEmail();
		userService.modifyUserInfoByAdministrator(userName, tel, realName, email);
		return SUCCESS;
	}
	/*删除用户*/
	public String deleteUser(){
		String username;
		try {
			username = new String(user.getUserName().getBytes("ISO-8859-1"),"utf-8");
			userService.deleteUserByUsername(username);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Override
	public Administrator getModel() {
		return admin;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
